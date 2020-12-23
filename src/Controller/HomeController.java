package Controller;

import Model.Conexion;
import View.FormClinicalHistoryManagement;
import View.FormPatientsManagement;
import static View.FormPatientsManagement.pc;
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

/**
 **<h2>Clase HomeController</h2>
 * <br>
 * <p>
 * Se encarga de ejecutar la lógica de los eventos del click desencadenados por
 * el usuario en la vista {@link Home}.</p>
 * <br>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 * @see ActionListener
 * @see Home
 */
public class HomeController implements ActionListener {

    /**
     * Variables y constantes de la clase {@link  HomeController}.
     *
     */
    private final Home h;
    private FormPatientsManagement fp;
    Conexion con = new Conexion();
    Connection access;

    /**
     * <h2>Método Constructor de HomeController</h2>
     * <br>
     *
     * @param h
     */
    public HomeController(Home h) {
        this.h = h;

        this.h.btnCerrarSesion.addActionListener(this);
        this.h.btnConfig.addActionListener(this);
        this.h.btnPacientes.addActionListener(this);
        this.h.btnHistoriaC.addActionListener(this);
        this.h.btnUsuarios.addActionListener(this);
    }

    /**
     * <h2>Método actionPerformed(ActionEvent e)</h2>
     * <br>
     * <p>
     * Sobreescribe el método {@code actionPerformed(ActionEvent e)} para
     * dotarlo del comportamiento necesario para desencadenar los eventos del
     * click del botón en la vista {@link Home}.</p>
     * @see Home
     * @see ActionEvent
     * @param e
     */
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
            pc.disableButtons(false, true, true);
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

    /**
     * <h2>Método {@code windowCentered(JInternalFrame frame)}</h2>
     * <br>
     * <p>
     * Se encarga de centrar los frames de la aplicación RUIPI respecto altamaño
     * de la ventana del equipo del usuario.</p>
     * <br>
     *
     * @param frame
     */
    public void windowCentered(JInternalFrame frame) {
        h.jDesktopPane1.add(frame);

        Dimension screenSize = h.jDesktopPane1.getSize();
        Dimension formP = frame.getSize();
        frame.setLocation((screenSize.width - formP.width) / 2, ((screenSize.height) - formP.height) / 2);
        frame.show();
    }

    /**
     * <h2>Método {@code close()}</h2>
     * <br>
     * <p>
     * Se encarga de validar el cierre de sesión del usuario actualmente
     * logueado, en caso de que el usuario oprima "Aceptar" cerrará la conexión
     * a la base de datos de la aplicación RUIPI y redirigirá al frame {@link LoginUI}</p>
     * <br>
     */
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
