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
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class CommentPage extends javax.swing.JFrame {
    private static int projectID;
    private static int issueID;
    /**
     * Creates new form CommentPage
     */
    public CommentPage() {
        initComponents();
        this.setLocationRelativeTo(null);//to let the form adjust to the center of our computer screen
    }
    /**
     * Creates new form CommentPage
     * @param projectID and issueID
     */
    public CommentPage(int projectID, int issueID) {
        this.projectID = projectID;
        this.issueID = issueID;
        initComponents();
        this.setLocationRelativeTo(null);//to let the form adjust to the center of our computer screen
        insertTableContents(projectID,issueID); // show the contents of selected table 'comment' from database based on projectID and issueID 
    }
    /**
     * method to store data from database into ArrayList before inserting it into table GUI
     * CommentTable class is defined in the same package
     * @return ArrayList of type CommentTable
     * @param projectID and issueID
     */
    public ArrayList<CommentTable> createList(int projID, int issID){
        
            ArrayList<CommentTable> list = new ArrayList<>();
        try {
            Cnx connectionClass = new Cnx(); //establish connection
            Connection connection = connectionClass.getConnection(); //establish connection
            
            int commentID;
            int issueID;
            int projectID;
            String text;
            Timestamp datetime;
            String username;
            
            String query1 = "SELECT* FROM comment WHERE projectID = " +projID + " and issueID = " + issID; //query to select all from selected row in table named 'comment'
            Statement st = connection.createStatement(); //create a statement using connection that already establish
            ResultSet result1 = st.executeQuery(query1); // execute query1 and store the result into result1
            
            while(result1.next()){
                commentID = result1.getInt("commentID"); //get the data inside column 'commentID'(one of the column for table 'comment') and store it into variable commentID
                issueID = result1.getInt("issueID");
                projectID = result1.getInt("projectID");
                text = result1.getString("text");
                datetime = result1.getTimestamp("date");
                username = result1.getString("userName");
                
                list.add(new CommentTable(commentID,issueID,projectID,text,datetime,username)); // instantiate CommentTable object and insert it into ArrayList
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentPage.class.getName()).log(Level.SEVERE, null, ex); // will just print the errors to our console
        }
        return list; //return the ArrayList
    }
    /**
     * method to insert data stored inside ArrayList to the table GUI
     * @param projectID and issueID
     */
    public void insertTableContents(int projectID, int issueID){
        ArrayList<CommentTable> list = createList(projectID,issueID); // object referring to the ArrayList created inside createList();
        DefaultTableModel tableModel = (DefaultTableModel)commentTable.getModel(); // get the model of table GUI
        Object[] row = new Object[4];
        for(int i = 0; i<list.size(); i++){  
            row[0] = list.get(i).getCommentID(); //assign the commentID data located at a specific index in arrayList to row[0]
            row[1] = list.get(i).getText();
            row[2] = list.get(i).getDatetime();
            row[3] = list.get(i).getUsername();
            tableModel.addRow(row); //inserting data into specific row of table GUI
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
        commentTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        commentTitle.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        commentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        commentTitle.setText("Comments");
        commentTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        commentTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        commentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Text", "Created on", "Created by"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        commentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(commentTable);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(commentTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(179, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backButton)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(commentTitle)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap(114, Short.MAX_VALUE))
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
    
    
   /**
     * method to go to React Page
     * @param evt (when the event occur, button is clicked) 
     */
    private void commentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentTableMouseClicked
        int row = commentTable.getSelectedRow();
        TableModel tableModel = commentTable.getModel();
        int commentID = (int)tableModel.getValueAt(row,0);
        //ReactPage reactPage = new ReactPage(commentID);
        this.dispose();//dispose the current ProjectDashboard GUI
        //reactPage.setVisible(true);
    }//GEN-LAST:event_commentTableMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try{
            PreparedStatement st;
            String query = "SELECT * FROM issue WHERE issueID = ? AND projectID = ?" ;
            Cnx connectionClass = new Cnx(); //create connection
            st = connectionClass.getConnection().prepareStatement(query);
            st.setInt(1, issueID);
            st.setInt(2, projectID);
            IssuePage form = new IssuePage(st, projectID);
            form.setVisible(true);
            form.pack();
            form.setLocationRelativeTo(null);
            // close Issue Dashboard Form
            this.dispose();
        }catch (SQLException ex) {
        }
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CommentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommentPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommentPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTable commentTable;
    private javax.swing.JLabel commentTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
