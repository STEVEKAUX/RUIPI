
package View;

//imports
import Controller.HomeController;
import Model.Conexion;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    // global variables
    Conexion con = new Conexion();
    Connection access;
    UIUtils utils = new UIUtils();

    // Home Constructror
    public Home() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(true);
        setLocationRelativeTo(null);

//        Toolkit loginFrame = Toolkit.getDefaultToolkit();
//        Image ruipiIcon = loginFrame.getImage("resource/icon.png");
//        setIconImage(ruipiIcon);
        this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        this.setTitle("RUIPI Menú Principal");
        //setUOnline();
        HomeController hc= new HomeController(this);

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
        jLabel1 = new javax.swing.JLabel();
        jDesktopPane1 =  new javax.swing.JDesktopPane() { @Override protected void paintComponent(Graphics g) { super.paintComponent(g); g.setColor(UIUtils.COLOR_BACKGROUND); g.fillRect(0, 0, getWidth(), getHeight()); } };
        ;
        btnUsuarios = new javax.swing.JButton();
        btnPacientes = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnConfig = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUserType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(108, 216, 158));
        jPanel1.setForeground(new java.awt.Color(37, 51, 61));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(37, 51, 61));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_20px.png"))); // NOI18N
        jLabel1.setText("Menú Principal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnUsuarios.setBackground(new java.awt.Color(108, 216, 158));
        btnUsuarios.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(37, 51, 61));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user_20px.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setToolTipText("");
        btnUsuarios.setBorder(null);
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPacientes.setBackground(new java.awt.Color(108, 216, 158));
        btnPacientes.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnPacientes.setForeground(new java.awt.Color(37, 51, 61));
        btnPacientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patients_25px.png"))); // NOI18N
        btnPacientes.setText("Pacientes");
        btnPacientes.setBorder(null);
        btnPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPacientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPacientesMouseExited(evt);
            }
        });
        btnPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPacientesActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(252, 87, 118));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(37, 51, 61));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit_20px.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarSesionMouseExited(evt);
            }
        });

        btnConfig.setBackground(new java.awt.Color(108, 216, 158));
        btnConfig.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnConfig.setForeground(new java.awt.Color(37, 51, 61));
        btnConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings_20px.png"))); // NOI18N
        btnConfig.setText("Configuración");
        btnConfig.setBorder(null);
        btnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfigMouseExited(evt);
            }
        });
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(btnUsuarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnPacientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnCerrarSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnConfig, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 360, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(108, 216, 158));
        jPanel2.setForeground(new java.awt.Color(37, 51, 61));

        lblUsername.setBackground(new java.awt.Color(108, 216, 158));
        lblUsername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(37, 51, 61));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel2.setBackground(new java.awt.Color(108, 216, 158));
        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(37, 51, 61));
        jLabel2.setText(":");

        lblUserType.setBackground(new java.awt.Color(108, 216, 158));
        lblUserType.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblUserType.setForeground(new java.awt.Color(37, 51, 61));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(lblUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane1)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void windowCentered(JInternalFrame frame) {
        jDesktopPane1.add(frame);

        Dimension screenSize = jDesktopPane1.getSize();
        Dimension formP = frame.getSize();
        frame.setLocation((screenSize.width - formP.width) / 2, ((screenSize.height) - formP.height) / 2);
        frame.show();
    }

    public void close() {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "¿Realmente desea salir de la aplicación?", "Saliendo de RUIPI",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            access = (Connection) con.disconnect();
            this.dispose();
            LoginUI lg = new LoginUI();
        } else {
        }
    }

    //Establece el nombre de usuario y el tipo de usuario que inició sesiónn en la parte baja del frame
//    public void setUOnline() {
//
//        Conexion cn = new Conexion();
//        Connection cnn = cn.getConnection();
//        PreparedStatement ps;
//        ResultSet rs;
//        Home h = null;
//        String query = "SELECT u.username, u.idtipo_usuario, t.nombre_tipo_usuario FROM usuario AS u "
//                + "INNER JOIN tipo_usuario AS t ON u.idtipo_usuario=t.id_tipo_usuario";
//        try {
//
//            ps = cnn.prepareStatement(query);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                lblUsername.setText(rs.getString("username"));
//                lblUserType.setText(rs.getString("nombre_tipo_usuario"));
//                
//                
//            }
//            //REVISAR CASOS PARA TIPOS DE USUARIO
////            switch(rs.getInt("idtipo_usuario")){
////                case 1: System.out.println(rs.getInt("idtipo_usuario"));;
////                break;
////                case 2: h.btnConfig.setEnabled(false);
////                break;
////                case 3: h.btnConfig.setEnabled(false);
////                break;
////            }
//
//        } catch (Exception e) {
//
//       }
//
//    }
//    public void privileges(){
//        Conexion cn = new Conexion();
//        Connection cnn = cn.getConnection();
//        PreparedStatement ps;
//        ResultSet rs;
//        String query="SELECT u.idtipo_usuario, t.nombre_tipo_usuario FROM usuario AS u" 
//                +"INNER JOIN tipo_usuario AS t ON u.idtipo_usuario=t.id_tipo_usuario";
//        
//        
//    }

    private void btnPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPacientesActionPerformed
        FormPatientsManagement fp = new FormPatientsManagement();
        windowCentered(fp);
        fp.txtNombrePaciente.requestFocus();
    }//GEN-LAST:event_btnPacientesActionPerformed



    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
        FormSettingsManagement fs = new FormSettingsManagement();
        windowCentered(fs);
    }//GEN-LAST:event_btnConfigActionPerformed


    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        FormUsersManagement fu = new FormUsersManagement();
        windowCentered(fu);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        access = (Connection) con.disconnect();
        //close();

    }//GEN-LAST:event_formWindowClosing

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        btnUsuarios.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnPacientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPacientesMouseEntered
        btnPacientes.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
    }//GEN-LAST:event_btnPacientesMouseEntered

    private void btnConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseEntered
        btnConfig.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
    }//GEN-LAST:event_btnConfigMouseEntered

    private void btnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseEntered
        btnCerrarSesion.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER2);
    }//GEN-LAST:event_btnCerrarSesionMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        btnUsuarios.setBackground(UIUtils.COLOR_INTERACTIVE);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnPacientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPacientesMouseExited
        btnPacientes.setBackground(UIUtils.COLOR_INTERACTIVE);
    }//GEN-LAST:event_btnPacientesMouseExited

    private void btnConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfigMouseExited
        btnConfig.setBackground(UIUtils.COLOR_INTERACTIVE);
    }//GEN-LAST:event_btnConfigMouseExited

    private void btnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSesionMouseExited
        btnCerrarSesion.setBackground(UIUtils.COLOR_INTERACTIVE2);
    }//GEN-LAST:event_btnCerrarSesionMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCerrarSesion;
    public javax.swing.JButton btnConfig;
    public javax.swing.JButton btnPacientes;
    public javax.swing.JButton btnUsuarios;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lblUserType;
    public javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
