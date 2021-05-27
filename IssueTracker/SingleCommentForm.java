
package IssueTracker;

import ConnectionToDatabase.Cnx;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class SingleCommentForm extends javax.swing.JFrame {
    private JFrame referenceToSearchForm; // to refer to the JFrame of SearchForm.java
    /**
     * Creates new form SingleCommentForm
     */
    public SingleCommentForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public SingleCommentForm(int projectID, int issueID, int commentID, JFrame referenceToSearchForm) throws SQLException{
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.referenceToSearchForm = referenceToSearchForm;
        Statement st = new Cnx().getConnection().createStatement(); // create statement from the connection established
        String queryComment = "select* from comment where commentID = " + commentID + " and issueID = " + issueID + " and projectID = " + projectID;
        ResultSet result = st.executeQuery(queryComment); // execute the query to get a particular comment inside 'comment' table
        result.next(); // make result point to the first element
        userNameLabel.setText(result.getString("userName")); // set label with the name of the commenter
        dateLabel.setText(result.getTimestamp("date").toString()); // set text area with the comments
        commentTextArea.setText(result.getString("text")); // set label with the timestamp of the comment
       
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
        commentLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        backToSearchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commentLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        commentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        commentLabel.setText("Comment");

        userNameLabel.setBackground(new java.awt.Color(153, 153, 255));
        userNameLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        userNameLabel.setText("userName");

        dateLabel.setText("Date");

        commentTextArea.setColumns(20);
        commentTextArea.setRows(5);
        commentTextArea.setLineWrap(true);
        commentTextArea.setEditable(false);
        jScrollPane1.setViewportView(commentTextArea);

        jScrollPane2.setViewportView(jScrollPane1);

        backToSearchButton.setText("Back To Search");
        backToSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToSearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(commentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backToSearchButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(userNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(228, 228, 228)))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentLabel)
                .addGap(61, 61, 61)
                .addComponent(userNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(backToSearchButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(dateLabel)))
                .addContainerGap(118, Short.MAX_VALUE))
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

    private void backToSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToSearchButtonActionPerformed
        this.referenceToSearchForm.setVisible(true); // set SearchForm.java to visible
        this.dispose(); // dispose this current form
    }//GEN-LAST:event_backToSearchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SingleCommentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SingleCommentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SingleCommentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SingleCommentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SingleCommentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backToSearchButton;
    private javax.swing.JLabel commentLabel;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}