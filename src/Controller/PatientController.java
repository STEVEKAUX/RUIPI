package Controller;

import Model.UserDAO;
import Model.Patient;
import Model.User;
import View.FormPatientsManagement;
import View.UIUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComponent;

//Crea la clase PatientController
public class PatientController implements ActionListener {

    //Declara las variables globales
    private final UserDAO udao;
    private final User u;
    public final FormPatientsManagement fp;
    private final Patient p;

    //Contructor de la clase PatientController
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

    //Se encarga de responder a los eventos del click de los botones del FormPatientsManagement
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fp.btnAssociate) {
            fp.lblIndicadorQuery.setText("ASOCIANDO UNA HUELLA.");
            fp.asociate();
            fp.btnNewOff();
        }
        if (e.getSource() == fp.btnSaveP) {
            fp.saveP();
            fp.lblIndicadorQuery.setText("PUEDES BUSCAR, IDENTIFICAR O REGISTRAR UN NUEVO PACIENTE.");
        }
        if (e.getSource() == fp.btnSearchUpdateP) {
            fp.lblIndicadorQuery.setText("PUEDES BUSCAR, IDENTIFICAR O REGISTRAR UN NUEVO PACIENTE.");
            fp.searchUpdate();

        }
        if (e.getSource() == fp.btnIdentify) {
            fp.btnNewOff();
            fp.btnAsociateOff();
            fp.lblIndicadorQuery.setText("IDENTIFICA UN PACIENTE.");
            fp.identify();
        }
        if (e.getSource() == fp.btnNewP) {
            fp.lblIndicadorQuery.setText("PUEDES BUSCAR, IDENTIFICAR O REGISTRAR UN NUEVO PACIENTE.");
            clearFields();
            fp.btnAsociateOn();

        }
    }

    //Limpia todos los campos del formulario y lo reinicia
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
        fp.disableButtons(false, true, true);
    }

    //limpia los campos de la tabla de pacientes
    public void clearTable() {
        int rows = fp.tableP.getRowCount();
        for (int i = 0; i < rows; i++) {
            fp.modt.removeRow(0);
        }
    }

    //Establece la fecha del calendario con la fecha actual
    public void actualDate() {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -120);//15 year before
        Date min = cal.getTime();

        Date max = new Date();//actual date

        Date fecha = new Date();
        fp.dateFNacimiento.setDate(fecha);
        fp.dateFNacimiento.setSelectableDateRange(min, max);
    }

    //Cambia el color de fondo del JDateChooser
    public void setBgcDateChooser() {
        for (Component c : fp.dateFNacimiento.getComponents()) {
            ((JComponent) c).setBackground(new Color(47, 61, 71));
        }
    }

    //Cambia el color de fondo del JComboBox
    public void setBgcComboBox() {
        fp.comboPyDT.setBackground(UIUtils.COLOR_BACKGROUND);
        fp.comboPyDT.setForeground(UIUtils.COLOR_INTERACTIVE);
    }

    //Al dar doble click en un campo de la tabla se carban los datos en el formulario para su actualización
    public void editRowTable(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            //al dar dobleclick en una fila, carga los datos de la tabla en el formulario,
            //en caso de que uno de los datos sea null entonces establece un campo vacío
            //o el index del combobox en 0, según sea el caso
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
            //SOLUCIONAR EL ERROR
            //Date date = new SimpleDateFormat("yyyy/MM/dd").parse((String));
            try {
                fp.dateFNacimiento.setDate((Date)fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 3));
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
                fp.txtEmail.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 14).toString()));
            } catch (Exception e) {
            }
            try {
                fp.dateRegister.setText((fp.tableP.getValueAt(fp.tableP.getSelectedRow(), 3).toString()));
            } catch (Exception e) {
            }

            fp.tipoQuery = false;
            fp.disableButtons(false, true, false);
        }
    }

}
