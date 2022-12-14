

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.time.*;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chetx
 */
public class controlar_Acceso extends javax.swing.JFrame {
    static Connection cn;
    static Statement s;
    static ResultSet rs;
    static int inquilino, inquilino_visita;
    static String visita;
    /**
     * Creates new form controlar_Acceso
     */
    public controlar_Acceso() {
        initComponents();
        Color c = new Color(240, 230, 140);
        this.getContentPane().setBackground(c);
        fecha_sis.setText(DateTimeFormatter.ofPattern("dd/MM/yy").format(LocalDateTime.now()));
        hora_sistema.setText(DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now()));
    }
    
    public int inquilino(){
        int resultado=0;
        inquilino = Integer.parseInt(id_inquilino.getText());
        String sql="SELECT * FROM USUARIOS WHERE ID=" + inquilino;
        
        Connection conect = null;
        try {
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                String sqlV = "INSERT INTO INQUILINOS_ENTRADAS VALUES("+inquilino+", '"+rs.getString("NOMBRE")+"', '"
                            +rs.getString("APELLIDO_P")+"', '"+fecha_sis.getText()+"', '"+DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now())+"')";
                ResultSet rsV = st.executeQuery(sqlV);
                if(rsV.next()){
                    resultado=1;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexi??n", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conect.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Error de desconexi??n", JOptionPane.ERROR_MESSAGE);
            }
        }

        return resultado;
    }
    
    public int visitas(){
        int resultado=0;
        inquilino_visita = Integer.parseInt(id_inqui_visit.getText());
        visita = nombre_visita.getText();

        String sql="SELECT NOMBRE FROM USUARIOS WHERE ID=" + inquilino_visita;
        //String sqlV = "INSERT INTO VISITANTES VALUES ('"+visita+"', '"+fecha_sis.getText()+"',"+inquilino_visita+", '"+DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now())+"','"+rs.getString("NOMBRE")+"')";
        Connection conect = null;
        try {
            conect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "isw", "isw");
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                resultado=1;
                String sqlV = "INSERT INTO VISITANTES VALUES ('"+visita+"', '"+fecha_sis.getText()+"',"+inquilino_visita+", '"+DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now())+"','"+rs.getString("NOMBRE")+"')";
                rs = st.executeQuery(sqlV);
                if(rs.next()){
                    resultado = 2;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de conexi??n", JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conect.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex, "Error de desconexi??n", JOptionPane.ERROR_MESSAGE);
            }
        }

        return resultado;
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        hora_sistema = new javax.swing.JLabel();
        fecha_sis = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ver_hora = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        id_inquilino = new javax.swing.JTextField();
        validar_inquilino = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombre_visita = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        id_inqui_visit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        validar_visita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        regresar.setBackground(new java.awt.Color(240, 248, 255));
        regresar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        regresar.setText("Regresar");
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipo de Entradas");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setText("Hora:");

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel8.setText("Fecha:");

        hora_sistema.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        hora_sistema.setText("------");

        fecha_sis.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        fecha_sis.setText("------");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logitoV3.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(207, 167, 16));
        jLabel12.setText("Controlar Accesos");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(112, 83, 15), 3));

        jLabel9.setBackground(new java.awt.Color(240, 230, 140));
        jLabel9.setForeground(new java.awt.Color(240, 230, 140));
        jLabel9.setText("jLabel9");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        ver_hora.setBackground(new java.awt.Color(240, 248, 255));
        ver_hora.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        ver_hora.setText("ver hora");
        ver_hora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ver_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_horaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(240, 230, 139));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Inquilino");

        id_inquilino.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        id_inquilino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_inquilinoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_inquilinoKeyTyped(evt);
            }
        });

        validar_inquilino.setBackground(new java.awt.Color(240, 248, 255));
        validar_inquilino.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        validar_inquilino.setText("Validar");
        validar_inquilino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        validar_inquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validar_inquilinoActionPerformed(evt);
            }
        });
        validar_inquilino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                validar_inquilinoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel4.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_inquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(validar_inquilino, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_inquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(validar_inquilino)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(240, 230, 139));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setText("Visitante");

        nombre_visita.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        nombre_visita.setToolTipText("Nombre del visitante");
        nombre_visita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombre_visitaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_visitaKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel5.setText("Nombre(s)");

        id_inqui_visit.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        id_inqui_visit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                id_inqui_visitKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                id_inqui_visitKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel6.setText("ID Inquilino");

        validar_visita.setBackground(new java.awt.Color(240, 248, 255));
        validar_visita.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        validar_visita.setText("Validar");
        validar_visita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        validar_visita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validar_visitaActionPerformed(evt);
            }
        });
        validar_visita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                validar_visitaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(id_inqui_visit, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(nombre_visita)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(validar_visita, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 100, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nombre_visita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_inqui_visit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(validar_visita)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(723, 723, 723)
                .addComponent(jLabel11)
                .addGap(0, 82, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(regresar)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addComponent(jLabel7))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ver_hora)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hora_sistema)
                                .addGap(151, 151, 151)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(fecha_sis))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(regresar)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)))
                .addComponent(ver_hora)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hora_sistema)
                    .addComponent(jLabel8)
                    .addComponent(fecha_sis))
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.setVisible(false);
        if(new login().getTipo() == 1){
            new menu().setVisible(true);
        }else{
            new menu_inquilino().setVisible(true);
        }
    }//GEN-LAST:event_regresarActionPerformed

    private void validar_inquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validar_inquilinoActionPerformed
        try{
            if(!id_inquilino.getText().isEmpty()){
                if(inquilino()==1){
                    JOptionPane.showMessageDialog(null, "Inquilino valido\n"+"Entrada Registrada");
                    id_inquilino.setText("");
                    id_inquilino.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Inquilino invalido", null, JOptionPane.ERROR_MESSAGE);
                    id_inquilino.setText("");
                    id_inquilino.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar datos en los campos primero", "Alerta!", JOptionPane.WARNING_MESSAGE);
                id_inquilino.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Caracteres invalidos!", null, JOptionPane.ERROR_MESSAGE);
            id_inquilino.setText("");
            id_inquilino.requestFocus();
        }
    }//GEN-LAST:event_validar_inquilinoActionPerformed

    private void validar_visitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validar_visitaActionPerformed
       try{
           boolean validacion = false, valS = false;
           char [] s ={'@','!','"','#','$','%','&','/','(',')','=','?','??','??','-',':',';','|','??','??','*','+','.',',','_','<','>','[',']','{','}','??','??','^','`',
                        '1','2','3','4','5','6','7','8','9','0'};

               for(int i = 0; i<nombre_visita.getText().length();i++){
                   for(int j = 0;j<45; j++){
                       if(nombre_visita.getText().charAt(i) == s[j]){
                           valS = true;
                       }
                   }
                   if(!valS){
                    if(nombre_visita.getText().charAt(i) == ' '){
                        validacion = true;
                    }   
                   }
               }
           
            if(!nombre_visita.getText().isEmpty() && !id_inqui_visit.getText().isEmpty()){
                if(!valS && (validacion || nombre_visita.getText().matches("^[a-zA-Z]*$"))){
                    if(visitas()==2){
                        JOptionPane.showMessageDialog(null, "Visitante valido");
                        nombre_visita.setText("");
                        id_inqui_visit.setText("");
                        nombre_visita.requestFocus();
                    }else{
                        JOptionPane.showMessageDialog(null, "ID de inquilino no valido", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
                        //nombre_visita.setText("");
                        id_inqui_visit.setText("");
                        id_inqui_visit.requestFocus();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras en el nombre", "Alerta", JOptionPane.ERROR_MESSAGE);
                    nombre_visita.setText("");
                    id_inqui_visit.setText("");
                    nombre_visita.requestFocus();
                }
            }else if(nombre_visita.getText().isEmpty() && !id_inqui_visit.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del visitante", null, JOptionPane.WARNING_MESSAGE);
                nombre_visita.requestFocus();
            }else if(!nombre_visita.getText().isEmpty() && id_inqui_visit.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe ingresar el id del inquilino", null, JOptionPane.WARNING_MESSAGE);
                id_inqui_visit.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Debe ingresar datos en los campos primero","Alerta",JOptionPane.WARNING_MESSAGE);
                nombre_visita.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Caracteres invalidos!", null, JOptionPane.ERROR_MESSAGE);
            nombre_visita.setText("");
            id_inqui_visit.setText("");
            nombre_visita.requestFocus();
        }
    }//GEN-LAST:event_validar_visitaActionPerformed

    private void id_inquilinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_inquilinoKeyTyped
        if(id_inquilino.getText().length()>5){
            evt.consume();
        }
    }//GEN-LAST:event_id_inquilinoKeyTyped

    private void id_inqui_visitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_inqui_visitKeyTyped
       if(id_inqui_visit.getText().length()>5){
            evt.consume();
            
       }
    }//GEN-LAST:event_id_inqui_visitKeyTyped

    private void nombre_visitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_visitaKeyTyped
        if(nombre_visita.getText().length()>29){
            evt.consume();
        }
        
    }//GEN-LAST:event_nombre_visitaKeyTyped

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        //System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void ver_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_horaActionPerformed
        hora_sistema.setText(DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now()));
    }//GEN-LAST:event_ver_horaActionPerformed

    private void id_inqui_visitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_inqui_visitKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            validar_visita.requestFocus();
        }
    }//GEN-LAST:event_id_inqui_visitKeyPressed

    private void nombre_visitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_visitaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            id_inqui_visit.requestFocus();
        }
    }//GEN-LAST:event_nombre_visitaKeyPressed

    private void validar_visitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validar_visitaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
          validar_visita.doClick();
        }
    }//GEN-LAST:event_validar_visitaKeyPressed

    private void id_inquilinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_id_inquilinoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            validar_inquilino.requestFocus();
        }
    }//GEN-LAST:event_id_inquilinoKeyPressed

    private void validar_inquilinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_validar_inquilinoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            validar_inquilino.doClick();
        }
    }//GEN-LAST:event_validar_inquilinoKeyPressed

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
            java.util.logging.Logger.getLogger(controlar_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(controlar_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(controlar_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(controlar_Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                //jLabel9.setText(hora);
                new controlar_Acceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel fecha_sis;
    private javax.swing.JLabel hora_sistema;
    private javax.swing.JTextField id_inqui_visit;
    private javax.swing.JTextField id_inquilino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre_visita;
    private javax.swing.JButton regresar;
    private javax.swing.JButton validar_inquilino;
    private javax.swing.JButton validar_visita;
    private javax.swing.JButton ver_hora;
    // End of variables declaration//GEN-END:variables
}
