package View;


import Toaster.Toaster;
import Utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class LoginUI extends JFrame {
    
    //Variables globales
    private final Toaster toaster;
    
    public String username="";
    public String password="";
    
    TextFieldUsername usernameField;
    TextFieldPassword passwordField;
    
    //Constructor de Login
    public LoginUI() {
        
        
  //Establecemos el icono del proyecto en la barra de tareas y superior del Frame     
  Toolkit loginFrame = Toolkit.getDefaultToolkit();
  Image ruipiIcon = loginFrame.getImage("resource/icon.png");
  setIconImage(ruipiIcon);
  this.setTitle("RUIPI Inicio de Sesión");
    	
        
    	JPanel mainJPanel = getMainJPanel();
        
        //addMinButton(mainJPanel);
        
        addLogo(mainJPanel);

        addSeparator(mainJPanel);

        addUsernameTextField(mainJPanel);

        addPasswordTextField(mainJPanel);

        addLoginButton(mainJPanel);
        
        addExitButton(mainJPanel);

        addForgotPasswordButton(mainJPanel);

        //addRegisterButton(mainJPanel);

        this.add(mainJPanel);
        this.pack();
        this.setVisible(true);
        this.toFront();
        
        //Establecemos la ubicación del Panel 
       setLocationRelativeTo(null);
        toaster = new Toaster(mainJPanel);
    }
    
    //Obtiene el texto del campo de Nombre de usuario
    public void getUsername(){
         username=usernameField.getText().toString();
                System.out.println(username);
    }
    
    //Obtiene el texto del campo de texto de COntraseña
    public void getPassword(){
        password=passwordField.getText().toString();
                System.out.println(password);
    }

    //OBTIENE EL PANE PRINCIPAL
    private JPanel getMainJPanel() {
        this.setUndecorated(false);
        this.setResizable(false);

        Dimension size = new Dimension(800, 400);

        JPanel panel1 = new JPanel();
        panel1.setSize(size);
        panel1.setPreferredSize(size);
        panel1.setBackground(UIUtils.COLOR_BACKGROUND);
        panel1.setLayout(null);

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

       addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
              System.exit(0);
          }
        });

        return panel1;
    }
   

    //AGREGA EL SEPARADOR CENTRAL
    private void addSeparator(JPanel panel1) {
        JSeparator separator1 = new JSeparator();
        separator1.setOrientation(SwingConstants.VERTICAL);
        separator1.setForeground(UIUtils.COLOR_OUTLINE);
        panel1.add(separator1);
        separator1.setBounds(400, 45, 1, 308);
    }
    
     /**
      //MINIMIZAR
    public void minimize() {                                             
             
    this.setExtendedState(ICONIFIED);{ 
    }}**/
    
    //CONFIRMAR ACCIÓN DE SALIR
    public void close(){
        Object [] opciones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Realmente desea salir de la aplicación?","Saliendo de RUIPI",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if (eleccion == JOptionPane.YES_OPTION)
        {
        System.exit(0);
        }else{
        }
           }

    //AGREGA EL LOGO DE RUIPI
   private void addLogo(JPanel panel1) {
        JLabel label1 = new JLabel();
        label1.setFocusable(false);
        label1.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource
        ("ruipi2.png")).getFile()));
        panel1.add(label1);
        label1.setBounds(100, 100, 200, 200);
    }
   
   //CAMPO DE TEXTO DE NOMBRE DE USUARIO
    private void addUsernameTextField(JPanel panel1) {
        usernameField=new TextFieldUsername();

        usernameField.setBounds(475, 66, 250, 44);
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals(UIUtils.PLACEHOLDER_TEXT_USERNAME)) {
                    usernameField.setText("");
                }
                usernameField.setForeground(Color.white);
                usernameField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText(UIUtils.PLACEHOLDER_TEXT_USERNAME);
                }
                usernameField.setForeground(UIUtils.COLOR_OUTLINE);
                usernameField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        panel1.add(usernameField);
    }
    
    //CAMPO DE TEXTO DE CONTRASEÑA
    private void addPasswordTextField(JPanel panel1) {
         passwordField = new TextFieldPassword();
         passwordField.setText(UIUtils.PLACEHOLDER_TEXT_PASSWORD);
         passwordField.setForeground(UIUtils.COLOR_OUTLINE);

        passwordField.setBounds(475, 126, 250, 44);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals(UIUtils.PLACEHOLDER_TEXT_PASSWORD)) {
                    passwordField.setText("");
                }
                passwordField.setForeground(Color.white);
                passwordField.setBorderColor(UIUtils.COLOR_INTERACTIVE);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText(UIUtils.PLACEHOLDER_TEXT_PASSWORD);
                }
                passwordField.setForeground(UIUtils.COLOR_OUTLINE);
                passwordField.setBorderColor(UIUtils.COLOR_OUTLINE);
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER){
                    loginEventHandler();
                    getUsername();
                    getPassword();}
            }
        });

        panel1.add(passwordField);
    }
    
    //BOTÓN DE INICIO DE SESIÓN 
    private void addLoginButton(JPanel panel1) {
        final Color[] loginButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

        JLabel loginButton = new JLabel() {
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
            public void mousePressed(MouseEvent e) {
                loginEventHandler();
                
                //Obtener el texto del campo de texto de nombre de usuario
                getUsername();
                
                //Obtener el texto del campo de texto de contraseña
                getPassword();
            }

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
    
    // BOTON DE SALIR
    private void addExitButton(JPanel panel1) {
        final Color[] exitButtonColors = {UIUtils.COLOR_INTERACTIVE2, Color.white};

        JLabel exitButton = new JLabel() {
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

            /**@Override
            public void mousePressed(MouseEvent e) {
                exitEventHandler();
            }**/

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
            
            @Override
            public void mouseClicked(MouseEvent e) {
                close();
            }
        });

        exitButton.setBackground(UIUtils. COLOR_BACKGROUND);
        exitButton.setBounds(475, 287, 250, 44);
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel1.add(exitButton);
    }
    
    //BOTÓN DE MINIMIZAR
    /**private void addMinButton(JPanel panel1) {
        final Color[] minButtonColors = {UIUtils.COLOR_INTERACTIVE, Color.white};

        JLabel minButton = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = UIUtils.get2dGraphics(g);
                super.paintComponent(g2);

                Insets insets = getInsets();
                int w = getWidth() - insets.left - insets.right;
                int h = getHeight() - insets.top - insets.bottom;
                g2.setColor(minButtonColors[0]);
                g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

            }
        };

        minButton.addMouseListener(new MouseAdapter() {

            /**@Override
            public void mousePressed(MouseEvent e) {
                minEventHandler();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                minButtonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
                minButtonColors[1] = UIUtils.OFFWHITE;
                minButton.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                minButtonColors[0] = UIUtils.COLOR_INTERACTIVE;
                minButtonColors[1] = Color.white;
                minButton.repaint();
            }
           
            @Override
            public void mouseClicked(MouseEvent e) {
               minimize();
            }
            
        });

        minButton.setBackground(UIUtils. COLOR_BACKGROUND);
        minButton.setBounds(745, 20, 35, 8);
        minButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel1.add(minButton);
    }**/ 

    /**método retirado porque solo el Administrador puede registrar nuevos usuarios
     * private void addRegisterButton(JPanel panel1) {
        panel1.add(new HyperlinkText(UIUtils.BUTTON_TEXT_REGISTER, 613, 150, () -> {
            toaster.success("Regristrarme en RUIPI");
        }));
    }**/

    //ALERTAS
    private void addForgotPasswordButton(JPanel panel1) {
        panel1.add(new HyperlinkText(UIUtils.BUTTON_TEXT_FORGOT_PASS, 475, 177, () -> {
            toaster.warn("Reestablecer contraseña");
        }));
    }
    private void loginEventHandler() {
        toaster.success("Iniciando sesión");
    }
    /**private void exitEventHandler() {
        toaster.error("Saliendo");
    }**/
    
    /**private void loginErrorEventHandler() {
        toaster.error("¡Nombre de usuario o contraseña inválidos!");
        }**/
}
