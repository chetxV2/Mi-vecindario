
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chetx
 */
public class menu_inquilino extends javax.swing.JFrame {

    /**
     * Creates new form menu_inquilino
     */
    public menu_inquilino() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlar_Entradas = new javax.swing.JButton();
        cerrar_sesion = new javax.swing.JButton();
        mostrar_Entradas_Usuarios = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlar_Entradas.setBackground(new java.awt.Color(240, 248, 255));
        controlar_Entradas.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        controlar_Entradas.setText("Controlar Entradas");
        controlar_Entradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        controlar_Entradas.setDefaultCapable(false);
        controlar_Entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlar_EntradasActionPerformed(evt);
            }
        });

        cerrar_sesion.setBackground(new java.awt.Color(240, 248, 255));
        cerrar_sesion.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        cerrar_sesion.setText("Cerrar Sesión");
        cerrar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar_sesionActionPerformed(evt);
            }
        });

        mostrar_Entradas_Usuarios.setBackground(new java.awt.Color(240, 248, 255));
        mostrar_Entradas_Usuarios.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        mostrar_Entradas_Usuarios.setText("Mostrar entradas \nde usuarios");
        mostrar_Entradas_Usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mostrar_Entradas_Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_Entradas_UsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(controlar_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(cerrar_sesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(mostrar_Entradas_Usuarios)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(cerrar_sesion)
                .addGap(166, 166, 166)
                .addComponent(controlar_Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(mostrar_Entradas_Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void controlar_EntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlar_EntradasActionPerformed
        this.setVisible(false);
        new controlar_Acceso().setVisible(true);
    }//GEN-LAST:event_controlar_EntradasActionPerformed

    private void cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrar_sesionActionPerformed
        this.setVisible(false);
        new login().setVisible(true);

    }//GEN-LAST:event_cerrar_sesionActionPerformed

    private void mostrar_Entradas_UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_Entradas_UsuariosActionPerformed
        try{
            String [] opc = {"Inquilinos", "Visitantes"};
            String resp = (String)JOptionPane.showInputDialog(null, "¿De que usuarios quieres mostrar sus entradas?",null, JOptionPane.DEFAULT_OPTION, null, opc, opc[0]);
            if(resp.equals(opc[0])){
                this.setVisible(false);
                new mostrar_Registros_Inquilinos().setVisible(true);
            }else{
                this.setVisible(false);
                new mostrar_Registros_Visitas().setVisible(true);
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_mostrar_Entradas_UsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(menu_inquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_inquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_inquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_inquilino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_inquilino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar_sesion;
    private javax.swing.JButton controlar_Entradas;
    private javax.swing.JButton mostrar_Entradas_Usuarios;
    // End of variables declaration//GEN-END:variables
}
