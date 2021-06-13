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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReactionForm extends javax.swing.JFrame {
    
    private int cID;
    private int iID;
    private int pID;

    /**
     * Creates new form ReactionForm
     */
    public ReactionForm() {
        this.cID=0;
        this.iID=0;
        this.pID=0;
        initComponents();
        this.setLocation(800, 250);
    }
    
    public ReactionForm(int commentID, int issueID, int projectID){
        this.cID = commentID;
        this.iID = issueID;
        this.pID = projectID;
        initComponents();
//        getComment();
        this.setLocation(920, 260);
        initial();
        reactionNum();
    }
    
    //Get the comment from database to be displayed
    public void getComment(){
        try{
            PreparedStatement st;
            String query = "SELECT text FROM comment WHERE commentID=? AND issueID = ? AND projectID = ?" ;
            Cnx connectionClass = new Cnx(); //create connection
            st = connectionClass.getConnection().prepareStatement(query);
            st.setInt(1, cID);
            st.setInt(2, iID);
            st.setInt(3, pID);
            ResultSet rs=st.executeQuery();
            rs.next();
            String comment= rs.getString("text");
//            Comment.setText(comment);
        }catch (SQLException ex) {
        }
    }
    
    //Get the total number of each reaction recorded from database
    public void reactionNum(){
        
        Statement st;
        Statement st2;
        Statement st3;
        Statement st4;
        ResultSet rs, rs2, rs3, rs4;
        
        
        String hp= "happy";
        String sd= "sad";
        String ag= "angry";
        String tu = "thumbsUp";
        int hnum=0;
        int snum=0;
        int anum=0;
        int tnum=0;
        
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
            
            //Display number of thumbsUp reaction
            String query4 = " SELECT counts FROM react WHERE reaction = '" + tu + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
            st4 = connection.createStatement();
            rs4 = st4.executeQuery(query4);
            rs4.next();
            tnum=rs4.getInt("counts");
            ThumbsUpNum.setText(Integer.toString(tnum));
            
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
        Statement st4;
        PreparedStatement st_;
        PreparedStatement st_2;
        PreparedStatement st_3;
        PreparedStatement st_4;
        ResultSet rs, rs2, rs3,rs4;
        
        String hp= "happy";
        String sd= "sad";
        String ag= "angry";
        String tu = "thumbsUp";
        
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
            else if(selection==4){
                 //Get the latest number of thumbsUp reaction in database
                String query4= " SELECT counts FROM react WHERE reaction = '" + tu + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st4 = connection.createStatement();
                rs4 = st4.executeQuery(query4);
                rs4.next();
                int tnum=rs4.getInt("counts");
                //Update the value by one
                tnum=tnum+1;
                //Update the value in database
                String sql4 = "UPDATE react SET counts = " + tnum +" WHERE reaction = '" + tu + "' AND commentID = " + cID +" AND issueID = " + iID + " AND projectID = " + pID;
                st_4 = connection.prepareStatement(sql4);
                st_4.executeUpdate();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ReactionForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception e) {
        }
          
    }
    
    public void initial(){
        
        PreparedStatement st, st2, st3, st4;
        ResultSet rs, rs2, rs3, rs4;
        
        String hp= "happy";
        String sd= "Sad";
        String ag= "angry";
        String tu = "thumbsUp";
        
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
            
            //Check if there is already existing row of sad reaction for the speacific commentID, issueID and projectID
            String check2 = "SELECT * FROM react WHERE reaction = ? AND commentID = ? AND issueID = ? AND projectID = ?";
            st2 = connection.prepareStatement(check2);
            st2.setString(1, sd);
            st2.setInt(2, cID);
            st2.setInt(3, iID);
            st2.setInt(4, pID);
            rs2 = st2.executeQuery();
            if(!rs2.next()){
                //initialize to 0 if there is none
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
            
            //Check if there is already existing row of angry reaction for the speacific commentID, issueID and projectID
            String check3 = "SELECT * FROM react WHERE reaction = ? AND commentID = ? AND issueID = ? AND projectID = ?";
            st3 = connection.prepareStatement(check3);
            st3.setString(1, ag);
            st3.setInt(2, cID);
            st3.setInt(3, iID);
            st3.setInt(4, pID);
            rs3 = st3.executeQuery();
            if(!rs3.next()){
                //initialize to 0 if there is none
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
            
            //Check if there is already existing row of thumbsUp reaction for the speacific commentID, issueID and projectID
            String check4 = "SELECT * FROM react WHERE reaction = ? AND commentID = ? AND issueID = ? AND projectID = ?";
            st4 = connection.prepareStatement(check3);
            st4.setString(1, tu);
            st4.setInt(2, cID);
            st4.setInt(3, iID);
            st4.setInt(4, pID);
            rs4 = st4.executeQuery();
            if(!rs4.next()){
                //initialize to 0 if there is none
                String sql = "INSERT INTO react VALUES(?,?,?,?,?)";
                PreparedStatement st_4;
                st_4 = connection.prepareStatement(sql);
                st_4.setString(1,tu);
                st_4.setInt(2, 0);
                st_4.setInt(3, cID);
                st_4.setInt(4, iID);
                st_4.setInt(5, pID);
                st_4.executeUpdate();
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
        HappyLabel = new javax.swing.JLabel();
        SadLabel = new javax.swing.JLabel();
        AngryLabel = new javax.swing.JLabel();
        HappyNum = new javax.swing.JLabel();
        SadNum = new javax.swing.JLabel();
        AngryNum = new javax.swing.JLabel();
        Happy = new javax.swing.JButton();
        Sad = new javax.swing.JButton();
        Angry = new javax.swing.JButton();
        ThumbsUpLabel = new javax.swing.JLabel();
        ThumbsUpNum = new javax.swing.JLabel();
        ThumbsUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        HappyLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        HappyLabel.setText("Happy :");

        SadLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        SadLabel.setText("Sad     :");

        AngryLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AngryLabel.setText("Angry :");

        HappyNum.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        HappyNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HappyNum.setText("0");

        SadNum.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        SadNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SadNum.setText("0");

        AngryNum.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        AngryNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AngryNum.setText("0");

        Happy.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        Happy.setText("HAPPY");
        Happy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HappyActionPerformed(evt);
            }
        });

        Sad.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        Sad.setText("SAD");
        Sad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SadActionPerformed(evt);
            }
        });

        Angry.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        Angry.setText("ANGRY");
        Angry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AngryActionPerformed(evt);
            }
        });

        ThumbsUpLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ThumbsUpLabel.setText("Thumbs up:");

        ThumbsUpNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ThumbsUpNum.setText("0");

        ThumbsUp.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        ThumbsUp.setText("THUMBS UP");
        ThumbsUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThumbsUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Happy, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Sad, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Angry, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(HappyLabel)
                            .addComponent(SadLabel)
                            .addComponent(AngryLabel)
                            .addComponent(ThumbsUpLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SadNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AngryNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HappyNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ThumbsUpNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(ThumbsUp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HappyLabel)
                    .addComponent(HappyNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SadLabel)
                    .addComponent(SadNum, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AngryLabel)
                    .addComponent(AngryNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThumbsUpLabel)
                    .addComponent(ThumbsUpNum))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Happy)
                    .addComponent(Sad)
                    .addComponent(Angry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ThumbsUp)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AngryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngryActionPerformed
        reaction(3);
        reactionNum();
    }//GEN-LAST:event_AngryActionPerformed

    private void SadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SadActionPerformed
        reaction(2);
        reactionNum();
    }//GEN-LAST:event_SadActionPerformed

    private void HappyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HappyActionPerformed
        reaction(1);
        reactionNum();
    }//GEN-LAST:event_HappyActionPerformed

    private void ThumbsUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThumbsUpActionPerformed
        reaction(4);
        reactionNum();
    }//GEN-LAST:event_ThumbsUpActionPerformed

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
    private javax.swing.JButton Happy;
    private javax.swing.JLabel HappyLabel;
    private javax.swing.JLabel HappyNum;
    private javax.swing.JButton Sad;
    private javax.swing.JLabel SadLabel;
    private javax.swing.JLabel SadNum;
    private javax.swing.JButton ThumbsUp;
    private javax.swing.JLabel ThumbsUpLabel;
    private javax.swing.JLabel ThumbsUpNum;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
