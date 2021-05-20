/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;

import ConnectionToDatabase.Cnx;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RegistrationForm extends javax.swing.JFrame {

    /**
     * Creates new form RegistrationForm
     */
    public RegistrationForm() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        RegistrationFormLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        JobLevelLabel = new javax.swing.JLabel();
        PhoneNumLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        JobLevel = new javax.swing.JTextField();
        PhoneNum = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        ConfirmPasswordLabel = new javax.swing.JLabel();
        ConfirmPassword = new javax.swing.JPasswordField();
        SaveButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RegistrationFormLabel.setFont(new java.awt.Font("Bell MT", 1, 48)); // NOI18N
        RegistrationFormLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RegistrationFormLabel.setText("Registration Form");

        NameLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NameLabel.setText("NAME");

        Name.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        EmailLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        EmailLabel.setText("EMAIL");

        Email.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        JobLevelLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        JobLevelLabel.setText("JOB LEVEL");

        PhoneNumLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PhoneNumLabel.setText("PHONE NO.");

        PasswordLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PasswordLabel.setText("PASSWORD");

        JobLevel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        PhoneNum.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        PhoneNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PhoneNumKeyTyped(evt);
            }
        });

        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PasswordKeyTyped(evt);
            }
        });

        ConfirmPasswordLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ConfirmPasswordLabel.setText("CONFIRM PASSWORD");

        ConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ConfirmPasswordKeyTyped(evt);
            }
        });

        SaveButton.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        SaveButton.setText("SAVE");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        CancelButton.setText("CANCEL");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(RegistrationFormLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(257, 257, 257)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ConfirmPasswordLabel)
                                            .addComponent(ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JobLevelLabel)
                                        .addComponent(EmailLabel)
                                        .addComponent(PhoneNumLabel)
                                        .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                                        .addComponent(PhoneNum)
                                        .addComponent(JobLevel)
                                        .addComponent(NameLabel)
                                        .addComponent(Name))
                                    .addComponent(PasswordLabel)
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 67, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(CancelButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(RegistrationFormLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(NameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JobLevelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JobLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PhoneNumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordLabel)
                    .addComponent(ConfirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
       
        PreparedStatement st;
        PreparedStatement st2;
        ResultSet rs;
        
        int ID ;
        String name = Name.getText();
        String joblevel = JobLevel.getText();
        String hp = PhoneNum.getText();
        String email = Email.getText();
        String password = String.valueOf(Password.getPassword());
        String cpassword = String.valueOf(ConfirmPassword.getPassword());
        
        Cnx connectionclass = new Cnx();
        
        try {
            //Check if there are any empty fields
            if(name.equals("")||joblevel.equals("")||email.equals("")||hp.equals("")){
                JOptionPane.showMessageDialog(null, "Alert! Please enter all requirement field");
                throw new Exception("");
            }
            
            //Check if the email is a valid email
            Matcher mat = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$").matcher(email);
            if(!mat.find()){
                JOptionPane.showMessageDialog(null, "ALERT!\nInvalid Email");
                Email.setText(null);
                throw new Exception("");
            }
            
            //check if the password fields is empty
            if(password.equals("")||cpassword.equals("")){
                JOptionPane.showMessageDialog(null, "ALERT!Password field is empty");
                throw new Exception("");
            }
            
            //check if password and confirm password is equal
            if(!password.equals(cpassword)){
                JOptionPane.showMessageDialog(null, "Password is not matched!");
                ConfirmPassword.setText(null);
                throw new Exception("");
            }
            
            //Check if the userID already exist
            String query = "SELECT * FROM [users] WHERE email = ?";
            
            //Connect to database
            st2 = connectionclass.getConnection().prepareStatement(query);
            
            st2.setString(1, email);
            rs = st2.executeQuery();
            if (rs.next()) {
                //The account already exist
                JOptionPane.showMessageDialog(null, "There is an existing account!","Login Error!", 2);
            }
            else{
                
                Connection connection = connectionclass.getConnection();
                Statement st3 = connection.createStatement();
                String query1=" SELECT MAX(userID) FROM [users] ";
                ResultSet rs1 = st3.executeQuery(query1);
                rs1.next();
                ID = rs1.getInt("") + 1;
                
                String sql = "INSERT INTO [users] VALUES (?,?,?,?,?,?)";
                
                st = connectionclass.getConnection().prepareStatement(sql);
                st.setInt(1, ID);
                st.setString(2, name);
                st.setString(3, email);
                st.setString(4, password);
                st.setString(5, joblevel);
                st.setString(6, hp);
                
                if(st.executeUpdate() != 0){
                    JOptionPane.showMessageDialog(null,"Your account has been created");
                    //got to make login form
                    LoginForm form = new LoginForm();
                    form.setVisible(true);
                    form.pack();
                    form.setLocationRelativeTo(null);
                    //close registration form
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Check your information");
                }
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception e) {
        }
        
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        //got to make login form
        LoginForm form = new LoginForm();
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        // close registration form
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void PhoneNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PhoneNumKeyTyped
        
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
        
        String phone = String.valueOf(PhoneNum.getText());
        // limit length of phone number type to 12
        boolean max = phone.length() >= 12;
        
        if (max) {
            evt.consume();
        }  
        
    }//GEN-LAST:event_PhoneNumKeyTyped

    private void PasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyTyped
        
        String password = String.valueOf(Password.getPassword());
        // limit length of password type to 50
        boolean max = password.length() >= 50;
        
        if (max) {
            evt.consume();
        }
        
    }//GEN-LAST:event_PasswordKeyTyped

    private void ConfirmPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConfirmPasswordKeyTyped
       
        String cpassword = String.valueOf(ConfirmPassword.getPassword());
        // limit length of password type to 50
        boolean max = cpassword.length() >= 50;
        
        if (max) {
            evt.consume();
        }
        
    }//GEN-LAST:event_ConfirmPasswordKeyTyped

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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JPasswordField ConfirmPassword;
    private javax.swing.JLabel ConfirmPasswordLabel;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField JobLevel;
    private javax.swing.JLabel JobLevelLabel;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JTextField PhoneNum;
    private javax.swing.JLabel PhoneNumLabel;
    private javax.swing.JLabel RegistrationFormLabel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
