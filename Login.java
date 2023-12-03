/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import static com.mycompany.sab.Shule.shule;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author Muba
 */
public class Login extends javax.swing.JFrame {
    
    // variables
    private final Kanzidata kanzidata;
    private int kajaribuMara;
    
    /**
     * Creates new form Login
     */
    public Login() {
        this.kanzidata = new Kanzidata();
        this.kajaribuMara = 0;
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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonLogin = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/head.jpg"))); // NOI18N

        jTextFieldUsername.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldUsername.setToolTipText("Enter Username");
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        jButtonLogin.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.jpg"))); // NOI18N

        jPasswordFieldPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPasswordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLogin))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonLogin)
                            .addComponent(jButtonCancel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(42, 42, 42)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        login();       
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        login();
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        Kanzidata.disconnect();
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jPasswordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordActionPerformed
        login();        
    }//GEN-LAST:event_jPasswordFieldPasswordActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Kanzidata.disconnect();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Login login = new Login();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });
    }

    /**
     * login kwenye mfumo
     */
    private void login(){
        
        // soma username na password
        String username = jTextFieldUsername.getText();
        String password = String.valueOf(jPasswordFieldPassword.getPassword());
        
        // activate program
        if(jButtonLogin.getText().equals("Activate")){
            activateProgram(username,password);            
        }
        
        // reset password
        else if(jButtonLogin.getText().equals("Reset")){
            
            // hakiki kwanza
            System.out.println(somaHash("dhihaka3664"));
            if(username.equals("root") && password.equals(somaHash("dhihaka3664"))){// reset version
                
                Mjumbe.oneshaUjumbe("Program reset sucessfully \n"
                + "Please create username and password");
                
                jTextFieldUsername.setText("");
                jPasswordFieldPassword.setText("");
                jButtonLogin.setText("Save"); 
                kajaribuMara = 0;
            }
            else{
                Mjumbe.oneshaUjumbe("Reset code note Valid");
            }
        }
        
        // save username na password ktk kanzidata
        else if(jButtonLogin.getText().equals("Save")){
            saveCredentials(username, password);
        }
                
        // login ktk kanzi data
        else{
            
            if(Kanzidata.tableIpo("Users")){ // hakiki credential
                            
                boolean credentialZipo = kanzidata.login(username, Tafuta.hashKey(password), Tafuta.hashKey(mac()));
                
                if(credentialZipo){
                    
                    if(!Kanzidata.tableIpo("schoolInfo")){
                        kanzidata.tengenezaTableSchoolInfo();
                    }
                    
                    funguaDashBoard();
                }
                else{ // akijaribu mara tatu na kushindwa imuulize kama ana reset au ijikate
                    kajaribuMara++;
                    if(kajaribuMara < 3){
                        Mjumbe.oneshaUjumbe("Username or Password not correct");  
                    }
                    else{
                        int jibu = Mjumbe.ulizaSwali("Do you want to reset password?");
                        
                        if(jibu == 0){
                            mpeCode();
                            jButtonLogin.setText("Reset");
                        }
                        else{ 
                            this.dispose();
                        }
                    }
                }
            }
            else{ // program haijawa activated bado

                int jibu = Mjumbe.ulizaSwali("Your program is not activated yet \n "
                                              + "Do you want to activate it right now");
                if(jibu == 0){
                    mpeCode();
                    jButtonLogin.setText("Activate");
                }
                else{
                    this.dispose();
                }
            }
        }
    }
    
    /**
     * Kusoma MAC
     * @return mac
     */
    private String mac(){
        String str = "";
        
        try{
            
            final Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
            
            while (e.hasMoreElements()) {
                NetworkInterface f = e.nextElement();
                
                final byte [] mac = f.getHardwareAddress();
                
                if (mac != null) {
                    StringBuilder sb = new StringBuilder();
                    
                    for (int i = 0; i < mac.length; i++){
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        str = str.concat(sb.toString());
                    }
                }   
            }
           
        }
        catch(SocketException e){
            Mjumbe.log(e, "Login mac");
        }
        
        return str;
    }
    
    /**
     * Kusoma MAC na kucompute code
     * @return code
     */
    private String somaCode() {
        int code = mac().hashCode();
        
        if(code < 0){
            code = -1*code;
        }
        return code+"";
    }
    
    /**
     * kukokotoa hash key kwa kutumia SHA256 algorithm
     * @param neno neno unalotaka kukokotoa hash
     * @return hash (character 10 za mwanzo)
     */
    private String somaHash(String neno) {
        return Tafuta.hashKey(somaCode()+ neno).substring(0, 10);
    }
       
    /**
     * kufungua main window/dashboard
     */
    private void funguaDashBoard() {
       
        // load taarifa 
        loadData();
         
        // nenda home page/dashboard
        Main home = new Main();
        home.setVisible(true);
        home.setLocationRelativeTo(null);     
    
        if(shule.schoolName() == null){
            Settings.zuiaMenu(Main.jMenuFile, Main.jMenuStaffs, Main.jMenuStudents, Main.jMenuSettings); 
        }
        
        this.dispose(); 
    }
    
    /**
     * ku activate program
     * @param username username ya mtumiaji
     * @param password neno la siri
     */
    private void activateProgram(String username, String password) {
        
        if(username.equals("mbaraka") && password.equals("magogo")){// trial version
            Mjumbe.oneshaUjumbe("Data will not be saved in trial mode");
            Kanzidata.disconnect();
            funguaDashBoard();
        }
        else{
            System.out.println(somaHash("dhihaka6464"));
            if(username.equals("root") && password.equals(somaHash("dhihaka6464"))){// activated version

                Mjumbe.oneshaUjumbe("Program activated sucessfully \n"
                    + "Please create username and password");

                jTextFieldUsername.setText("");
                jPasswordFieldPassword.setText("");
                jButtonLogin.setText("Save");
            }
            else{

                kajaribuMara++;
                if(kajaribuMara < 3){
                    Mjumbe.oneshaUjumbe("Activation code note Valid");
                }
                else{
                    this.dispose();
                }
            }
        }
    }
    
    /**
     * kusave taarifa za mtumiaji
     * @param username username
     * @param password neno la siri
     */
    private void saveCredentials(String username, String password) {
        
        if(Kanzidata.tableIpo("Users")){
            kanzidata.updateTaarifaZaUsers(username,  Tafuta.hashKey(password), Tafuta.hashKey(mac()));
        }
        else{
            kanzidata.tengenezaTableUsersInfo();
            kanzidata.ingizaTaarifaZaUsers(username, Tafuta.hashKey(password), Tafuta.hashKey(mac()));           
        }
        
        Mjumbe.oneshaUjumbe("Credential saved \n"
            + "Login using credantial to proceed");

        jButtonLogin.setText("Login");
        jTextFieldUsername.setText("");
        jPasswordFieldPassword.setText("");
    }
    
    /**
     * kuonesha activation code kwa mtumiaji
     */
    private void mpeCode() {
        Mjumbe.oneshaUjumbe("Your token is "+somaCode());
        jTextFieldUsername.setText("");
        jPasswordFieldPassword.setText("");
    }
    
    /**
     * kuload taarifa kutoka ktk database
     */
    private void loadData() {
        /*Kanzidata.deleteTable("streamInfo");
        Kanzidata.deleteTable("classInfo");
        Kanzidata.deleteTable("studentInfo");*/
        if(Kanzidata.tableIpo("schoolInfo")){
            kanzidata.loadTaarifaZaShule();
            
            if(Kanzidata.tableIpo("classInfo")){
                kanzidata.loadMadarasa();
            }
            if(Kanzidata.tableIpo("streamInfo")){
                kanzidata.loadMikondo();
            }
            if(Kanzidata.tableIpo("studentInfo")){
                kanzidata.loadWanafunzi();
            }
            
            if(Kanzidata.tableIpo("PREMS")){
                kanzidata.loadPrems();
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

}