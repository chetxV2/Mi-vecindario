
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chetx
 */
public class modificar_Usuarios extends javax.swing.JFrame {

    static Connection cn;
    static Statement s;
    static ResultSet rs, rsv, rsb;
    static String nombre, apellidoP, apellidoM, edad, telefono, genero, ocupNO, vehNo, calle, casaNo, contraseña;
    static File archivoSalida;
    static FileOutputStream flujoSalida;
    static PrintWriter archivoTxt;
    /**
     * Creates new form modificar_Usuarios
     */
    public modificar_Usuarios() {
        initComponents();
        Color c = new Color(240, 230, 140);
        this.getContentPane().setBackground(c);
        creacionArchivo();
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        //nombre_user.setEditable(false);
        nombre_user.setEnabled(false);
        apellidoP_user.setEnabled(false);
        apellidoM_user.setEnabled(false);
        edad_user.setEnabled(false);
        telefono_user.setEnabled(false);
        ocup_user.setEnabled(false);
        veh_user.setEnabled(false);
        calle_user.setEnabled(false);
        casaNo_user.setEnabled(false);
        pass_user.setEnabled(false);
        opc_hombre.setEnabled(false);
        opc_mujer.setEnabled(false);
        id_user.requestFocus();
        
    }

    public int buscar_user(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT NOMBRE, APELLIDO_P, APELLIDO_M, EDAD, TELEFONO, SEXO, OCUPANTES, VEHICULOS, CALLE, NO_VIVIENDA, CONTRASENA FROM USUARIOS WHERE ID ="+id_user.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                nombre_user.setText(rs.getString("NOMBRE"));
                apellidoP_user.setText(rs.getString("APELLIDO_P"));
                apellidoM_user.setText(rs.getString("APELLIDO_M"));
                edad_user.setText(rs.getString("EDAD"));
                telefono_user.setText(rs.getString("TELEFONO"));
                ocup_user.setText(rs.getString("OCUPANTES"));
                veh_user.setText(rs.getString("VEHICULOS"));
                calle_user.setText(rs.getString("CALLE"));
                casaNo_user.setText(rs.getString("NO_VIVIENDA"));
                pass_user.setText(rs.getString("CONTRASENA"));
                if(rs.getString("SEXO").equals("H")){
                    opc_hombre.setSelected(true);
                }else if(rs.getString("SEXO").equals("M")){
                    opc_mujer.setSelected(true);
                }else{
                    opc_hombre.setSelected(false);
                    opc_mujer.setSelected(false);
                }
                r = 1;
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int verificar(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT NOMBRE, APELLIDO_P, APELLIDO_M, EDAD, NO_VIVIENDA, SEXO, TELEFONO, OCUPANTES, VEHICULOS, CONTRASENA, CALLE FROM USUARIOS WHERE ID ="+id_user.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                /*nombre_user.setText(rs.getString("NOMBRE"));
                apellidoP_user.setText(rs.getString("APELLIDO_P"));
                apellidoM_user.setText(rs.getString("APELLIDO_M"));
                edad_user.setText(rs.getString("EDAD"));
                telefono_user.setText(rs.getString("TELEFONO"));
                ocup_user.setText(rs.getString("OCUPANTES"));
                veh_user.setText(rs.getString("VEHICULOS"));
                calle_user.setText(rs.getString("CALLE"));
                casaNo_user.setText(rs.getString("NO_VIVIENDA"));
                pass_user.setText(rs.getString("CONTRASENA"));
                if(rs.getString("SEXO").equals("H")){
                    opc_hombre.setSelected(true);
                }else{
                    opc_mujer.setSelected(true);
                }*/
                if(/*nombre_user.getText().isEmpty() || apellidoP_user.getText().isEmpty() || apellidoM_user.getText().isEmpty() || edad_user.getText().isEmpty()
                      || telefono_user.getText().isEmpty() || ocup_user.getText().isEmpty() || veh_user.getText().isEmpty() || calle_user.getText().isEmpty() 
                      || casaNo_user.getText().isEmpty() || pass_user.getText().isEmpty() ||*/ !opc_hombre.isSelected() && !opc_mujer.isSelected()){
                    if(nombre_user.getText().equals(rs.getString("NOMBRE")) && apellidoP_user.getText().equals(rs.getString("APELLIDO_P")) && apellidoM_user.getText().equals(rs.getString("APELLIDO_M"))
                        && edad_user.getText().equals(rs.getString("EDAD")) && casaNo_user.getText().equals(rs.getString("NO_VIVIENDA"))&& telefono_user.getText().equals(rs.getString("TELEFONO"))
                        && ocup_user.getText().equals(rs.getString("OCUPANTES")) && veh_user.getText().equals(rs.getString("VEHICULOS")) && calle_user.getText().equals(rs.getString("CALLE")) 
                        && pass_user.getText().equals(rs.getString("CONTRASENA")) && genero.equals(rs.getString("SEXO"))){
                        r = 0;
                    }else{
                        r = 1;
                    }
                }else{
                    if(nombre_user.getText().equals(rs.getString("NOMBRE")) && apellidoP_user.getText().equals(rs.getString("APELLIDO_P")) && apellidoM_user.getText().equals(rs.getString("APELLIDO_M"))
                        && edad_user.getText().equals(rs.getString("EDAD")) && casaNo_user.getText().equals(rs.getString("NO_VIVIENDA")) && telefono_user.getText().equals(rs.getString("TELEFONO"))
                        && ocup_user.getText().equals(rs.getString("OCUPANTES")) && veh_user.getText().equals(rs.getString("VEHICULOS")) && calle_user.getText().equals(rs.getString("CALLE")) 
                        && pass_user.getText().equals(rs.getString("CONTRASENA")) && genero.equals(rs.getString("SEXO"))){
                        r = 0;
                    }else{
                        r = 1;
                    }
                }
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int cambiar(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="UPDATE USUARIOS SET NOMBRE = '"+nombre_user.getText()+"', APELLIDO_P = '"+apellidoP_user.getText()+"', APELLIDO_M = '"+apellidoM_user.getText()
                    +"', EDAD = "+edad_user.getText()+",SEXO = '"+genero+"', TELEFONO = '"+telefono_user.getText()+"', OCUPANTES = "+ocup_user.getText()
                    +", VEHICULOS = "+veh_user.getText()+", CALLE = '"+calle_user.getText()+"', NO_VIVIENDA = "+casaNo_user.getText()
                    +", CONTRASENA = '"+pass_user.getText()+"' WHERE ID = "+id_user.getText();
            //String sql="UPDATE USUARIOS SET NOMBRE = '"+nombre_user.getText()+"' WHERE ID = "+id_user.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                r = 1;
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int copia(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT NOMBRE_VI, FECHA, HORA, ID, NOMBRE FROM VISITANTES WHERE ID ="+id_user.getText();
            rs = st.executeQuery(sql);
            while(rs.next()){
                archivoTxt.println(rs.getString("NOMBRE_VI")+" "+rs.getString("FECHA")+" "+rs.getString("HORA")+" "+rs.getString("ID")+" "+rs.getString("NOMBRE"));
                r = 1;
            }
            archivoTxt.close();
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int eliminar(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="DELETE FROM VISITANTES WHERE ID = "+id_user.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                String sqlv="DELETE FROM USUARIOS WHERE ID = "+id_user.getText();
                rsv = st.executeQuery(sqlv);
                if(rsv.next()){
                    r = 1;
                }
                rsv.close();
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int eliminar_user(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="DELETE FROM USUARIOS WHERE ID = "+id_user.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                r = 1;
            }
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error...."+e, null, JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }
    
    public int checar(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT ID FROM VISITANTES WHERE ID = "+id_user.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                r = 1;
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public int comprobar(){
        int r = 0;
        try{
            Connection conect = null;
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            String sql="SELECT ID FROM USUARIOS WHERE ID = "+id_user.getText();
            rs = st.executeQuery(sql);
            if(rs.next()){
                r = 1;
            }
            rs.close();
        }catch(Exception e){
            
        }
        return r;
    }
    
    public void creacionArchivo(){
        try{
            archivoSalida  = new File("C:\\Users\\js98v\\Desktop\\pdfs\\archivoE.txt");
            flujoSalida  = new FileOutputStream(archivoSalida);
            archivoTxt = new PrintWriter(flujoSalida);
        }catch(Exception e){
            
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        telefono_user = new javax.swing.JTextField();
        opc_hombre = new javax.swing.JCheckBox();
        opc_mujer = new javax.swing.JCheckBox();
        ocup_user = new javax.swing.JTextField();
        veh_user = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        calle_user = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        casaNo_user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pass_user = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nombre_user = new javax.swing.JTextField();
        apellidoP_user = new javax.swing.JTextField();
        apellidoM_user = new javax.swing.JTextField();
        edad_user = new javax.swing.JTextField();
        id_user = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        modificar.setBackground(new java.awt.Color(240, 248, 255));
        modificar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setBackground(new java.awt.Color(240, 248, 255));
        eliminar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        eliminar.setText("Eliminar Usuario");
        eliminar.setToolTipText("Elimina el usuario ");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel6.setText("Telefono");

        regresar.setBackground(new java.awt.Color(240, 248, 255));
        regresar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("Genero");

        telefono_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        telefono_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefono_userKeyTyped(evt);
            }
        });

        opc_hombre.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        opc_hombre.setText("Hombre");

        opc_mujer.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        opc_mujer.setText("Mujer");

        ocup_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ocup_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ocup_userKeyTyped(evt);
            }
        });

        veh_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        veh_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                veh_userKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setText("ID de Usuario:");

        calle_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Nombre(s)");

        casaNo_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        casaNo_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                casaNo_userKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        pass_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pass_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pass_userKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setText("Apellido Materno");

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel8.setText("No. de Ocupantes");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel5.setText("Edad");

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel9.setText("No. de Vehiculos");

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel10.setText("Calle");

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel11.setText("Número de Casa");

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel12.setText("Contraseña");

        nombre_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        apellidoP_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        apellidoM_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        edad_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        edad_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edad_userKeyTyped(evt);
            }
        });

        id_user.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        id_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_userActionPerformed(evt);
            }
        });
        id_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_userKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_userKeyTyped(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(240, 248, 255));
        buscar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logitoV3.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(207, 167, 16));
        jLabel15.setText("Modificar Usuarios");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 83, 15), 3));

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("*La contraseña debe ser");

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("minimo 6 caracteres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opc_hombre)
                        .addGap(18, 18, 18)
                        .addComponent(opc_mujer))
                    .addComponent(nombre_user)
                    .addComponent(apellidoP_user)
                    .addComponent(apellidoM_user)
                    .addComponent(edad_user)
                    .addComponent(telefono_user)
                    .addComponent(ocup_user)
                    .addComponent(veh_user)
                    .addComponent(calle_user)
                    .addComponent(casaNo_user)
                    .addComponent(pass_user))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel14))
                            .addComponent(eliminar))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(id_user, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(regresar)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel15)))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel13))
                            .addComponent(regresar)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscar))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombre_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(apellidoP_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(apellidoM_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(edad_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(telefono_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(opc_hombre)
                            .addComponent(opc_mujer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ocup_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(veh_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(calle_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(casaNo_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pass_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(modificar)
                        .addGap(339, 339, 339)))
                .addComponent(jLabel17)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try{
            boolean validacion = false, val_p= false, val_m = false, val_c = false, valS = false;
           char [] s ={'@','!','"','#','$','%','&','/','(',')','=','?','¿','¡','-',':',';','|','°','¬','*','+','.',',','_','<','>','[',']','{','}','´','¨','^','`',
                        '1','2','3','4','5','6','7','8','9','0'};
           char [] c ={'@','!','"','#','$','%','&','/','(',')','=','?','¿','¡','-',':',';','|','°','¬','*','+','.',',','_','<','>','[',']','{','}','´','¨','^','`'};
               for(int i = 0; i<nombre_user.getText().length();i++){
                   for(int j = 0;j<45; j++){
                       if(nombre_user.getText().charAt(i) == s[j]){
                           valS = true;
                       }
                   }
                   if(!valS){
                    if(nombre_user.getText().charAt(i) == ' ' && nombre_user.getText().charAt(0) != ' '){
                        validacion = true;
                    }   
                   }
               }
               validacion = false;
               for(int i = 0; i<apellidoP_user.getText().length();i++){
                   for(int j = 0;j<45; j++){
                       if(apellidoP_user.getText().charAt(i) == s[j]){
                           val_p= true;
                       }
                   }
                   if(!val_p){
                    if(apellidoP_user.getText().charAt(0) != ' ' && apellidoP_user.getText().charAt(i) == ' '){
                        validacion = true;
                    }   
                   }
               }
               validacion = false;
               for(int i = 0; i<apellidoM_user.getText().length();i++){
                   for(int j = 0;j<45; j++){
                       if(apellidoM_user.getText().charAt(i) == s[j]){
                           val_m = true;
                       }
                   }
                   if(!val_m){
                    if(apellidoM_user.getText().charAt(0) != ' ' && apellidoM_user.getText().charAt(i) == ' '){
                        validacion = true;
                    }   
                   }
               }
               validacion = false;
               for(int i = 0; i<calle_user.getText().length();i++){
                   for(int j = 0;j<35; j++){
                       if(calle_user.getText().charAt(i) == c[j]){
                           val_c = true;
                       }
                   }
                   if(!val_c){
                    if(calle_user.getText().charAt(0) != ' ' && calle_user.getText().charAt(i) == ' '){
                        validacion = true;
                    }   
                   }
               }
            
            if(!id_user.getText().isEmpty()){
                if(id_user.getText().matches("^[0-9]*$")){
                    //if(nombre_user.getText().matches("^[a-zA-Z]*$")){
                        if(!valS && (validacion || nombre_user.getText().matches("^[a-zA-Z]*$")) && !nombre_user.getText().isEmpty()){
                            if(!val_p && (validacion || apellidoP_user.getText().matches("^[a-zA-Z]*$")) && !apellidoP_user.getText().isEmpty()){
                        if(apellidoM_user.getText().matches("^[a-zA-Z]*$") && !apellidoM_user.getText().isEmpty()){
                            if(!val_c && (!calle_user.getText().startsWith(" ") && !calle_user.getText().isEmpty())){
                                if(edad_user.getText().matches("^[0-9]*$") && !edad_user.getText().isEmpty()){
                                    if(telefono_user.getText().matches("^[0-9]*$")&& !telefono_user.getText().isEmpty() && telefono_user.getText().length()==10){
                                        if(pass_user.getText().length()>=6 && !pass_user.getText().isEmpty()){
                                            if(opc_hombre.isSelected() && !opc_mujer.isSelected()){
                                                if(!ocup_user.getText().isEmpty() && ocup_user.getText().matches("^[0-9]*$")){
                                                    if(!veh_user.getText().isEmpty() && veh_user.getText().matches("^[0-9]*$")){
                                                        if(!casaNo_user.getText().isEmpty() && casaNo_user.getText().matches("^[0-9]*$")){
                                                            genero = "H";
                                                            if(verificar()== 1){
                                                                if(cambiar() == 1){
                                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                                    id_user.requestFocus();
                                                                    jLabel16.setVisible(false);
                                                                    jLabel17.setVisible(false);
                                                                    pass_user.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                                                }else{
                                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                                }
                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                            casaNo_user.requestFocus();
                                                            casaNo_user.setText("");
                                                        }
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                        veh_user.requestFocus();
                                                        veh_user.setText("");
                                                    }
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                    ocup_user.requestFocus();
                                                    ocup_user.setText("");
                                                }
                                            /*genero = "H";
                                            if(verificar()== 1){
                                                if(cambiar() == 1){
                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                    id_user.requestFocus();
                                                    jLabel16.setVisible(false);
                                                    jLabel17.setVisible(false);
                                                    pass_user.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                            }*/
                                        }else if(!opc_hombre.isSelected() && opc_mujer.isSelected()){
                                            if(!ocup_user.getText().isEmpty() && ocup_user.getText().matches("^[0-9]*$")){
                                                    if(!veh_user.getText().isEmpty() && veh_user.getText().matches("^[0-9]*$")){
                                                        if(!casaNo_user.getText().isEmpty() && casaNo_user.getText().matches("^[0-9]*$")){
                                                            genero = "M";
                                                            if(verificar()== 1){
                                                                if(cambiar() == 1){
                                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                                    id_user.requestFocus();
                                                                    jLabel16.setVisible(false);
                                                                    jLabel17.setVisible(false);
                                                                    pass_user.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                                                }else{
                                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                                }
                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                            casaNo_user.requestFocus();
                                                            casaNo_user.setText("");
                                                        }
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                        veh_user.requestFocus();
                                                        veh_user.setText("");
                                                    }
                                            }else{
                                                    JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                    ocup_user.requestFocus();
                                                    ocup_user.setText("");
                                            }
                                            /*genero = "M";
                                            if(verificar()== 1){
                                                if(cambiar() == 1){
                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                    id_user.requestFocus();
                                                    jLabel16.setVisible(false);
                                                    jLabel17.setVisible(false);
                                                    pass_user.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                            }*/
                                        }else if(!opc_hombre.isSelected() && !opc_mujer.isSelected()){
                                            if(!ocup_user.getText().isEmpty() && ocup_user.getText().matches("^[0-9]*$")){
                                                    if(!veh_user.getText().isEmpty() && veh_user.getText().matches("^[0-9]*$")){
                                                        if(!casaNo_user.getText().isEmpty() && casaNo_user.getText().matches("^[0-9]*$")){
                                                            genero = " ";
                                                            if(verificar()== 1){
                                                                if(cambiar() == 1){
                                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                                    id_user.requestFocus();
                                                                    jLabel16.setVisible(false);
                                                                    jLabel17.setVisible(false);
                                                                    pass_user.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                                                }else{
                                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                                }
                                                            }else{
                                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                                            }
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                            casaNo_user.requestFocus();
                                                            casaNo_user.setText("");
                                                        }
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                        veh_user.requestFocus();
                                                        veh_user.setText("");
                                                    }
                                            }else{
                                                    JOptionPane.showMessageDialog(null, "Este campo el obligatorio\n"+"Solo se aceptan números.", null,JOptionPane.ERROR_MESSAGE);
                                                    ocup_user.requestFocus();
                                                    ocup_user.setText("");
                                            }
                                            /*genero = " ";
                                            if(verificar()== 1){
                                                if(cambiar() == 1){
                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                    id_user.requestFocus();
                                                    jLabel16.setVisible(false);
                                                    jLabel17.setVisible(false);
                                                    pass_user.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                            }*/
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Ambos generos estan selecionados", null, JOptionPane.WARNING_MESSAGE);
                                        }
                                        }else{
                                            pass_user.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                                            pass_user.requestFocus();
                                            jLabel16.setVisible(true);
                                            jLabel17.setVisible(true);
                                        }
                                        /*if(opc_hombre.isSelected() && !opc_mujer.isSelected()){
                                            genero = "H";
                                            if(verificar()== 1){
                                                if(cambiar() == 1){
                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                    id_user.requestFocus();
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                            }
                                        }else if(!opc_hombre.isSelected() && opc_mujer.isSelected()){
                                            genero = "M";
                                            if(verificar()== 1){
                                                if(cambiar() == 1){
                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                            }
                                        }else if(!opc_hombre.isSelected() && !opc_mujer.isSelected()){
                                            genero = " ";
                                            if(verificar()== 1){
                                                if(cambiar() == 1){
                                                    JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Ambos generos estan selecionados", null, JOptionPane.WARNING_MESSAGE);
                                        }*/
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Este campo es obligatorio.\n"+"!Caracteres invalidos!.", "Alerta", JOptionPane.ERROR_MESSAGE);
                                        //telefono_user.setText("");
                                        telefono_user.requestFocus();
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Este campo es obligatorio.\n"+"!Caracteres invalidos!.", "Alerta", JOptionPane.ERROR_MESSAGE);
                                    //edad_user.setText("");
                                    edad_user.requestFocus();
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Este campo es obligatorio.\n"+"El campo de calle no debe empezar con espacio\n"+ "en blanco o estar vacia ni tener simbolos.", "Alerta", JOptionPane.ERROR_MESSAGE);
                                //calle_user.setText("");
                                calle_user.requestFocus();
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Este campo es obligatorio.\n"+"Solo se permiten letras en el apellido materno\n"+"ni espacios en blanco al principio.", "Alerta", JOptionPane.ERROR_MESSAGE);
                            //apellidoM_user.setText("");
                            apellidoM_user.requestFocus();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Este campo es obligatorio.\n"+"Solo se permiten letras en el apellido paterno\n"+"ni espacios en blanco al principio.", "Alerta", JOptionPane.ERROR_MESSAGE);
                        //apellidoP_user.setText("");
                        apellidoP_user.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Este campo es obligatorio.\n"+"Solo se permiten letras en el nombre.\n"+ "sin espacios al principio.", "Alerta", JOptionPane.ERROR_MESSAGE);
                    //nombre_user.setText("");
                    nombre_user.requestFocus();
                }
                        /*if(opc_hombre.isSelected() && !opc_mujer.isSelected()){
                        genero = "H";
                        if(verificar()== 1){
                            if(cambiar() == 1){
                                JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }else if(!opc_hombre.isSelected() && opc_mujer.isSelected()){
                        genero = "M";
                         if(verificar()== 1){
                            if(cambiar() == 1){
                                JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }else if(!opc_hombre.isSelected() && !opc_mujer.isSelected()){
                        genero = " ";
                         if(verificar()== 1){
                            if(cambiar() == 1){
                                JOptionPane.showMessageDialog(null, "Usuario modificado exitosamente.");
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario.", null, JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Ambos generos estan selecionados", null, JOptionPane.WARNING_MESSAGE);
                    }*/
                    /*}else{
                        JOptionPane.showMessageDialog(null, "Solo se permiten letras", null, JOptionPane.WARNING_MESSAGE);
                    }*/
                }else{
                    JOptionPane.showMessageDialog(null, "Solo se permiten números", null, JOptionPane.WARNING_MESSAGE);
                    id_user.setText("");
                    id_user.requestFocus();
                }
                
                //if(verificar() == 1){
                    //JOptionPane.showMessageDialog(null, "SMN");
                    
                    
                /*}else{
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos.", null, JOptionPane.ERROR_MESSAGE);
                }*/
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar un ID de Usuario primero", null, JOptionPane.WARNING_MESSAGE);
                id_user.requestFocus();
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.setVisible(false);
        new menu().setVisible(true);
    }//GEN-LAST:event_regresarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try{
            if(!id_user.getText().isEmpty()){
                if(id_user.getText().matches("^[0-9]*$")){
                    opc_hombre.setSelected(false);
                        opc_mujer.setSelected(false);
                    if(buscar_user()==1){
                        nombre_user.setEnabled(true);
                        apellidoP_user.setEnabled(true);
                        apellidoM_user.setEnabled(true);
                        edad_user.setEnabled(true);
                        telefono_user.setEnabled(true);
                        ocup_user.setEnabled(true);
                        veh_user.setEnabled(true);
                        calle_user.setEnabled(true);
                        casaNo_user.setEnabled(true);
                        pass_user.setEnabled(true);
                        opc_hombre.setEnabled(true);
                        opc_mujer.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "No existe el usuario", "Alerta", JOptionPane.ERROR_MESSAGE);
                        id_user.setText("");
                        id_user.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Solo se aceptan números", null, JOptionPane.WARNING_MESSAGE);
                    id_user.setText("");
                    id_user.requestFocus();
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar un ID de Usuario primero", null, JOptionPane.WARNING_MESSAGE);
                id_user.requestFocus();
            }
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        try{
            
            if(!id_user.getText().isEmpty()){
                if(id_user.getText().matches("^[0-9]*$")){
                    //int resp = JOptionPane.showConfirmDialog(null, "¿Desea salir?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(comprobar()==1){
                        if(checar()== 1){
                            int resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar al Usuario?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(resp == 0){
                                if(copia() == 1){
                                if(eliminar()==1){
                                    JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
                                    id_user.setText("");
                                    id_user.requestFocus();
                                    nombre_user.setText("");
                                    apellidoP_user.setText("");
                                    apellidoM_user.setText("");
                                    edad_user.setText("");
                                    telefono_user.setText("");
                                    ocup_user.setText("");
                                    veh_user.setText("");
                                    calle_user.setText("");
                                    casaNo_user.setText("");
                                    pass_user.setText("");
                                    opc_hombre.setSelected(false);
                                    opc_mujer.setSelected(false);
                                    nombre_user.setEnabled(false);
                                    apellidoP_user.setEnabled(false);
                                    apellidoM_user.setEnabled(false);
                                    edad_user.setEnabled(false);
                                    telefono_user.setEnabled(false);
                                    ocup_user.setEnabled(false);
                                    veh_user.setEnabled(false);
                                    calle_user.setEnabled(false);
                                    casaNo_user.setEnabled(false);
                                    pass_user.setEnabled(false);
                                    opc_hombre.setEnabled(false);
                                    opc_mujer.setEnabled(false);
                                }else{
                                    JOptionPane.showMessageDialog(null, "No se pudo eliminar", null, JOptionPane.ERROR_MESSAGE);
                                    //id_user.setText("");
                                    id_user.requestFocus();
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo realizar el guardado de datos", null, JOptionPane.ERROR_MESSAGE);
                            }
                            }
                            
                        }else{
                            int resp = JOptionPane.showConfirmDialog(null, "¿Desea Eliminar al Usuario?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(resp == 0){
                                if(eliminar_user()==1){
                                JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
                                id_user.setText("");
                                id_user.requestFocus();
                                nombre_user.setText("");
                                apellidoP_user.setText("");
                                apellidoM_user.setText("");
                                edad_user.setText("");
                                telefono_user.setText("");
                                ocup_user.setText("");
                                veh_user.setText("");
                                calle_user.setText("");
                                casaNo_user.setText("");
                                pass_user.setText("");
                                opc_hombre.setSelected(false);
                                opc_mujer.setSelected(false);
                                nombre_user.setEnabled(false);
                                apellidoP_user.setEnabled(false);
                                apellidoM_user.setEnabled(false);
                                edad_user.setEnabled(false);
                                telefono_user.setEnabled(false);
                                ocup_user.setEnabled(false);
                                veh_user.setEnabled(false);
                                calle_user.setEnabled(false);
                                casaNo_user.setEnabled(false);
                                pass_user.setEnabled(false);
                                opc_hombre.setEnabled(false);
                                opc_mujer.setEnabled(false);
                            }else{
                                JOptionPane.showMessageDialog(null, "No se pudo eliminar", null, JOptionPane.ERROR_MESSAGE);
                                //id_user.setText("");
                                id_user.requestFocus();
                            } 
                            }
                            
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "No existe el usuario", null, JOptionPane.ERROR_MESSAGE);
                        id_user.setText("");
                        id_user.requestFocus();
                    }
                        
                    
                    
                /*if(copia() == 1){
                    if(eliminar()==1){
                        JOptionPane.showMessageDialog(null, "Listo");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar", null, JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    if(eliminar_user()==1){
                        JOptionPane.showMessageDialog(null, "Listo");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar", null, JOptionPane.ERROR_MESSAGE);
                    } 
                }*/
                }else{
                    JOptionPane.showMessageDialog(null, "Solo se aceptan números", null, JOptionPane.WARNING_MESSAGE);
                    id_user.setText("");
                    id_user.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar un ID de Usuario primero", null, JOptionPane.WARNING_MESSAGE);
                id_user.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error....."+e, "ALert", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void id_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_userKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscar.doClick();
        }
        
    }//GEN-LAST:event_id_userKeyPressed

    private void id_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_userKeyTyped
        if(id_user.getText().length()>5){
            evt.consume();
        }
        else if(id_user.getText().length()<6){
            nombre_user.setEnabled(false);
        apellidoP_user.setEnabled(false);
        apellidoM_user.setEnabled(false);
        edad_user.setEnabled(false);
        telefono_user.setEnabled(false);
        ocup_user.setEnabled(false);
        veh_user.setEnabled(false);
        calle_user.setEnabled(false);
        casaNo_user.setEnabled(false);
        pass_user.setEnabled(false);
        opc_hombre.setEnabled(false);
        opc_mujer.setEnabled(false);
        nombre_user.setText("");
        apellidoP_user.setText("");
        apellidoM_user.setText("");
        edad_user.setText("");
        telefono_user.setText("");
        ocup_user.setText("");
        veh_user.setText("");
        calle_user.setText("");
        casaNo_user.setText("");
        pass_user.setText("");
        opc_hombre.setSelected(false);
        opc_mujer.setSelected(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        pass_user.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        }
    }//GEN-LAST:event_id_userKeyTyped

    private void id_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_userActionPerformed
        
    }//GEN-LAST:event_id_userActionPerformed

    private void edad_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edad_userKeyTyped
        if(edad_user.getText().length()>1){
            evt.consume();
        }
    }//GEN-LAST:event_edad_userKeyTyped

    private void telefono_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefono_userKeyTyped
        if(telefono_user.getText().length()>9){
            evt.consume();
        }
    }//GEN-LAST:event_telefono_userKeyTyped

    private void ocup_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ocup_userKeyTyped
        if(ocup_user.getText().length()>1){
            evt.consume();
        }
    }//GEN-LAST:event_ocup_userKeyTyped

    private void veh_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_veh_userKeyTyped
        if(veh_user.getText().length()>1){
            evt.consume();
        }
    }//GEN-LAST:event_veh_userKeyTyped

    private void casaNo_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_casaNo_userKeyTyped
        if(casaNo_user.getText().length()>4){
            evt.consume();
        }
    }//GEN-LAST:event_casaNo_userKeyTyped

    private void pass_userKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_userKeyTyped
        if(pass_user.getText().length()>9){
            evt.consume();
        }
    }//GEN-LAST:event_pass_userKeyTyped

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
            java.util.logging.Logger.getLogger(modificar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificar_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidoM_user;
    private javax.swing.JTextField apellidoP_user;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField calle_user;
    private javax.swing.JTextField casaNo_user;
    private javax.swing.JTextField edad_user;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField id_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre_user;
    private javax.swing.JTextField ocup_user;
    private javax.swing.JCheckBox opc_hombre;
    private javax.swing.JCheckBox opc_mujer;
    private javax.swing.JTextField pass_user;
    private javax.swing.JButton regresar;
    private javax.swing.JTextField telefono_user;
    private javax.swing.JTextField veh_user;
    // End of variables declaration//GEN-END:variables
}
