package View;

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
import java.awt.Image;
import java.io.ByteArrayInputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * <span>Descripción:</span>
 * <p>
 * Se encarga de crear la vista del módulo de Asociar Huella de los Pacientes.
 * </p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */
public class FormEnterBrand extends javax.swing.JFrame {

    /**
     * Variables y constantes de la clase {@link FormEnterBrand}.
     *
     */
    //variables globales
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
     * Método Constructor de FormEnterBrand</p>
     * 
     * @param fp Recibe un Objeto de tipo {@link FormPatientsManagement}
     */
    public FormEnterBrand(FormPatientsManagement fp) {
        initComponents();

        Iniciar();
        start();
        setLocationRelativeTo(null);
        this.setResizable(false);
        this.fp = fp;

        //Establecemos el icono del proyecto en la barra de tareas y superior del Frame  
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        this.setTitle("RUIPI Lector de Huellas");

    }
    
    //Inicia la lectura de la huella
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
                        System.out.println("El Sensor de Huella Digital esta Desactivado o no Conectado");
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

    //Procesa la captura de la huella ingresada
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
            Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear
            Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear
            Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

            // Dibuja la huella dactilar capturada.
            Image image = CrearImagenHuella(sample);
            pc.clearTable();
            DibujarHuella(image);

        } catch (DPFPImageQualityException ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            EstadoHuellas();
            // Comprueba si la plantilla se ha creado.
            switch (Reclutador.getTemplateStatus()) {
                case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
                    stop();
                    setTemplate(Reclutador.getTemplate());
                    btnGuardarHuella.setEnabled(true);

                    break;

                case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
                    Reclutador.clear();
                    stop();
                    setTemplate(null);
                    JOptionPane.showMessageDialog(this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
                    start();
                    break;
            }
        }
    }

    //Extrae las características de la huella ingresada 
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

    //Crea una imágen a partir de las características de la huella ingresada
    /**
     *
     * @param sample
     * @return
     */
    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    //Dibuja la huella en el campo del frame FormEnterBrand
    /**
     *
     * @param image
     */
    public void DibujarHuella(Image image) {
        huellaImg.setIcon(new ImageIcon(
                image.getScaledInstance(huellaImg.getWidth(), huellaImg.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    //Muestra por consola el número de huellas necesarias para crear el template
    /**
     *
     */
    public void EstadoHuellas() {
        System.out.println("Muestra de Huellas Necesarias para Guardar Template: " + Reclutador.getFeaturesNeeded());
    }

    //Detiene la captura de la huella
    /**
     *
     */
    public void stop() {
        Lector.stopCapture();
        //EnviarTexto("No se está usando el Lector de Huella Dactilar ");
    }

    //Inicia la captura de la huella
    /**
     *
     */
    public void start() {
        Lector.startCapture();
        //EnviarTexto("Utilizando el Lector de Huella Dactilar ");
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
        btnGuardarHuella = new javax.swing.JButton();
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

        btnGuardarHuella.setBackground(new java.awt.Color(108, 216, 158));
        btnGuardarHuella.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        btnGuardarHuella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fingerprint_20px.png"))); // NOI18N
        btnGuardarHuella.setText("Guardar Huella");
        btnGuardarHuella.setEnabled(false);
        btnGuardarHuella.setFocusPainted(false);
        btnGuardarHuella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarHuellaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(108, 216, 158));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(37, 51, 61));
        jLabel1.setText("INGRESA 4 VECES LA HUELLA A ASOCIAR ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(huella, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarHuella, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(huella, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarHuella)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarHuellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHuellaActionPerformed

        ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        fp.setHuellaPaciente(datosHuella);
        Integer tamañoHuella = template.serialize().length;
        fp.setSizeHuella(tamañoHuella);
        fp.isOpen = true;
        dispose();
        fp.isOpen = false;
        pc.clearTable();
        pc.disableButtons(true, false, false);
        pc.btnNewOn();
        fp.lblIndicadorQuery.setText("!HUELLA CARGADA¡ ¿Quieres guardar?");


    }//GEN-LAST:event_btnGuardarHuellaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fp.isOpen = false;
        if (!fp.isOpen) {
            pc.disableButtons(false, false, false);
            huella = null;
        }
        pc.btnNewOn();
        stop();
        fp.lblIndicadorQuery.setText("¡EL LECTOR SE CERRÓ! Asocia una huella u oprime 'Nuevo' para reiniciar el formulario.");

    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarHuella;
    private javax.swing.JPanel huella;
    private javax.swing.JLabel huellaImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return template - Retorna el template creado a partir de las
     * caracteríssticas de la huella
     */
    public DPFPTemplate getTemplate() {
        return template;
    }

    /**
     * @param template Recibe el template de la huella
     */
    public void setTemplate(DPFPTemplate template) {
        this.template = template;
    }

}
