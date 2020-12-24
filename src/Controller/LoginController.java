package Controller;

import Model.Conexion;
import Model.User;
import Model.UserDAO;
import View.Home;
import View.LoginUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * <span>Descripción:</span>
 * <p>
 * Implementa {@link ActionListener}. Se encarga de ejecutar la lógica de los eventos del click desencadenados por
 * el usuario en la vista {@link LoginUI}.</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 * @see ActionListener
 * @see LoginUI
 */
public class LoginController implements ActionListener {

    /**
     * Variables y constantes de la clase {@link  LoginController}.
     *
     */
    private final LoginUI log;
    UserDAO udao = new UserDAO();
    User u;

    /**
     * <p>Método Constructor de LoginController</p>
     *
     * @param log Recibe un objeto de la clase {@link LoginUI}
     */
    public LoginController(LoginUI log) {
        this.log = log;

        this.log.loginButton.addActionListener(this);
        this.log.exitButton.addActionListener(this);
        this.log.txtPasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    validateLogin();
                }
            }
        });
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Sobreescribe el método {@code actionPerformed(ActionEvent e)} para
     * dotarlo del comportamiento necesario para desencadenar los eventos del
     * click del botón en la vista {@link LoginUI}.</p>
     *
     * @see LoginUI
     * @see ActionEvent
     * @param e Recibe un objeto de tipo ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log.loginButton) {
            validateLogin();
        }
        if (e.getSource() == log.exitButton) {
            System.out.println("Click en Exit");
            turnOffDB();
            closeApp();
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de cerrar la ejecución de la aplicación y terminar la conexión
     * con la base de datos en caso de que el usuario oprima "Aceptar".</p>
     */
    public void closeApp() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(null, "¿Realmente desea salir de la aplicación?", "Saliendo de STOCKMS",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de desconectar la bse de datos.</p>
     */
    public void turnOffDB() {
        Conexion con = new Conexion();
        Connection access;
        access = (Connection) con.disconnect();
    }

    /**
     * <span>Descripción:</span>
     * <p>
     * Se encarga de validar el nombre de usuario y contraseña ingresados en los
     * campos de texto correspondientes con la base de datos, en caso de
     * coinsidir estos con los datos almacenados en la base de datos permitirá
     * al usuario acceder al menú principal de la aplicación.</p>
     */
    public void validateLogin() {
        String uf = log.getUsernameField();
        String pf = log.getPasswordField();

        if (uf.equals("") || pf.equals("") || uf.equals("Nombre de Usuario") || pf.equals("contraseña")) {
            log.loginErrorEventHandler();
            log.txtUsernameField.requestFocus();

        } else {
            try {
                u = udao.userValidator(uf, pf);
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (u.getUsername() != null && u.getPassword() != null) {
                System.out.println("Validado");
                Home home = new Home();

                home.setVisible(true);
                home.lblUsername.setText(uf);
                switch (u.getId_tipo_usuario()) {
                    case 1:
                        home.lblUserType.setText("Administrador");
                        break;
                    case 2:
                        home.lblUserType.setText("Médico");
                        break;
                    case 3:
                        home.lblUserType.setText("Recepción");
                        break;
                    default: {
                    }
                }

                log.dispose();

            } else {
                log.dataErrorEventHandler();
                log.txtPasswordField.requestFocus();
            }

        }
    }
}
