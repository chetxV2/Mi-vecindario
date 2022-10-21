
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class consultar_Usuarios extends javax.swing.JFrame {

    static Connection cn;
    static Statement s;
    static ResultSet rs;
    static String id, nombre, apellidoP, apellidoM, edad, telefono, genero, ocupNO, vehNo, calle, casaNo;
    /**
     * Creates new form consultar_Usuarios
     */
    public consultar_Usuarios() {
        initComponents();
        Color c = new Color(240, 230, 140);
        this.getContentPane().setBackground(c);
        listar();
    }

    /*public void listar(){
        int count = 0;
        cuentas user = new cuentas();
        String [] titulo = {"Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Telefono", "Genero", "Número de Ocupantes", "Número de Vehiculos", "Calle", "Número de Casa"};
        DefaultTableModel tabla = new DefaultTableModel(null, titulo);
        ArrayList<cuentas> cuenta = new ArrayList<>();
        try{
            cuenta = cuentas.listar();
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT * FROM USUARIOS";
            rs = st.executeQuery(sql);
            /*while(rs.next()){
                for(int j = 0; j<count;j++){
                    for(int i = 0; i<cuenta.size();i++){
                        Object [] row = {cuenta.get(i).getId(),cuenta.get(i).getNombre(),cuenta.get(i).getApellidoP(),cuenta.get(i).getApellidoM(),
                                cuenta.get(i).getEdad(),cuenta.get(i).getTelefono(),cuenta.get(i).getGenero(),cuenta.get(i).getOcupNO(),
                                cuenta.get(i).getVehNo(),cuenta.get(i).getCalle(),cuenta.get(i).getCasaNo()};
                        tabla.addRow(cuentas.listar());
                        
                    }
                }
            tabla.addRow(cuentas.listar());
            }
            
            while(cuentas.listar().size()>count){
                tabla.addRow();
                count+=1;
            }
        }catch(Exception e){
            
        }
        datosUsuarios.setModel(tabla);
    }*/
    
    public void listar() {

       Object [] alNivel2;
       String [] titulo = {"Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Telefono", "Genero", "Número de Ocupantes", "Número de Vehiculos", "Calle", "Número de Casa"};
            DefaultTableModel tabla = new DefaultTableModel(null, titulo);
        try {
            
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT ID, NOMBRE, APELLIDO_P, APELLIDO_M, EDAD,SEXO, TELEFONO, OCUPANTES, VEHICULOS, CALLE, NO_VIVIENDA FROM USUARIOS";
            rs = st.executeQuery(sql); // ejecuta la query
            //Se declaran las variables que tomaran cada uno de los datos que devuelve la tabla
         
            //Se limpia el array list de tipo Nivel2
            
            //Obtiene los datos uno por uno y lo da a la variable correspondiente
            
            while (rs.next()) {
                id = rs.getString("ID");
                nombre = rs.getString("NOMBRE");
                apellidoP = rs.getString("APELLIDO_P");
                apellidoM = rs.getString("APELLIDO_M");
                telefono = rs.getString("TELEFONO");
                edad =rs.getString("EDAD");
                genero = rs.getString("SEXO");
                ocupNO = rs.getString("OCUPANTES");
                vehNo = rs.getString("VEHICULOS");
                calle = rs.getString("CALLE");
                casaNo = rs.getString("NO_VIVIENDA");
                //cuentas c = new cuentas(id,nombre,apellidoP,apellidoM,edad,telefono,genero,ocupNO,vehNo,calle,casaNo);
                //Se crea una nueva instancia y se agrega al array
                //alNivel2 = {id,nombre,apellidoP,apellidoM,edad,telefono,genero,ocupNO,vehNo,calle,casaNo};
                Object [] row ={id,nombre,apellidoP,apellidoM,edad,telefono,genero,ocupNO,vehNo,calle,casaNo};
                tabla.addRow(row);
                
            }
            rs.close();
            
            //Por si hubiera un error con la DB
        } catch (SQLException sqle) {
            System.out.println("Error SQL....." + sqle);
        }
        datosUsuarios.setModel(tabla);
         // se cierra la conexión
         // retorna el array completo
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        regresar.setBackground(new java.awt.Color(240, 248, 255));
        regresar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(207, 167, 16));
        jLabel1.setText("Consultar Usuarios");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 83, 15), 3));

        datosUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Telefono", "Genero", "Número de Ocupantes", "Número de Vehiculos", "Calle", "Número de Casa"
            }
        ));
        jScrollPane1.setViewportView(datosUsuarios);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoPinoSF.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(regresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(98, 98, 98)))
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regresar)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.setVisible(false);
        new menu().setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(consultar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultar_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datosUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
