package Controller;

import Model.Conexion;
import View.FormClinicalHistoryManagement;
import View.FormPatientsManagement;
import View.FormSettingsManagement;
import View.FormUsersManagement;
import View.Home;
import View.LoginUI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class HomeController implements ActionListener {

    //Declaración de variables
    private final Home h;
    private FormPatientsManagement fp;
    Conexion con = new Conexion();
    Connection access;

    //Constructor de HomeController
    public HomeController(Home h) {
        this.h = h;

        this.h.btnCerrarSesion.addActionListener(this);
        this.h.btnConfig.addActionListener(this);
        this.h.btnPacientes.addActionListener(this);
        this.h.btnHistoriaC.addActionListener(this);
        this.h.btnUsuarios.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == h.btnUsuarios) {
            FormUsersManagement fu = new FormUsersManagement();
            windowCentered(fu);
            try {
                fu.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == h.btnPacientes) {
            fp = new FormPatientsManagement();
            windowCentered(fp);
            try {
                fp.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fp.txtNombrePaciente.requestFocus();
        }
        if (e.getSource() == h.btnHistoriaC) {
            FormClinicalHistoryManagement hc = new FormClinicalHistoryManagement();
            windowCentered(hc);
            try {
                hc.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == h.btnConfig) {
            FormSettingsManagement fs = new FormSettingsManagement();
            windowCentered(fs);
            try {
                fs.setMaximum(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == h.btnCerrarSesion) {
            close();
        }

    }

    public void windowCentered(JInternalFrame frame) {
        h.jDesktopPane1.add(frame);

        Dimension screenSize = h.jDesktopPane1.getSize();
        Dimension formP = frame.getSize();
        frame.setLocation((screenSize.width - formP.width) / 2, ((screenSize.height) - formP.height) / 2);
        frame.show();
    }

    public void close() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(null, "¿Realmente desea salir de la aplicación?", "Saliendo de RUIPI",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            access = (Connection) con.disconnect();
            h.dispose();
            LoginUI lg = new LoginUI();
        } else {
        }
    }
}
