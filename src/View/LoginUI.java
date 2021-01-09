package View;

/**
 * <span>Descripción:</span>
 * <p>
 * Es la encargada de crear la vista del módulo de inicio sesión
 * .</p>
 *
 * @author Daniel Felipe Lozada Ramirez Email: dflozada2@misena.edu.co
 * @author Edgar Steve Pava Email: Espava60@misena.edu.co
 * @version 1.1.0
 * @since 2020
 */

import Controller.LoginController;
import Model.Conexion;
import Model.UserDAO;
import Model.User;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;

/**
 *
 * @author lenov
 */
public class LoginUI extends JFrame {

    //Variables globales
    Conexion con = new Conexion();
    Connection access;

    /**
     *
     */
    public JButton loginButton;

    /**
     *
     */
    public JButton exitButton;
    UserDAO udao = new UserDAO();
    User u;
    private final Toaster toaster;

    /**
     *
     */
    public String username = "";

    /**
     *
     */
    public String password = "";

    /**
     *
     */
    public TextFieldUsername txtUsernameField;

    /**
     *
     */
    public TextFieldPassword txtPasswordField;

    //Constructor de Login

    /**
     *
     */
    public LoginUI() {

        //Establecemos el icono del proyecto en la barra de tareas y superior del Frame     
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        this.setTitle("RUIPI Inicio de Sesión");

        //Agrega los campos y botones
        JPanel mainJPanel = getMainJPanel();
        addLogo(mainJPanel);
        addSeparator(mainJPanel);
        addUsernameTextField(mainJPanel);
        addPasswordTextField(mainJPanel);
        addLoginButton(mainJPanel);
        addExitButton(mainJPanel);
        addForgotPasswordButton(mainJPanel);

        this.add(mainJPanel);
        this.pack();
        this.setVisible(true);
        this.toFront();

        //Establecemos la ubicación del Panel 
        setLocationRelativeTo(null);
        toaster = new Toaster(mainJPanel);
        LoginController lc = new LoginController(this);
    }

    //Obtiene el texto del campo de Nombre de usuario

    /**
     *
     * @return
     */
    public String getUsernameField() {
        username = txtUsernameField.getText();

        return username;
    }

    //Obtiene el texto del campo de texto de COntraseña

    /**
     *
     * @return
     */
    public String getPasswordField() {
        password = String.valueOf(txtPasswordField.getPassword());

        return password;
    }

    //Obtiene el panel prncipal con su apariencia retonra el panel1
    private JPanel getMainJPanel() {
        this.setUndecorated(false);
        this.setResizable(false);

        Dimension size = new Dimension(800, 400);

        JPanel panel1 = new JPanel();
        panel1.setSize(size);
        panel1.setPreferredSize(size);
        panel1.setBackground(UIUtils.COLOR_BACKGROUND);
        panel1.setLayout(null);

        //Permite que el panel de login se pueda mover con el mouse
        MouseAdapter ma = new MouseAdapter() {
            int lastX, lastY;

            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getXOnScreen();
                lastY = e.getYOnScreen();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(getLocationOnScreen().x + x - lastX, getLocationOnScreen().y + y - lastY);
                lastX = x;
                lastY = y;
            }
        };

        panel1.addMouseListener(ma);
        panel1.addMouseMotionListener(ma);
        //define el comportamiento por defecto del botón de cerrar superior derecho
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                access = (Connection) con.disconnect();
                System.exit(0);
                //close();
            }
        });

        return panel1;
    }

    //Agrega el separadorcentral
    private void addSeparator(JPanel panel1) {
        JSeparator separator1 = new JSeparator();
        separator1.setOrientation(SwingConstants.VERTICAL);
        separator1.setForeground(UIUtils.COLOR_OUTLINE);
        panel1.add(separator1);
        separator1.setBounds(400, 45, 1, 308);
    }

    //Agrega el logo de RUIPI
    private void addLogo(JPanel panel1) {
        JLabel label1 = new JLabel();
        label1.setFocusable(false);
        label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ruipi2.png")));
        panel1.add(label1);
        label1.setBounds(100, 100, 200, 200);
    }

    //Define, agrega y le da la apariencia al campo de texto nombre de usuario
    private void addUsernameTextField(JPanel panel1) {
        txtUsernameField = new TextFieldUsername();
        txtUsernameField.setBounds(475, 66, 250, 44);
        txtUsernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsernameField.getText().equals(UIUtils.PLACEHOLDER_TEXT_USERNAME)) {
                    txtUsernameField.setText("");
                }
                txtUsernameField.setForeground(Color.white);
                txtUsernameField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsernameField.getText().isEmpty()) {
                    txtUsernameField.setText(UIUtils.PLACEHOLDER_TEXT_USERNAME);
                }
                txtUsernameField.setForeground(UIUtils.COLOR_OUTLINE);
                txtUsernameField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        panel1.add(txtUsernameField);
    }

    //Define, agrega y le da la apariencia al campo de texto contraseña
    private void addPasswordTextField(JPanel panel1) {
        txtPasswordField = new TextFieldPassword();
        txtPasswordField.setText(UIUtils.PLACEHOLDER_TEXT_PASSWORD);
        txtPasswordField.setForeground(UIUtils.COLOR_OUTLINE);
        txtPasswordField.setBounds(475, 126, 250, 44);
        txtPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(txtPasswordField.getPassword()).equals(UIUtils.PLACEHOLDER_TEXT_PASSWORD)) {
                    txtPasswordField.setText("");
                }
                txtPasswordField.setForeground(Color.white);
                txtPasswordField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(txtPasswordField.getPassword()).isEmpty()) {
                    txtPasswordField.setText(UIUtils.PLACEHOLDER_TEXT_PASSWORD);
                }
                txtPasswordField.setForeground(UIUtils.COLOR_OUTLINE);
                txtPasswordField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        panel1.add(txtPasswordField);
    }

    //Define, agrega y le da la apariencia al botón de inicio de sesión
    private void addLoginButton(JPanel panel1) {
        final Color[] loginButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

        loginButton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = UIUtils.get2dGraphics(g);
                super.paintComponent(g2);

                Insets insets = getInsets();
                int w = getWidth() - insets.left - insets.right;
                int h = getHeight() - insets.top - insets.bottom;
                g2.setColor(loginButtonColors[0]);
                g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

                FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
                int x2 = (getWidth() - metrics.stringWidth(UIUtils.BUTTON_TEXT_LOGIN)) / 2;
                int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.setFont(UIUtils.FONT_GENERAL_UI);
                g2.setColor(loginButtonColors[1]);
                g2.drawString(UIUtils.BUTTON_TEXT_LOGIN, x2, y2);
            }
        };

        loginButton.addMouseListener(new MouseAdapter() {


            @Override
            public void mouseEntered(MouseEvent e) {
                loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
                loginButtonColors[1] = UIUtils.OFFWHITE;
                loginButton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                loginButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
                loginButtonColors[1] = Color.white;
                loginButton.repaint();
            }

        });

        loginButton.setBackground(UIUtils.COLOR_BACKGROUND);
        loginButton.setBounds(475, 227, 250, 44);
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel1.add(loginButton);
    }

    //Define, agrega y le da la apariencia al botón de inicio de salir
    private void addExitButton(JPanel panel1) {
        final Color[] exitButtonColors = {UIUtils.COLOR_INTERACTIVE2, Color.white};

        exitButton = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = UIUtils.get2dGraphics(g);
                super.paintComponent(g2);

                Insets insets = getInsets();
                int w = getWidth() - insets.left - insets.right;
                int h = getHeight() - insets.top - insets.bottom;
                g2.setColor(exitButtonColors[0]);
                g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

                FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
                int x2 = (getWidth() - metrics.stringWidth(UIUtils.BUTTON_TEXT_EXIT)) / 2;
                int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.setFont(UIUtils.FONT_GENERAL_UI);
                g2.setColor(exitButtonColors[1]);
                g2.drawString(UIUtils.BUTTON_TEXT_EXIT, x2, y2);
            }
        };

        exitButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                exitButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER2;
                exitButtonColors[1] = UIUtils.OFFWHITE;
                exitButton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButtonColors[0] = UIUtils.COLOR_INTERACTIVE2;
                exitButtonColors[1] = Color.white;
                exitButton.repaint();
            }

        });

        exitButton.setBackground(UIUtils.COLOR_BACKGROUND);
        exitButton.setBounds(475, 287, 250, 44);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel1.add(exitButton);
    }

    //Muestra las alertas
    private void addForgotPasswordButton(JPanel panel1) {
        panel1.add(new HyperlinkText(UIUtils.BUTTON_TEXT_FORGOT_PASS, 475, 177, () -> {
            toaster.warn("Reestablecer contraseña");
        }));
    }

    /**
     *
     */
    public void loginErrorEventHandler() {
        toaster.error("¡Hay campos vacíos!");
    }

    /**
     *
     */
    public void dataErrorEventHandler() {
        toaster.error("¡Datos inválidos!");
    }

}
