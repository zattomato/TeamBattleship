/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;

import ConnectionToDatabase.Cnx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author kaysh
 */
public class IssuePage extends javax.swing.JFrame {
    private PreparedStatement statement;
    private static int projectIDs;
    private static int issueIDs;
    private static String projectNames;
    private static String[][] userInfo;
    /**
     * Creates new form IssuePage
     */
    public IssuePage(){
        initComponents();
        this.setTitle("Issue Page");
        this.setLocationRelativeTo(null);
    }
    
    public IssuePage(PreparedStatement st, int projectID) throws SQLException{
        this.projectIDs = projectID;
        statement = st;
        ResultSet rs = st.executeQuery();
        try{
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        userInfo = new String[columnsNumber][2];
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                String columnValue = rs.getString(i);
                userInfo[i-1][1] = columnValue;
                userInfo[i-1][0] = rsmd.getColumnName(i);
            }
        }
        System.out.println("");
        issueIDs = Integer.valueOf(userInfo[0][1]);
        
        }catch (SQLException ex) {
        }
        String query1 = "SELECT* FROM project WHERE projectID =" + projectID;//query to select all from selected row in table named 'issue'
        
        Cnx connectionClass = new Cnx(); //create connection
        Connection connection = connectionClass.getConnection(); //create connection
        try{
        Statement st1 = connection.createStatement(); //create a statement using connection that already establish
        ResultSet result1 = st1.executeQuery(query1); // execute query1 and store the result into result1
        while(result1.next()){
            projectNames = result1.getString("projectName");
        }
        System.out.println(projectNames);
        }catch (SQLException ex){
            
        }
        initComponents();
        this.setTitle("Issue Page");
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
        issueID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        tag = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        creator = new javax.swing.JLabel();
        assignee = new javax.swing.JLabel();
        priority = new javax.swing.JLabel();
        dateCreated = new javax.swing.JLabel();
        projectName = new javax.swing.JLabel();
        statusBox = new javax.swing.JComboBox<>();
        commentButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        issueID.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        issueID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        issueID.setText("Issue ID");

        jLabel2.setText("Issue Name:");

        jLabel4.setText("Issue Tag:");

        name.setText("Issue Name");

        tag.setText("Issue Tag");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tag))
                .addGap(18, 18, 18))
        );

        name.setText(userInfo[1][1]);
        tag.setText(userInfo[4][1]);

        jLabel3.setText("Created by:");

        jLabel8.setText("Created on:");

        jLabel7.setText("Priority:");

        jLabel5.setText("Status:");

        jLabel6.setText("Assignee:");

        jLabel9.setText("Project Name:");

        creator.setText("Created by");

        assignee.setText("Assignee");

        priority.setText("Priority");

        dateCreated.setText("Created on");

        projectName.setText("Project Name");

        statusBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(assignee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priority, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creator, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateCreated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(projectName, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(creator)
                    .addComponent(dateCreated))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(assignee)
                    .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(priority)
                    .addComponent(projectName))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        creator.setText(userInfo[7][1]);
        assignee.setText(userInfo[6][1]);
        priority.setText(userInfo[9][1]);
        dateCreated.setText(userInfo[5][1]);
        projectName.setText(projectNames);

        commentButton.setText("See Comments");
        commentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentButtonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        description.setColumns(20);
        description.setLineWrap(true);
        description.setRows(5);
        description.setText("Description\n");
        description.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(description);
        jScrollPane2.setBounds(40, 300, 200, 200);
        description.setText(userInfo[8][1]);
        description.setEditable(false);
        description.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(issueID, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(commentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addGap(18, 18, 18)
                        .addComponent(backButton))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(issueID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentButton)
                    .addComponent(backButton)
                    .addComponent(updateButton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        issueID.setText("Issue ID: " +userInfo[0][1]);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentButtonActionPerformed
        //go to make Comment Page
        CommentPage commentPage = new CommentPage(Integer.valueOf(projectIDs), Integer.valueOf(issueIDs));
        commentPage.setVisible(true); 
        commentPage.setLocationRelativeTo(null);
        // close Issue Creation Form
        this.dispose();
    }//GEN-LAST:event_commentButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //go to make Issue Dashboard Form
        IssueDashboard issueDashboard = new IssueDashboard(Integer.valueOf(projectIDs));
        issueDashboard.setVisible(true); 
        issueDashboard.setLocationRelativeTo(null);
        // close Issue Creation Form
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
//        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", "Alert!",JOptionPane.YES_NO_OPTION); // prompt dialog panel
//            if(option==0){ // if yes
//                try{
//                    String name = this.name.getText();
//                    String creator = this.creator.getText();
//                    String assignee = this.assignee.getText();
//                    String status = statusBox.getSelectedItem().toString();
//                    String tag= this.tag.getText();
//                    String priority = this.priority.getText();
//                    String description = this.description.getText(); 
//                    //make sure there is 1 or 2 digit priority
//                    Matcher matcher1 = Pattern.compile("^[0-1][0]$").matcher(priority);
//                    Matcher matcher2 = Pattern.compile("^[0-9]$").matcher(priority);
//                    if(!matcher1.find() && !matcher2.find()){
//                        JOptionPane.showMessageDialog(null, "ALERT!\nInvalid Priority");
//                        this.priority.setText(null);
//                        throw new Exception("");
//                    }
//
//                    //check if any field is empty
//                    if(name.equals("")||assignee.equals("")||status.equals("")||tag.equals("")||priority.equals("")||description.equals("")){
//                        JOptionPane.showMessageDialog(null, "ALERT!Please enter all requirement field");
//                        throw new Exception("");
//                    }
//
//                    try{
//
//                        Cnx connectionClass = new Cnx(); // create connection 
//                        Connection connection = connectionClass.getConnection(); //create connection
//
//                        Date dt = new java.util.Date();
//
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
//
//                        String currentTime = sdf.format(dt);    // get current date and time
//
//                        Statement st1 = connection.createStatement(); // create statement from the established connection
//                        Statement st2 = connection.createStatement();
//
//                        String query1 = "SELECT MAX(issueID) FROM issue ";   // selecting the highest id currently inside database
//                        ResultSet result1 = st1.executeQuery(query1); // execute query1 and store it inside result1
//                        result1.next();
//                        int issueID = result1.getInt("") + 1; // adding 1 to the highest id inside database and assign it to current issueID to be created
//                        String sql = "INSERT INTO issue VALUES ("+issueID+",'"+name+"',"+projectIDs+",'"+status+"','"+tag+"','"+currentTime+"','"+assignee+"','"+creator+"','"+description+"',"+priority+")";
//                        if(st2.executeUpdate(sql) != 0){
//                            JOptionPane.showMessageDialog(null,"Your issue has been created");
//                            IssueDashboard issueDashboard = new IssueDashboard(Integer.valueOf(projectIDs));
//                            issueDashboard.setVisible(true); 
//                            issueDashboard.setLocationRelativeTo(null);
//                            // close Issue Creation Form
//                            this.dispose();
//                        }
//                        else{
//                            JOptionPane.showMessageDialog(null,"Check your information");
//                        }
//
//                    }//end second try
//                    catch (SQLException ex) {
//                        Logger.getLogger(ProjectDashboard.class.getName()).log(Level.SEVERE, null, ex); // print to the console if sql exceptions occurs
//                    } 
//                }//end first try
//                catch(Exception e){
//
//                }
//            }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void statusBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusBoxActionPerformed

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
            java.util.logging.Logger.getLogger(IssuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssuePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel assignee;
    private javax.swing.JButton backButton;
    private javax.swing.JButton commentButton;
    private javax.swing.JLabel creator;
    private javax.swing.JLabel dateCreated;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel issueID;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel priority;
    private javax.swing.JLabel projectName;
    private javax.swing.JComboBox<String> statusBox;
    private javax.swing.JLabel tag;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}