package View;

import Model.Conexion;
import static View.FormPatientsManagement.pc;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.sql.ResultSet;

/**
 * <span>Descripción:</span>
 * <p>
 * Se encarga de crear la vista del módulo de Identificar Pacientes.
 * </p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class FormIdentify extends javax.swing.JFrame {

    /**
     * Variables y constantes de la clase {@link FormIdentify}.
     *
     */
    //Varible que permite iniciar el dispositivo de lector de huella conectado
    // con sus distintos metodos.
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

    //Varible que permite establecer las capturas de la huellas, para determina sus caracteristicas
    // y poder estimar la creacion de un template de la huella para luego poder guardarla
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

    //Esta variable tambien captura una huella del lector y crea sus caracteristcas para auntetificarla
    // o verificarla con alguna guardada en la BD
    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

    //Variable que para crear el template de la huella luego de que se hallan creado las caracteriticas
    // necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;
    private final FormPatientsManagement fp;

    /**
     * <p>
     * Método Constructor de FormIdentify</p>
     * 
     * @param fp Recibe un Objeto de tipo {@link FormPatientsManagement}
     */
    public FormIdentify(FormPatientsManagement fp) {
        initComponents();

        Iniciar();
        start();
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.fp = fp;
        pc.btnSearchUpdateOff();
        pc.clearTable();

        //Establecemos el icono del proyecto en la barra de tareas y superior del Frame  
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        this.setTitle("RUIPI Lector de Huellas");
    }

    /**
     *
     */
    protected void Iniciar() {
        Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("La Huella Digital ha sido Capturada");
                        ProcesarCaptura(e.getSample());
                    }
                });
            }
        });

        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("El Sensor de Huella Digital esta Activado o Conectado");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("El Sensor de Huella Digital esta Desactivado o Desconectado");
                    }
                });
            }
        });

        Lector.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("El dedo ha sido colocado sobre el Lector de Huella");
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("El dedo ha sido quitado del Lector de Huella");
                    }
                });
            }
        });

        Lector.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.out.println("Error: " + e.getError());
                    }
                });
            }
        });
    }

    /**
     *
     * @param sample
     */
    public void ProcesarCaptura(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
        if (featuresinscripcion != null)
     try {
            System.out.println("Las Caracteristicas de la Huella han sido creada");
            Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

            // Dibuja la huella dactilar capturada.
            Image image = CrearImagenHuella(sample);
            DibujarHuella(image);
            identificar();
            Reclutador.clear();
            huellaImg.setIcon(new ImageIcon("resource/ruipiLector.png"));
            repaint();

        } catch (DPFPImageQualityException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            EstadoHuellas();
            // Comprueba si la plantilla se ha creado.
            switch (Reclutador.getTemplateStatus()) {
                case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
                    stop();
                    setTemplate(Reclutador.getTemplate());

                    break;

                case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
                    Reclutador.clear();
                    stop();
                    setTemplate(null);
                    JOptionPane.showMessageDialog(this, "La Plantilla de la Huella NO pudo ser creada, Repita el Proceso", "Inscripcion de huellas dactilares", JOptionPane.ERROR_MESSAGE);
                    start();
                    break;
            }
        }
    }

    /**
     *
     * @param sample
     * @param purpose
     * @return
     */
    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    /**
     *
     * @param sample
     * @return
     */
    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    /**
     *
     * @param image
     */
    public void DibujarHuella(Image image) {
        huellaImg.setIcon(new ImageIcon(
                image.getScaledInstance(huellaImg.getWidth(), huellaImg.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    /**
     *
     */
    public void EstadoHuellas() {
        System.out.println("Muestra de Huellas Necesarias para Guardar Template " + Reclutador.getFeaturesNeeded());
    }

    /**
     *
     */
    public void stop() {
        Lector.stopCapture();
    }

    /**
     *
     */
    public void start() {
        Lector.startCapture();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        huella = new javax.swing.JPanel();
        huellaImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(37, 51, 61));

        huella.setLayout(new java.awt.BorderLayout());

        huellaImg.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(108, 216, 158)));
        huella.add(huellaImg, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(108, 216, 158));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(37, 51, 61));
        jLabel1.setText("INGRESA LA HUELLA A IDENTIFICAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(huella, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(huella, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closing();
        fp.lblIndicadorQuery.setText("!EL LECTOR SE CERRÓ¡ Identifica un paciente u oprime 'Nuevo' para reiniciar el formulario.");

    }//GEN-LAST:event_formWindowClosing

    /**
     *
     */
    public void closing() {
        fp.isOpen = false;
        if (!fp.isOpen) {
            pc.disableButtons(false, false, true);
        }
        pc.btnNewOn();
        stop();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel huella;
    private javax.swing.JLabel huellaImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the template
     */
    public DPFPTemplate getTemplate() {
        return template;
    }

    /**
     * @param template the template to set
     */
    public void setTemplate(DPFPTemplate template) {
        this.template = template;
    }

    private void identificar() {
        Conexion cn = new Conexion();
        Connection cnn = cn.getConnection();
        try {
            PreparedStatement ps = cnn.prepareStatement("SELECT pe.id_persona, pe.nombre, pe.apellido,"
                    + " pe.email, pe.tipo_documento, pe.numero_documento, pe.celular, pe.fecha_nacimiento,"
                    + " pe.ciudad_origen, pe.departamento_origen, pe.direccion,"
                    + " pa.id_paciente, pa.huella, pa.rh, pa.gestante, pa.sexo, pa.etnia, pa.comunidad, pa.municipio,"
                    + " pa.fecha_registro, pa.id_persona, pa.id_programaPyDT"
                    + " FROM Persona AS pe INNER JOIN Paciente AS pa ON pe.id_persona=pa.id_persona");

            ResultSet rs = ps.executeQuery();
            boolean existe = false;

            while (rs.next()) {
                byte huellas[] = rs.getBytes("huella");
                String nombre = rs.getString("nombre");
                int id = rs.getInt("id_paciente");

                //Crea una nueva plantilla a partir de la guardada en la base de datos
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(huellas);
                //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
                setTemplate(referenceTemplate);

                // Compara las caracteriticas de la huella recientemente capturda con la
                // alguna plantilla guardada en la base de datos que coincide con ese tipo
                DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

                if (result.isVerified()) {

                    fp.findP(id);
                    pc.clearTable();
                    pc.btnSearchUpdateOff();
                    JOptionPane.showMessageDialog(null, "El paciente '" + nombre + "' está registrado en RUIPI", "Paciente identificado", JOptionPane.INFORMATION_MESSAGE);
                    fp.lblIndicadorQuery.setText("PUEDES OBSERVAR O ACTUALIZAR LOS DATOS DE ESTE PACIENTE. Para actualizar, debes ASOCIAR su huella nuevamente.");
                    existe = true;
                    closing();
                    dispose();

                    pc.disableButtons(false, false, true);
                    pc.btnNewOn();
                    pc.btnAsociateOn();
                }
            }

            setTemplate(null);
            if (!existe) {

                JOptionPane.showMessageDialog(null, "El paciente NO está registrado en RUIPI", "No hay registro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormPatientsManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
