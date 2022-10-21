
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Chetx
 */
public class login extends javax.swing.JFrame {
    
    static Connection cn;
    static Statement s;
    static ResultSet rs, rsv;
    static int usuario, tipo;
    static String contraseña;

    public login() {
        initComponents();
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        
        Color c = new Color(240, 230, 140);
        this.getContentPane().setBackground(c);
      

    }

    public int getTipo(){
        return tipo;
    }
    
    public int conexion() {
        /*try {

            usuario = Integer.parseInt(id_usuario.getText());
            contraseña = pass.getText();
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            s = cn.createStatement();
            rs = s.executeQuery("SELECT ID, CONTRASENA FROM USUARIOS WHERE ID=" + usuario + " AND CONTRASENA='" + contraseña + "'");
            rs.next();
            if(rs.getBoolean())
            ResultSetMetaData rsd = rs.getMetaData();
            
            this.setVisible(false);
            new menu().setVisible(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error usuario y/o contraseña incorrectos ");
        }*/
        

    int resultado=0;
    usuario = Integer.parseInt(id_usuario.getText());
    contraseña = pass.getText();
    String sql="SELECT ID, CONTRASENA FROM USUARIOS WHERE ID=" + usuario + " AND CONTRASENA='" + contraseña + "'";
    String slqV="SELECT TIPO FROM USUARIOS WHERE ID="+usuario;
    Connection conect = null;
    try {
        conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
        Statement st = conect.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            resultado=1;
            ResultSet rsv = st.executeQuery(slqV);
            if(rsv.next()){
                tipo = rsv.getInt("TIPO");
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);
    }finally{
        try {
            conect.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    return resultado;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iniciar_sesion = new javax.swing.JButton();
        id_usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        mostrar_ocultar_pass = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("Login"); // NOI18N
        setUndecorated(true);

        iniciar_sesion.setBackground(new java.awt.Color(240, 248, 255));
        iniciar_sesion.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        iniciar_sesion.setText("Iniciar Sesión");
        iniciar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciar_sesionActionPerformed(evt);
            }
        });

        id_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_usuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_usuarioKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("ID de Usuario:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoCMIVec.png"))); // NOI18N
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(200, 300));

        pass.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        pass.setToolTipText("");
        pass.setMinimumSize(new java.awt.Dimension(6, 30));
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passKeyTyped(evt);
            }
        });

        mostrar_ocultar_pass.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        mostrar_ocultar_pass.setText("Ver");
        mostrar_ocultar_pass.setToolTipText("Revela u oculta la contraseña");
        mostrar_ocultar_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mostrar_ocultar_passMouseClicked(evt);
            }
        });

        label1.setForeground(new java.awt.Color(255, 0, 0));
        label1.setText("*Campo obligatorio");
        label1.setVisible(false);

        label2.setForeground(new java.awt.Color(255, 0, 0));
        label2.setText("*Campo obligatorio");
        label2.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("*Campo obligatorio");

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("*Campo obligatorio");

        salir.setBackground(new java.awt.Color(240, 248, 255));
        salir.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(iniciar_sesion)
                        .addGap(18, 18, 18)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(130, 130, 130))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(40, 40, 40)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(mostrar_ocultar_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mostrar_ocultar_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iniciar_sesion, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void iniciar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciar_sesionActionPerformed
        try{
            if(!id_usuario.getText().isEmpty() && !pass.getText().isEmpty()){
                jLabel4.setVisible(false);
                jLabel5.setVisible(false);
                if(conexion()==1){
                    this.dispose();
                    this.setVisible(false);
                    if(getTipo()==1){
                        new menu().setVisible(true);
                    }else{
                        new menu_inquilino().setVisible(true);
                    }
                }else {
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                    + "Ingresar usuario y/o contraseña correctos", null,
                    JOptionPane.ERROR_MESSAGE);
                    id_usuario.setText("");
                    pass.setText("");
                    id_usuario.requestFocus();
                }
            }else if(id_usuario.getText().isEmpty() && !pass.getText().isEmpty()){
                jLabel4.setVisible(true);
                id_usuario.requestFocus();
                //jLabel5.setVisible(true);
                //JOptionPane.showMessageDialog(null, "Favor de llenar todos los recuadros");
            }else if(!id_usuario.getText().isEmpty() && pass.getText().isEmpty()){
                jLabel5.setVisible(true);
                pass.requestFocus();
            }else{
                jLabel4.setVisible(true);
                jLabel5.setVisible(true);
                id_usuario.requestFocus();
                
            }
        }catch(Exception e){
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            JOptionPane.showMessageDialog(null, "Caracteres Invalidos", null, JOptionPane.ERROR_MESSAGE);
            id_usuario.setText("");
            pass.setText("");
            id_usuario.requestFocus();
        }
         
        
    }//GEN-LAST:event_iniciar_sesionActionPerformed

    private void mostrar_ocultar_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mostrar_ocultar_passMouseClicked
        if (mostrar_ocultar_pass.getText().equals("Ver")) {
            mostrar_ocultar_pass.setText("Cubrir");
            pass.setEchoChar((char) 0);
        } else {
            mostrar_ocultar_pass.setText("Ver");
            pass.setEchoChar('*');

        }


    }//GEN-LAST:event_mostrar_ocultar_passMouseClicked

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(resp == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void id_usuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_usuarioKeyTyped
        if(id_usuario.getText().length()>5){
            evt.consume();
        }
    }//GEN-LAST:event_id_usuarioKeyTyped

    private void passKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyTyped
        if(pass.getText().length()>7){
            evt.consume();
        }
    }//GEN-LAST:event_passKeyTyped

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            iniciar_sesion.doClick();
        }
    }//GEN-LAST:event_passKeyPressed

    private void id_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_usuarioKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            pass.requestFocus();
        }
    }//GEN-LAST:event_id_usuarioKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id_usuario;
    private javax.swing.JButton iniciar_sesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel mostrar_ocultar_pass;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
