
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

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
    static ResultSet rs, rsv;
    static String id, nombre, apellidoP, apellidoM, edad, telefono, genero, ocupNO, vehNo, calle, casaNo, nombreCel, apellidoCel, apellidoMCel;
    static int fila;
    static TableRowSorter filtro;
    /**
     * Creates new form consultar_Usuarios
     */
    public consultar_Usuarios() {
        initComponents();
        Color c = new Color(240, 230, 140);
        this.getContentPane().setBackground(c);
        //datosUsuarios.setVisible(false);
        //listar();
        
    }

    public int buscar_user(){
        datosUsuarios.setVisible(false);
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT ID, NOMBRE, APELLIDO_P, APELLIDO_M, EDAD,SEXO, TELEFONO, OCUPANTES, VEHICULOS, CALLE, NO_VIVIENDA FROM USUARIOS WHERE ID ="+id_buscar.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                r = 1;
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
                /*JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Nombre: "+nombre+"\n"+"Apellido Paterno: "+apellidoP+"\n"+"Apellido Materno: "+apellidoM+
                                            "\nTelefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+ "\nVehiculos: "+vehNo+
                                            "\nCalle: "+calle+"\nCasa: "+casaNo, "Información de Usuario", JOptionPane.INFORMATION_MESSAGE);*/
                texto.setText("ID: "+id+"\n"+"Nombre: "+nombre+"\n"+"Apellido Paterno: "+apellidoP+"\n"+"Apellido Materno: "+apellidoM+
                                            "\nTelefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+ "\nVehiculos: "+vehNo+
                                            "\nCalle: "+calle+"\nCasa: "+casaNo);
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int buscar_nombre(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT ID, NOMBRE, APELLIDO_P, APELLIDO_M, EDAD,SEXO, TELEFONO, OCUPANTES, VEHICULOS, CALLE, NO_VIVIENDA FROM USUARIOS WHERE NOMBRE ='"+id_buscar.getText()+"'";
            rs = st.executeQuery(sql);
            if(rs.next()){
                    /*String sqlV="SELECT ID, NOMBRE, APELLIDO_P, APELLIDO_M, EDAD,SEXO, TELEFONO, OCUPANTES, VEHICULOS, CALLE, NO_VIVIENDA FROM USUARIOS WHERE NOMBRE ='"+id_buscar.getText()+"'";
                    rsv = st.executeQuery(sqlV);
                    if(rsv.next()){
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
                        JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Nombre: "+nombre+"\n"+"Apellido Paterno: "+apellidoP+"\n"+"Apellido Materno: "+apellidoM+
                                            "\nTelefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+ "\nVehiculos: "+vehNo+
                                            "\nCalle: "+calle+"\nCasa: "+casaNo, "Información de Usuario", JOptionPane.INFORMATION_MESSAGE);
                    }
                    rsv.close();*/
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
                /*JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Nombre: "+nombre+"\n"+"Apellido Paterno: "+apellidoP+"\n"+"Apellido Materno: "+apellidoM+
                                        "\nTelefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+ "\nVehiculos: "+vehNo+
                                            "\nCalle: "+calle+"\nCasa: "+casaNo, "Información de Usuario", JOptionPane.INFORMATION_MESSAGE);*/
                texto.setText("ID: "+id+"\nNombre: "+nombre+"\nApellido Paterno: "+apellidoP+"\nApellido Materno: "+apellidoM+"\nTelefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+"\nVehiculos: "+vehNo+"\nCalle: "+calle+"\nCasa: "+casaNo);
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int contar(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT COUNT(*) FROM USUARIOS WHERE NOMBRE ='"+id_buscar.getText()+"'";
            rs = st.executeQuery(sql);
            if(rs.next()){
                int count = rs.getInt("COUNT(*)");
                if(count == 1){
                    r = 1;
                }else if(count==0){
                    r = 0;
                }else{
                    r = 2;
                }
            }
        }catch(Exception e){
            
        }
        return r;
    }
    
    public void listar() {
       datosUsuarios.setVisible(true);
       Object [] alNivel2;
       String [] titulo = {"Nombre", "Apellido Paterno", "Apellido Materno"};
            DefaultTableModel tabla = new DefaultTableModel(null, titulo);
        try {
            
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT ID, NOMBRE, APELLIDO_P, APELLIDO_M, EDAD,SEXO, TELEFONO, OCUPANTES, VEHICULOS, CALLE, NO_VIVIENDA FROM USUARIOS WHERE NOMBRE = '"+id_buscar.getText()+"'";
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
                Object [] row ={nombre,apellidoP,apellidoM};
                tabla.addRow(row);
                /*JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Nombre: "+nombre+"\n"+"Apellido Paterno: "+apellidoP+"\n"+"Apellido Materno: "+apellidoM+
                                            "Telefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+ "\nVehiculos: "+vehNo+
                                            "\nCalle: "+calle+"\nCasa: "+casaNo);*/
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
    
    public void listarN(){
        //Object [] alNivel2;
       //String [] titulo = {"Id", "Nombre", "Apellido Paterno", "Apellido Materno", "Edad", "Telefono", "Genero", "Número de Ocupantes", "Número de Vehiculos", "Calle", "Número de Casa"};
        //    DefaultTableModel tabla = new DefaultTableModel(null, titulo);
        try {
            
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT ID, NOMBRE, APELLIDO_P, APELLIDO_M, EDAD,SEXO, TELEFONO, OCUPANTES, VEHICULOS, CALLE, NO_VIVIENDA FROM USUARIOS WHERE NOMBRE = '"+nombreCel+"' AND APELLIDO_P = '"+apellidoCel+"' AND APELLIDO_M = '"+apellidoMCel+"'";
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
                /*Object [] row ={id,nombre,apellidoP,apellidoM,edad,telefono,genero,ocupNO,vehNo,calle,casaNo};
                tabla.addRow(row);*/
                /*JOptionPane.showMessageDialog(null, "ID: "+id+"\n"+"Nombre: "+nombre+"\n"+"Apellido Paterno: "+apellidoP+"\n"+"Apellido Materno: "+apellidoM+
                                            "Telefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+ "\nVehiculos: "+vehNo+
                                            "\nCalle: "+calle+"\nCasa: "+casaNo);*/
                texto.setText("ID: "+id+"\nNombre: "+nombre+"\nApellido Paterno: "+apellidoP+"\nApellido Materno: "+apellidoM+"\nTelefono: "+telefono+"\nEdad: "+edad+"\nGenero: "+genero+ "\nOcupantes: "+ocupNO+"\nVehiculos: "+vehNo+"\nCalle: "+calle+"\nCasa: "+casaNo);
            }
            rs.close();
            
            //Por si hubiera un error con la DB
        } catch (SQLException sqle) {
            System.out.println("Error SQL....." + sqle);
        }
        //datosUsuarios.setModel(tabla);
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
        id_buscar = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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

            },
            new String [] {
                "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        datosUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        datosUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datosUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(datosUsuarios);
        if (datosUsuarios.getColumnModel().getColumnCount() > 0) {
            datosUsuarios.getColumnModel().getColumn(0).setResizable(false);
            datosUsuarios.getColumnModel().getColumn(0).setPreferredWidth(150);
            datosUsuarios.getColumnModel().getColumn(1).setResizable(false);
            datosUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
            datosUsuarios.getColumnModel().getColumn(2).setResizable(false);
            datosUsuarios.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logitoV3.png"))); // NOI18N

        id_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_buscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_buscarKeyTyped(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(240, 248, 255));
        buscar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setText("ID de Usuario/Nombre:");

        limpiar.setBackground(new java.awt.Color(240, 248, 255));
        limpiar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        limpiar.setText("Limpiar");
        limpiar.setToolTipText("Restablece la tabla");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane2.setViewportView(texto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(id_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(limpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(regresar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addGap(140, 140, 140)))
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
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
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscar)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.setVisible(false);
        new menu().setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        //listar();
        try{
            if(id_buscar.getText().matches("^[0-9]*$")){
                if(id_buscar.getText().equals("")){
                    /*filtro = new TableRowSorter(datosUsuarios.getModel());
                    datosUsuarios.setRowSorter(filtro);
                    filtro.setRowFilter(RowFilter.regexFilter(id_buscar.getText(), 0));*/
                    datosUsuarios.setVisible(false);
                }
                else if(buscar_user() == 1){
                    /*filtro = new TableRowSorter(datosUsuarios.getModel());
                    datosUsuarios.setRowSorter(filtro);
                    filtro.setRowFilter(RowFilter.regexFilter(id_buscar.getText(), 0));*/
                    datosUsuarios.setVisible(false);
                    id_buscar.setText("");
                    id_buscar.requestFocus();
                    
                }else{
                    JOptionPane.showMessageDialog(null, "No existe el usuario", null, JOptionPane.ERROR_MESSAGE);
                    id_buscar.setText("");
                }
            }else if(id_buscar.getText().matches("^[a-zA-Z]*$")){
                if(id_buscar.getText().equals("")){
                    /*filtro = new TableRowSorter(datosUsuarios.getModel());
                    datosUsuarios.setRowSorter(filtro);
                    filtro.setRowFilter(RowFilter.regexFilter(id_buscar.getText(), 0));*/
                    datosUsuarios.setVisible(false);
                }
                else if(contar() == 1){
                    /*filtro = new TableRowSorter(datosUsuarios.getModel());
                    datosUsuarios.setRowSorter(filtro);
                    filtro.setRowFilter(RowFilter.regexFilter(id_buscar.getText(), 1));*/
                    datosUsuarios.setVisible(false);
                    buscar_nombre();
                    id_buscar.setText("");
                    id_buscar.requestFocus();
                }else if(contar() == 2){
                    texto.setText("");
                    listar();
                    id_buscar.setText("");
                    id_buscar.requestFocus();
                    /*if(n)){
                        JOptionPane.showMessageDialog(null, "h");
                        fila = datosUsuarios.getSelectedRow();
                        nombreCel = datosUsuarios.getValueAt(fila, 0).toString();
                        apellidoCel = datosUsuarios.getValueAt(fila, 1).toString();
                        apellidoMCel = datosUsuarios.getValueAt(fila, 2).toString();
                        listarN();
                    }*/
                }else{
                    JOptionPane.showMessageDialog(null, "No existe el usuario o esta mal escrito", null, JOptionPane.ERROR_MESSAGE);
                    id_buscar.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Solo se aceptan números o letras", null, JOptionPane.WARNING_MESSAGE);
                id_buscar.setText("");
            }
        }catch (Exception e){
            
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void id_buscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_buscarKeyTyped
        if(id_buscar.getText().length()>19){
            evt.consume();
        }
    }//GEN-LAST:event_id_buscarKeyTyped

    private void id_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_buscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscar.doClick();
        }
    }//GEN-LAST:event_id_buscarKeyPressed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
       id_buscar.setText("");
       datosUsuarios.setVisible(false);
       texto.setText("");
       id_buscar.requestFocus();
    }//GEN-LAST:event_limpiarActionPerformed

    private void datosUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosUsuariosMouseClicked
        fila = datosUsuarios.rowAtPoint(evt.getPoint());
        nombreCel = datosUsuarios.getValueAt(fila, 0).toString();
        apellidoCel = datosUsuarios.getValueAt(fila, 1).toString();
        apellidoMCel = datosUsuarios.getValueAt(fila, 2).toString();
        listarN();
    }//GEN-LAST:event_datosUsuariosMouseClicked

    
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
    private javax.swing.JButton buscar;
    private javax.swing.JTable datosUsuarios;
    private javax.swing.JTextField id_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton regresar;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
