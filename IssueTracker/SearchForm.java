
package IssueTracker;

import ConnectionToDatabase.Cnx;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchForm extends javax.swing.JFrame {
    private ArrayList<ProjectTable> projectList; // arrayList to store data fetched from 'project' table inside database
    private ArrayList<IssueTable> issueList; //     " " from 'issue' table inside database
    private ArrayList<CommentTable> commentList; // " " from 'comment' table inside database
    private String userName;
    
    /**
     * Creates new form SearchForm
     */
    public SearchForm(String toSearch, String userName) {
        initComponents();
        this.userName = userName;
        this.setLocationRelativeTo(null);
        projectList = new ArrayList(); // instantiate the arrayList
        issueList = new ArrayList();
        commentList = new ArrayList();
        insertTableContents(toSearch); // call function to insert the data from database that match the string toSearch
        
    }
    
    public SearchForm(){
        initComponents();
        this.setLocationRelativeTo(null);
        projectList = new ArrayList();
        issueList = new ArrayList();
        commentList = new ArrayList();
    }
    
    private void createLists(){
        
        try {
            Statement st = new Cnx().getConnection().createStatement(); // establish connection and create statement
            ResultSet result;

            String queryProject = "select* from project"; // string to query all results from table 'project'
            result = st.executeQuery(queryProject); // execute query
            while(result.next()){
                projectList.add(new ProjectTable(result.getInt("projectID"),result.getString("projectName"),result.getString("projectDetails"),0)); 
                //create a new object of ProjectTable using the results obtained from the query and add the new object into instance variable projectList 
            }
            
            int i; // to use inside 'for' loop that adding IssueTable object into issueList
            int j; // to use inside 'for' loop that adding CommentTable object into commentList
            
            for(i = 0 ; i<projectList.size(); i++){
                String queryIssue = "select* from issue where projectID = " + projectList.get(i).getProjectID();
                result = st.executeQuery(queryIssue);
                while(result.next()){
                    issueList.add(new IssueTable(result.getInt("issueID"),result.getString("issueName"),result.getInt("projectID"),result.getString("issueStatus"),null,null,null,null,result.getString("description"),0));
                    //create a new object of IssueTable using only the required results obtained from the query and add new object into instance variable issueList
                }

            }// end of for loop

            
            for(j = 0; j<issueList.size(); j++){
                String queryComment = "select* from comment where projectID = " + issueList.get(j).getProjectID() + " and issueID = " + issueList.get(j).getIssueID();
                result = st.executeQuery(queryComment);
                while(result.next()){
                    commentList.add(new CommentTable(result.getInt("commentID"),result.getInt("issueID"),result.getInt("projectID"),result.getString("text"),null,null));
                    //create a new object of CommentTable using only the required results obtained from the query and add new object into instance variable commentList
                }
            }//end of for loop
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }// end of createLists() method
    
    private void insertTableContents(String toSearch){
        createLists(); // call function to create add the data from database to the ArrayList instance variables
        
        
        toSearch = toSearch.toLowerCase(); // make the string toSearch into lowerCase letters
        
        int i =0; // to use inside all for loop inside this method
        
        ArrayList<Integer> indexProject = new ArrayList<>(); // ArrayList to store the index of projectList which match the toSearch string
        
        for(i = 0; i<projectList.size(); i++){
            
            if(projectList.get(i).getProjectName().toLowerCase().contains(toSearch)){ // check if projectName match toSearch string
                indexProject.add(i);
            }
            else if(projectList.get(i).getDescription()!=null){ // check whether the description at particular index in projectList is null or not
                if( projectList.get(i).getDescription().toLowerCase().contains(toSearch)){ // check if description match toSearch string
                    indexProject.add(i);
                }
            }
                 
        }//end of for loop
        
        ArrayList<Integer> indexIssue = new ArrayList<>();// ArrayList to store the index of issueList which match the toSearch string
        
       
        for(i = 0; i<issueList.size(); i++){
                if(issueList.get(i).getIssueName().toLowerCase().contains(toSearch)){ // check if issueName match toSearch string
                    indexIssue.add(i);
                }
                else if(issueList.get(i).getIssueStatus().toLowerCase().contains(toSearch)){ // check if status match toSearch string
                    indexIssue.add(i);
                }
                
                else if(issueList.get(i).getIssueDescription()!=null){
                    if(issueList.get(i).getIssueDescription().toLowerCase().contains(toSearch)){ // check if description match toSearch String
                        indexIssue.add(i);
                    }
                     
                }
        }//end of for loop
        
        ArrayList<Integer> indexComment = new ArrayList<>();// ArrayList to store the index of commentList which match the toSearch string
        
        for(i = 0; i<commentList.size(); i++){
            if(commentList.get(i).getText().toLowerCase().contains(toSearch)){ // check if text match toSearch String
                indexComment.add(i);
            }
        }//end of for loop
        

        
        DefaultTableModel tableModelProject = (DefaultTableModel)projectTable.getModel(); // get the model of projectTable
        tableModelProject.setRowCount(0); // delete all rows if present
        Object[] row = new Object[3]; // create object to represent the row of table
        
        for(i = 0; i<indexProject.size(); i++){
            row[0] = projectList.get(indexProject.get(i)).getProjectID(); // add projectID to row[0]
            row[1] = projectList.get(indexProject.get(i)).getProjectName(); // add projectName to row[1]
            row[2] = projectList.get(indexProject.get(i)).getDescription(); // add description to row[2]
            tableModelProject.addRow(row); // add row to the table
        }//end of for loop
        
        
        DefaultTableModel tableModelIssue = (DefaultTableModel)issueTable.getModel(); 
        tableModelIssue.setRowCount(0); 
        row = new Object[5]; 
        for(i = 0; i<indexIssue.size(); i++){
            row[0] = issueList.get(indexIssue.get(i)).getProjectID(); 
            row[1] = issueList.get(indexIssue.get(i)).getIssueID(); 
            row[2] = issueList.get(indexIssue.get(i)).getIssueName(); 
            row[3] = issueList.get(indexIssue.get(i)).getIssueStatus(); 
            row[4] = issueList.get(indexIssue.get(i)).getIssueDescription(); 
            tableModelIssue.addRow(row); 
        }
        
        DefaultTableModel tableModelComment = (DefaultTableModel)commentTable.getModel();
        tableModelComment.setRowCount(0);
        row = new Object[4];
        for(i = 0; i<indexComment.size(); i++){
            row[0] = commentList.get(indexComment.get(i)).getProjectID();
            row[1] = commentList.get(indexComment.get(i)).getIssueID();
            row[2] = commentList.get(indexComment.get(i)).getCommentID();
            row[3] = commentList.get(indexComment.get(i)).getText();
            tableModelComment.addRow(row);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        issueTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        commentTable = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        homeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search");

        projectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project ID", "Project Name", "Description"
            }
        ));
        projectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(projectTable);

        issueTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project ID", "Issue ID", "Issue Name", "Status", "Description"
            }
        ));
        issueTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issueTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(issueTable);

        commentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project ID", "Issue ID", "Comment ID", "Text"
            }
        ));
        commentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                commentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(commentTable);

        searchTextField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(153, 153, 153));
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchTextField.setText("search");
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusLost(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
        });

        homeButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(202, 202, 202))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homeButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
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

    private void projectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectTableMouseClicked
        
        int row = projectTable.getSelectedRow(); //get the row which the user clicked on
        TableModel tableModel = projectTable.getModel(); // get the table model
        int projectID = (int)tableModel.getValueAt(row, 0); // get the data inside column projectID, to be passed to Issue Dashbord form
        IssueDashboard issueDashboard = new IssueDashboard(projectID,userName,this); // call IssueDashboard constructor and pass the arguments
        issueDashboard.setVisible(true); // set IssueDashboard to visible
        this.setVisible(false); // set this form to invisible

    }//GEN-LAST:event_projectTableMouseClicked

    private void issueTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issueTableMouseClicked
        int row = issueTable.getSelectedRow();
        TableModel tableModel = issueTable.getModel();
        int projectID = (int)tableModel.getValueAt(row,0);
        int issueID = (int)tableModel.getValueAt(row,1);
        try {
            String query = "SELECT * FROM issue WHERE issueID = ? AND projectID = ?" ; 
            PreparedStatement st = new Cnx().getConnection().prepareStatement(query); // preparedStatement to be passed to issuePage (because issuePage require it)
            st.setInt(1, issueID);
            st.setInt(2, projectID);
            IssuePage issuePage = new IssuePage(st, projectID,userName, this); // call IssuePage constructor and pass the arguments
            issuePage.setVisible(true); // set IssuePage to visible
            issuePage.pack();
            issuePage.setLocationRelativeTo(null); // set Issuepage to the center of the screen
            this.setVisible(false); // set this form to invisible

        } catch (SQLException ex) {
            Logger.getLogger(SearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_issueTableMouseClicked

    private void commentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentTableMouseClicked
        int row = commentTable.getSelectedRow();
        TableModel tableModel = commentTable.getModel();
        int projectID = (int)tableModel.getValueAt(row, 0);
        int issueID = (int)tableModel.getValueAt(row, 1);
        int commentID = (int)tableModel.getValueAt(row, 2);
        SingleCommentForm singleCommentForm; // declare SingleCommentForm
        try {
            singleCommentForm = new SingleCommentForm(projectID,issueID,commentID,userName, this); // call SinglecommentForm(form to display one comment only) and pass the arguments
            singleCommentForm.setVisible(true); // set SingleCommentForm to visible
            this.setVisible(false); //set this form to invisible
        } catch (SQLException ex) {
            Logger.getLogger(SearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_commentTableMouseClicked

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ // when enter key is pressed at the searchTextfield
            projectList.clear(); // clear all instance variables
            issueList.clear();
            commentList.clear();
            insertTableContents(searchTextField.getText()); // call function to insert the data from database that match the string from searchTextfield 
        }
    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        if(searchTextField.getText().trim().toLowerCase().equals("search")){
            searchTextField.setText("");
            searchTextField.setForeground(Color.black);
        }
    }//GEN-LAST:event_searchTextFieldFocusGained

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
        if(searchTextField.getText().trim().toLowerCase().equals("search")||
                searchTextField.getText().trim().equals("")){
            searchTextField.setText("search");
            searchTextField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_searchTextFieldFocusLost

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        ProjectDashboard projectDashboard = new ProjectDashboard(userName);
        projectDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable commentTable;
    private javax.swing.JButton homeButton;
    private javax.swing.JTable issueTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable projectTable;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
