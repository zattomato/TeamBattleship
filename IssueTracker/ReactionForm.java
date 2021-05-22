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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ReactionForm extends javax.swing.JFrame {

    /**
     * Creates new form ReactionForm
     */
    public ReactionForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        initial();
        reactionNum();
    }
    
    public void reactionNum(){
        
        Statement st;
        Statement st2;
        Statement st3;
        ResultSet rs, rs2, rs3;
        
        //Later get these info by make constructor accept 3 parameter
        int cID=0;
        int iID=0;
        int pID=0;
        
        String hp= "happy";
        String sd= "sad";
        String ag= "angry";
        int hnum=0;
        int snum=0;
        int anum=0;
        
        Cnx connectionclass = new Cnx();
        Connection connection = connectionclass.getConnection();
        
        try {
            
            //Display number of happy reaction
            String query = " SELECT counts FROM react WHERE reaction = '"+ hp +"' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
            st = connection.createStatement();
            rs = st.executeQuery(query);
            rs.next();
            hnum=rs.getInt("counts");
            HappyNum.setText(Integer.toString(hnum));  
            
            //Display number of sad reaction
            String query2 = " SELECT counts FROM react WHERE reaction = '" + sd + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
            st2 = connection.createStatement();
            rs2 = st2.executeQuery(query2);
            rs2.next();
            snum=rs2.getInt("counts");
            SadNum.setText(Integer.toString(snum)); 
            
            //Display number of angry reaction
            String query3 = " SELECT counts FROM react WHERE reaction = '" + ag + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
            st3 = connection.createStatement();
            rs3 = st3.executeQuery(query3);
            rs3.next();
            anum=rs3.getInt("counts");
            AngryNum.setText(Integer.toString(anum)); 
            
        }catch (SQLException ex) {
            Logger.getLogger(ReactionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e) {
        }
        
    }
    
    public void reaction(int selection){
        
        Statement st;
        Statement st2;
        Statement st3;
        PreparedStatement st_;
        PreparedStatement st_2;
        PreparedStatement st_3;
        ResultSet rs, rs2, rs3;
        
        int cID=0;
        int iID=0;
        int pID=0;
        String hp= "happy";
        String sd= "sad";
        String ag= "angry";
        
        Cnx connectionclass = new Cnx();
        Connection connection = connectionclass.getConnection();
        
        try {
            if(selection==1){
                //Get the latest number of happy reaction in database
                String query= " SELECT counts FROM react WHERE reaction = '" + hp + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st = connection.createStatement();
                rs = st.executeQuery(query);
                rs.next();
                int hnum=rs.getInt("counts");
                //Increase the value by one
                hnum=hnum+1;
                //Update the value in database
                String sql = "UPDATE react SET counts = " + hnum +" WHERE reaction = '" + hp + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st_ = connection.prepareStatement(sql);
                st_.executeUpdate();
            }
            else if(selection==2){
                //Get the latest number of sad reaction in database
                String query2= " SELECT counts FROM react WHERE reaction = '" + sd + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st2 = connection.createStatement();
                rs2 = st2.executeQuery(query2);
                rs2.next();
                int snum=rs2.getInt("counts");
                //Increase the value by one
                snum=snum+1;
                //Update the value in database
                String sql2 = "UPDATE react SET counts = " + snum +" WHERE reaction = '" + sd + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st_2 = connection.prepareStatement(sql2);
                st_2.executeUpdate();
            }
            else if(selection==3){
                //Get the latest number of angry reaction in database
                String query3= " SELECT counts FROM react WHERE reaction = '" + ag + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st3 = connection.createStatement();
                rs3 = st3.executeQuery(query3);
                rs3.next();
                int anum=rs3.getInt("counts");
                //Update the value by one
                anum=anum+1;
                //Update the value in database
                String sql3 = "UPDATE react SET counts = " + anum +" WHERE reaction = '" + ag + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st_3 = connection.prepareStatement(sql3);
                st_3.executeUpdate();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ReactionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e) {
        }
          
    }
    
    public void initial(){
        
        PreparedStatement st, st2, st3;
        ResultSet rs, rs2, rs3;
        
        int cID=0;
        int iID=0;
        int pID=0;
        String hp= "happy";
        String sd= "Sad";
        String ag= "angry";
        
        Cnx connectionclass = new Cnx();
        Connection connection = connectionclass.getConnection();
        
        //Initialize the number of reaction to 0
        try {
            //Check if there is already existing row of happy reaction for the speacific commentID, issueID and projectID
            String check = "SELECT * FROM react WHERE reaction = ? AND commentID = ? AND issueID = ? AND projectID = ?";
            st = connection.prepareStatement(check);
            st.setString(1,hp);
            st.setInt(2, cID);
            st.setInt(3, iID);
            st.setInt(4, pID);
            rs = st.executeQuery();
            if(!rs.next()){
                //initialize to 0 if there is none
                String sql = "INSERT INTO react VALUES(?,?,?,?,?)";
                PreparedStatement st_;
                st_ = connection.prepareStatement(sql);
                st_.setString(1,hp);
                st_.setInt(2, 0);
                st_.setInt(3, cID);
                st_.setInt(4, iID);
                st_.setInt(5, pID);
                st_.executeUpdate();
            }
            
            String check2 = "SELECT * FROM react WHERE reaction = ? AND commentID = ? AND issueID = ? AND projectID = ?";
            st2 = connection.prepareStatement(check2);
            st2.setString(1, sd);
            st2.setInt(2, cID);
            st2.setInt(3, iID);
            st2.setInt(4, pID);
            rs2 = st2.executeQuery();
            if(!rs2.next()){
                String sql = "INSERT INTO react VALUES(?,?,?,?,?)";
                PreparedStatement st_2;
                st_2 = connection.prepareStatement(sql);
                st_2.setString(1,sd);
                st_2.setInt(2, 0);
                st_2.setInt(3, cID);
                st_2.setInt(4, iID);
                st_2.setInt(5, pID);
                st_2.executeUpdate();
            }
            
            String check3 = "SELECT * FROM react WHERE reaction = ? AND commentID = ? AND issueID = ? AND projectID = ?";
            st3 = connection.prepareStatement(check3);
            st3.setString(1, ag);
            st3.setInt(2, cID);
            st3.setInt(3, iID);
            st3.setInt(4, pID);
            rs3 = st3.executeQuery();
            if(!rs3.next()){
                String sql = "INSERT INTO react VALUES(?,?,?,?,?)";
                PreparedStatement st_3;
                st_3 = connection.prepareStatement(sql);
                st_3.setString(1,ag);
                st_3.setInt(2, 0);
                st_3.setInt(3, cID);
                st_3.setInt(4, iID);
                st_3.setInt(5, pID);
                st_3.executeUpdate();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ReactionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        Comment = new javax.swing.JLabel();
        HappyLabel = new javax.swing.JLabel();
        SadLabel = new javax.swing.JLabel();
        AngryLabel = new javax.swing.JLabel();
        HappyNum = new javax.swing.JLabel();
        SadNum = new javax.swing.JLabel();
        AngryNum = new javax.swing.JLabel();
        Happy = new javax.swing.JButton();
        Sad = new javax.swing.JButton();
        Angry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Comment.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        Comment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Comment.setText("Comment");

        HappyLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        HappyLabel.setText("Happy :");

        SadLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        SadLabel.setText("Sad     :");

        AngryLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AngryLabel.setText("Angry :");

        HappyNum.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        HappyNum.setText("0");

        SadNum.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        SadNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SadNum.setText("0");

        AngryNum.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AngryNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AngryNum.setText("0");

        Happy.setText("HAPPY");
        Happy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HappyActionPerformed(evt);
            }
        });

        Sad.setText("SAD");
        Sad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SadActionPerformed(evt);
            }
        });

        Angry.setText("ANGRY");
        Angry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AngryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(Comment))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(HappyLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(HappyNum))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SadLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SadNum, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AngryLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AngryNum, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(Happy, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sad, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Angry, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(Comment)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HappyLabel)
                    .addComponent(HappyNum))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SadLabel)
                    .addComponent(SadNum, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AngryLabel)
                    .addComponent(AngryNum))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Happy)
                    .addComponent(Sad)
                    .addComponent(Angry))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HappyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HappyActionPerformed
        reaction(1);
        reactionNum();
    }//GEN-LAST:event_HappyActionPerformed

    private void SadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SadActionPerformed
        reaction(2);
        reactionNum();
    }//GEN-LAST:event_SadActionPerformed

    private void AngryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngryActionPerformed
        reaction(3);
        reactionNum();
    }//GEN-LAST:event_AngryActionPerformed

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
            java.util.logging.Logger.getLogger(ReactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReactionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Angry;
    private javax.swing.JLabel AngryLabel;
    private javax.swing.JLabel AngryNum;
    private javax.swing.JLabel Comment;
    private javax.swing.JButton Happy;
    private javax.swing.JLabel HappyLabel;
    private javax.swing.JLabel HappyNum;
    private javax.swing.JButton Sad;
    private javax.swing.JLabel SadLabel;
    private javax.swing.JLabel SadNum;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}