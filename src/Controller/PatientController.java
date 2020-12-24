package Controller;

import Model.UserDAO;
import Model.Patient;
import Model.User;
import View.FormEnterBrand;
import View.FormIdentify;
import View.FormPatientsManagement;
import static View.FormPatientsManagement.pc;
import View.UIUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 * <span>Descripción:</span>
 * <p>
 * Implementa {@link ActionListener}. Se encarga de ejecutar la lógica de los
 * eventos del click desencadenados por el usuario en la vista
 * {@link FormPatientsManagement}.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 * @see ActionListener
 * @see FormPatientsManagement
 */
public class PatientController implements ActionListener {

    /**
     * Variables y constantes de la clase {@link  PatientController}.
     *
     */
    private final UserDAO udao;
    private final User u;
    public final FormPatientsManagement fp;
    private final Patient p;

    /**
     * <p>
     * Constructor de la clase PatientController</p>
     *
     * @param u Recibe un objeto de la clase {@link User}
     * @param udao Recibe un objeto de la clase {@link UserDAO}
     * @param fp Recibe un objeto de la clase {@link FormPatientsManagement}
     * @param p Recibe un objeto de la clase {@link Patient}
     */
    public PatientController(User u, UserDAO udao, FormPatientsManagement fp, Patient p) {

        this.u = u;
        this.udao = udao;
        this.fp = fp;
        this.p = p;

        this.fp.btnAssociate.addActionListener(this);
        this.fp.btnSaveP.addActionListener(this);
        this.fp.btnSearchUpdateP.addActionListener(this);
        this.fp.btnIdentify.addActionListener(this);
        this.fp.btnDeleteP.addActionListener(this);
        this.fp.btnNewP.addActionListener(this);
        this.fp.tableP.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editRowTable(evt);
                fp.lblIndicadorQuery.setText("PUEDES OBSERVAR O ACTUALIZAR LOS DATOS DE ESTE PACIENTE. Para actualizar, debes ASOCIAR su huella nuevamente.");
            }
        });
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Sobreescribe el método {@code actionPerformed(ActionEvent e)} para
     * dotarlo del comportamiento necesario para desencadenar los eventos del
     * click del botón en la vista {@link FormPatientsManagement}.</p>
     *
     * @see FormPatientsManagement
     * @see ActionEvent
     * @param e Recibe un objeto de tipo ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fp.btnAssociate) {
            fp.lblIndicadorQuery.setText("ASOCIANDO UNA HUELLA.");
            asociate();
            btnNewOff();
        }
        if (e.getSource() == fp.btnSaveP) {
            saveP();
            fp.lblIndicadorQuery.setText("PUEDES BUSCAR, IDENTIFICAR O REGISTRAR UN NUEVO PACIENTE.");
        }
        if (e.getSource() == fp.btnSearchUpdateP) {
            fp.lblIndicadorQuery.setText("PUEDES BUSCAR, IDENTIFICAR O REGISTRAR UN NUEVO PACIENTE.");
            fp.search();

        }
        if (e.getSource() == fp.btnIdentify) {
            btnNewOff();
            btnAsociateOff();
            fp.lblIndicadorQuery.setText("IDENTIFICA UN PACIENTE.");
            fp.identify();
        }
        if (e.getSource() == fp.btnNewP) {
            fp.lblIndicadorQuery.setText("PUEDES BUSCAR, IDENTIFICAR O REGISTRAR UN NUEVO PACIENTE.");
            clearFields();
            btnAsociateOn();

        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Método del botón "Asociar Huella" que se encarga de crear una instancia
     * del lector de huellas que asocia la huella dactilar del paciente. Solo se
     * podrá instanciar un lector de huellas a la vez, sea
     * {@link FormEnterBrand} ó {@link FormIdentify}.</p>
     */
    public void asociate() {

        disableButtons(false, false, false);

        if (fp.isOpen == false) {
            fp.asociarHuella = new FormEnterBrand(fp);
            fp.asociarHuella.setVisible(true);
            fp.isOpen = true;
            pc.clearTable();

        } else {
            JOptionPane.showMessageDialog(null, "Ya hay una ventana del 'Lector de Huellas' abierta", "Lector en uso", JOptionPane.WARNING_MESSAGE);
            btnSearchUpdateOn();
        }

    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de realizar la inserción o la actualización de los datos del
     * paciente siempre y cuando los campos obligatorios marcados con asterísco
     * (*) no estén vaciós y dependiendo si es una búsqueda o la inserción de un
     * nuevo paciente.</p>
     */
    public void saveP() {

        pc.clearTable();

        if (emptyFields()) {

            if (fp.tipoQuery) {
                fp.Insert();
                fp.txtNombrePaciente.requestFocus();

            } else {
                fp.Update();
                fp.tipoQuery = true;
            }

            pc.clearFields();
            fp.isOpen = false;

            pc.disableButtons(false, true, true);
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Retorna true o false dependiendo si los campos obligatorios marcados con
     * asterísco (*) están vaciós o nó y habilita el botón de "Guardar".
     * </p>
     *
     * @return boolean - Puede retornar true o false.
     */
    public boolean emptyFields() {

        if (fp.txtNombrePaciente.getText().isEmpty() || fp.huellaPaciente == null) {
            JOptionPane.showMessageDialog(null, "Los campos con asterísco ( * ) son obligatorios", "Hay campos vacíos", JOptionPane.WARNING_MESSAGE);
            fp.txtNombrePaciente.requestFocus();
            return false;

        } else {
            pc.btnSavePOn();
            return true;

        }

    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Limpia todos los campos del formulario {@link FormPatientsManagement} y
     * lo reinicia.
     * </p>
     */
    public void clearFields() {

        fp.txtIdPaciente.setText("");
        fp.txtNombrePaciente.setText("");
        fp.txtApellidoPaciente.setText("");
        fp.comboMunicipio.setSelectedIndex(0);
        fp.comboComunidad.setSelectedIndex(0);
        fp.comboTipoDoc.setSelectedIndex(0);
        fp.txtNumDoc.setText("");
        fp.txtCiudadO.setText("");
        fp.txtDepO.setText("");
        fp.comboSexo.setSelectedIndex(0);
        fp.comboRh.setSelectedIndex(0);
        fp.comboGestante.setSelectedIndex(0);
        fp.comboEtnia.setSelectedIndex(0);
        fp.comboPyDT.setSelectedIndex(0);
        fp.txtTel.setText("");
        fp.txtDireccion.setText("");
        fp.txtEmail.setText("");
        fp.dateRegister.setText("");
        fp.huellaPaciente = null;
        actualDate();

        fp.setQueryInsert();
        clearTable();
        disableButtons(false, true, true);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Limpia los campos de la tabla del formulario
     * {@link FormPatientsManagement}.
     * </p>
     */
    public void clearTable() {
        int rows = fp.tableP.getRowCount();
        for (int i = 0; i < rows; i++) {
            fp.modt.removeRow(0);
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Establece la fecha del calendario para "Fecha de Nacimiento" con la fecha
     * actual y evita que se ingresen fechas no válidas cuyo año date del 1899 o
     * antes y fechas posteriores a la actual.
     * </p>
     */
    public void actualDate() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -120);
        Date min = cal.getTime();

        Date max = new Date();//actual date

        Date fecha = new Date();
        fp.dateFNacimiento.setDate(fecha);
        fp.dateFNacimiento.setSelectableDateRange(min, max);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Cambia el color de fondo del JDateChooser "Fecha de Nacimiento".
     * </p>
     */
    public void setBgcDateChooser() {
        for (Component c : fp.dateFNacimiento.getComponents()) {
            ((JComponent) c).setBackground(new Color(47, 61, 71));
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Cambia el color de fondo del JComboBox.
     * </p>
     */
    public void setBgcComboBox() {
        fp.comboPyDT.setBackground(UIUtils.COLOR_BACKGROUND);
        fp.comboPyDT.setForeground(UIUtils.COLOR_INTERACTIVE);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Desactiva el botón de "Asociar Huella".
     * </p>
     */
    public void btnAsociateOff() {

        fp.btnAssociate.setEnabled(false);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Activa el botón de "Asociar Huella".
     * </p>
     */
    public void btnAsociateOn() {

        fp.btnAssociate.setEnabled(true);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Desactiva el botón de "Buscar y Actualizar".
     * </p>
     */
    public void btnSearchUpdateOff() {

        fp.btnSearchUpdateP.setEnabled(false);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Activa el botón de "Buscar y Actualizar".
     * </p>
     */
    public void btnSearchUpdateOn() {

        fp.btnSearchUpdateP.setEnabled(true);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Desactiva el botón de "Guardar".
     * </p>
     */
    public void btnSavePOff() {
        fp.btnSaveP.setEnabled(false);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Activa el botón de "Guardar".
     * </p>
     */
    public void btnSavePOn() {
        fp.btnSaveP.setEnabled(true);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Desactiva el botón de "Nuevo".
     * </p>
     */
    public void btnNewOff() {
        fp.btnNewP.setEnabled(false);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Activa el botón de "Nuevo".
     * </p>
     */
    public void btnNewOn() {
        fp.btnNewP.setEnabled(true);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Desactiva los botones de Guardar, Buscar y Actualizar e Identificar
     * dependiendo de los parámetros booleanos que se le pasen.
     * </p>
     *
     * @param save Recibe un booleano (true o false)
     * @param search Recibe un booleano (true o false)
     * @param identify Recibe un booleano (true o false)
     */
    public void disableButtons(boolean save, boolean search, boolean identify) {
        fp.btnSaveP.setEnabled(save);
        fp.btnSearchUpdateP.setEnabled(search);
        fp.btnIdentify.setEnabled(identify);
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Al dar doble click en un campo de la tabla se cargan los datos del
     * paciente o fila seleccionada, en caso de que uno de los datos sea null
     * entonces establece un campo vacío o el index del combobox en 0, según sea
     * el caso en el formulario {@link FormPatientsManagement} para su
     * actualización.</p>
     *
     * @param evt Recibe un objeto de tipo MouseEvent
     */
    public void editRowTable(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {

            try {
                fp.txtIdPaciente.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 0).toString()));
            } catch (Exception e) {
            }

            fp.id_paciente = Integer.valueOf(fp.txtIdPaciente.getText());

            try {
                fp.txtNombrePaciente.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 1).toString()));
            } catch (Exception e) {
            }
            try {
                fp.txtApellidoPaciente.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 2).toString()));
            } catch (Exception e) {
            }
            try {
                fp.dateFNacimiento.setDate((Date) fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 3));
            } catch (Exception e) {
            }
            try {
                fp.comboMunicipio.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 4).toString()));
            } catch (Exception e) {
                fp.comboMunicipio.setSelectedIndex(0);
            }
            try {
                fp.comboComunidad.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 5).toString()));
            } catch (Exception e) {
                fp.comboComunidad.setSelectedIndex(0);
            }
            try {
                fp.comboTipoDoc.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 6).toString()));
            } catch (Exception e) {
            }
            try {
                fp.txtNumDoc.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 7).toString()));
            } catch (Exception e) {
            }
            try {
                fp.txtCiudadO.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 8).toString()));
            } catch (Exception e) {
            }
            try {
                fp.txtDepO.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 9).toString()));
            } catch (Exception e) {
            }
            try {
                fp.comboSexo.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 10).toString()));
            } catch (Exception e) {
                fp.comboSexo.setSelectedIndex(0);
            }
            try {
                fp.comboRh.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 11).toString()));
            } catch (Exception e) {
                fp.comboRh.setSelectedIndex(0);
            }
            try {
                fp.comboGestante.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 12).toString()));
            } catch (Exception e) {
                fp.comboGestante.setSelectedIndex(0);
            }

            try {
                fp.comboEtnia.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 13).toString()));
            } catch (Exception e) {
                fp.comboEtnia.setSelectedIndex(0);
            }
            try {
                fp.comboPyDT.setSelectedItem((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 14).toString()));
            } catch (Exception e) {
            }
            try {
                fp.txtTel.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 15).toString()));
            } catch (Exception e) {
            }
            try {
                fp.txtDireccion.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 16).toString()));
            } catch (Exception e) {
            }
            try {
                fp.txtEmail.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 17).toString()));
            } catch (Exception e) {
            }
            try {
                fp.dateRegister.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 18).toString()));
            } catch (Exception e) {
            }

            fp.tipoQuery = false;
            disableButtons(false, true, false);
        }
    }

}
