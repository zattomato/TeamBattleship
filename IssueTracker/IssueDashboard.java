/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;


import ConnectionToDatabase.Cnx;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
/**
 *
 * @author User
 */
public class IssueDashboard extends javax.swing.JFrame {
    private static int projectID;
    private String userName;
    private ArrayList<IssueTable> issueList;
    private ArrayList<IssueTable> copyIssueList;
    private ArrayList<String> issueTag;// to store all defined tags inside issueTable
    private JFrame referenceToSearchForm; // to refer to the JFrame of SearchForm.java
    /**
     * Creates new form IssueDashboard
     * @param projectID
     */
    public IssueDashboard() {
        initComponents();
        this.setLocationRelativeTo(null); //to let the form adjust to the center of our computer screen
        //insertTableContents(); // show the contents of table 'issue' from database
    }
    
    public IssueDashboard(int projectID,String userName, JFrame referenceToSearchForm){ // overloaded constructor to accept reference to SearchForm.java 
        this(projectID, userName); // calling the constructor with one arguments
        this.referenceToSearchForm = referenceToSearchForm;
        searchBackButton.setEnabled(true);
        
    }
    public IssueDashboard(int projectID, String userName) {
        this.projectID = projectID;
        this.userName = userName;
        initComponents();
        filterStatus.addItem("Status");
        filterStatus.addItem("Open");
        filterStatus.addItem("Resolved");
        filterStatus.addItem("Closed");
        filterStatus.addItem("In Progress");
        filterStatus.addItem("Reopened");
        this.setLocationRelativeTo(null); //to let the form adjust to the center of our computer screen
        issueList = createList(projectID);
        copyIssueList = new ArrayList<>();
        copyIssueList = (ArrayList<IssueTable>) issueList.clone();
        filterTag.addItem("Tag");
        if(!issueTag.isEmpty()){
            for(int i =0; i<issueTag.size(); i++){
                filterTag.addItem(issueTag.get(i));
            }
        }
        insertTableContents(issueList);// show the contents of table 'issue' from database
    }
    /**
     * method to store data from database into ArrayList before inserting it into table GUI
     * IssueTable class is defined in the same package
     * @return ArrayList of type IssueTable
     */
    public ArrayList<IssueTable> createList(int projID){
        issueList = new ArrayList<>();
        issueTag = new ArrayList<>();
        try{
            Cnx connectionClass = new Cnx();//establish connection
            Connection connection = connectionClass.getConnection();//establish connection
            
            int issueID;
            int projectID;
            String issueName;
            String issueStatus;
            String issueTag;
            int issuePriority;
            Timestamp issueTime;
            String issueAssignee;
            String issueCreatedBy;
            String issueDescription;
            
            String query1 = "SELECT* FROM issue WHERE projectID =" + projID;//query to select all from selected row in table named 'issue'
            Statement st = connection.createStatement(); //create a statement using connection that already establish
            ResultSet result1 = st.executeQuery(query1); // execute query1 and store the result into result1
            
            
            while(result1.next()){
                issueID = result1.getInt("issueID"); //get the data inside column 'projectID'(one of the column for table 'project') and store it into variable projectID
                issueName = result1.getString("issueName");
                projectID = result1.getInt("projectID");
                issueStatus = result1.getString("issueStatus");
                issueTag = result1.getString("issueTag");
                if(!this.issueTag.contains(issueTag)){
                    this.issueTag.add(issueTag);
                }
                issueTime = result1.getTimestamp("date");
                issueAssignee = result1.getString("assignee");
                issueCreatedBy = result1.getString("creator");
                issueDescription = result1.getString("description");
                issuePriority = result1.getInt("priority");
                issueList.add(new IssueTable(issueID,issueName,projectID,issueStatus,issueTag,issueTime,issueAssignee,issueCreatedBy,issueDescription,issuePriority)); // instantiate ProjectTable object and insert it into ArrayList
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(IssueDashboard.class.getName()).log(Level.SEVERE, null, ex); // will just print the errors to our console
        }return issueList; //return the ArrayList
    }
    /**
     * method to insert data stored inside ArrayList to the table GUI
     * @return nothing
     */
    public void insertTableContents(ArrayList<IssueTable> list){
        DefaultTableModel tableModel = (DefaultTableModel)IssueDashboardTable.getModel(); // get the model of table GUI
        tableModel.setRowCount(0);
        Object[] row = new Object[10];
        for(int i = 0; i<list.size(); i++){  
            row[0] = list.get(i).getIssueID(); //assign the projectID data located at a specific index in arrayList to row[0]
            row[1] = list.get(i).getIssueName();
            row[2] = list.get(i).getIssueStatus();
            row[3] = list.get(i).getIssueTag();
            row[4] = list.get(i).getIssueTime();
            row[5] = list.get(i).getIssueAssignee();
            row[6] = list.get(i).getIssueCreatedBy();
            row[7] = list.get(i).getIssuePriority();
            
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
        IssueDashboardLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IssueDashboardTable = new javax.swing.JTable();
        CreateNewIssue = new javax.swing.JButton();
        issueSearchBar = new javax.swing.JTextField();
        BackButton = new javax.swing.JButton();
        searchBackButton = new javax.swing.JButton();
        changeLogButton = new javax.swing.JButton();
        filterTag = new javax.swing.JComboBox<>();
        filterStatus = new javax.swing.JComboBox<>();
        sortDateButton = new javax.swing.JButton();
        sortPriorityButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IssueDashboardLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        IssueDashboardLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IssueDashboardLabel.setText("Issue Dashboard");

        IssueDashboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue ID", "Title", "Status", "Tag", "Time", "Assignee", "Created by", "Priority"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IssueDashboardTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IssueDashboardTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(IssueDashboardTable);

        CreateNewIssue.setText("Create Issue");
        CreateNewIssue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateNewIssueMouseClicked(evt);
            }
        });
        CreateNewIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewIssueActionPerformed(evt);
            }
        });

        issueSearchBar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        issueSearchBar.setForeground(new java.awt.Color(153, 153, 153));
        issueSearchBar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        issueSearchBar.setText("Search");
        issueSearchBar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                issueSearchBarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                issueSearchBarFocusLost(evt);
            }
        });
        issueSearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                issueSearchBarKeyPressed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        searchBackButton.setText("Back To Search");
        searchBackButton.setEnabled(false);
        searchBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBackButtonActionPerformed(evt);
            }
        });

        changeLogButton.setText("Change Log");
        changeLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLogButtonActionPerformed(evt);
            }
        });

        filterTag.setModel(new javax.swing.DefaultComboBoxModel<>());
        filterTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterTagActionPerformed(evt);
            }
        });

        filterStatus.setModel(new javax.swing.DefaultComboBoxModel<>());
        filterStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterStatusActionPerformed(evt);
            }
        });

        sortDateButton.setText("Time");
        sortDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortDateButtonActionPerformed(evt);
            }
        });

        sortPriorityButton.setText("Priority");
        sortPriorityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortPriorityButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Sort By:");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Filter By:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(issueSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(sortPriorityButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(sortDateButton)
                                    .addGap(14, 14, 14)
                                    .addComponent(filterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(filterTag, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBackButton)
                                .addGap(265, 265, 265)
                                .addComponent(changeLogButton)
                                .addGap(18, 18, 18)
                                .addComponent(CreateNewIssue))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(IssueDashboardLabel)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(IssueDashboardLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issueSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortDateButton)
                    .addComponent(sortPriorityButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateNewIssue)
                    .addComponent(BackButton)
                    .addComponent(searchBackButton)
                    .addComponent(changeLogButton))
                .addContainerGap(49, Short.MAX_VALUE))
        );

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

    private void IssueDashboardTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IssueDashboardTableMouseClicked
        int row = IssueDashboardTable.getSelectedRow();
        TableModel tableModel = IssueDashboardTable.getModel();
        int issueID = (int)tableModel.getValueAt(row,0);
        try{
            PreparedStatement st;
            String query = "SELECT * FROM issue WHERE issueID = ? AND projectID = ?" ;
            Cnx connectionClass = new Cnx(); //create connection
            st = connectionClass.getConnection().prepareStatement(query);
            st.setInt(1, issueID);
            st.setInt(2, projectID);
            IssuePage form = new IssuePage(st, projectID, userName);
            form.setVisible(true);
            form.pack();
            form.setLocationRelativeTo(null);
            // close Issue Dashboard Form
            this.dispose();
        }catch (SQLException ex) {
        }
        //IssuePage.setVisible(true);
    }//GEN-LAST:event_IssueDashboardTableMouseClicked

    private void CreateNewIssueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateNewIssueMouseClicked

    }//GEN-LAST:event_CreateNewIssueMouseClicked

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        ProjectDashboard projectDashboard = new ProjectDashboard(userName);
        projectDashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void CreateNewIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewIssueActionPerformed
        //got to make Issue Creation Form
        IssueCreationForm form = new IssueCreationForm(projectID,userName);
        form.setVisible(true);
        form.pack();
        form.setLocationRelativeTo(null);
        // close Issue Dashboard Form
        this.dispose();
    }//GEN-LAST:event_CreateNewIssueActionPerformed

    private void searchBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBackButtonActionPerformed
        referenceToSearchForm.setVisible(true); // set SearchForm.java to visible
        this.dispose(); // dispose this current form
    }//GEN-LAST:event_searchBackButtonActionPerformed

    private void issueSearchBarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_issueSearchBarFocusGained
        if(issueSearchBar.getText().trim().toLowerCase().equals("search")){
            issueSearchBar.setText("");
            issueSearchBar.setForeground(Color.black);
        }
    }//GEN-LAST:event_issueSearchBarFocusGained

    private void issueSearchBarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_issueSearchBarFocusLost
        if(issueSearchBar.getText().trim().toLowerCase().equals("search")||
                issueSearchBar.getText().trim().equals("")){
            issueSearchBar.setText("search");
            issueSearchBar.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_issueSearchBarFocusLost

    private void issueSearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_issueSearchBarKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){ // if enter key is pressed at the search bar
            SearchForm searchForm = new SearchForm(issueSearchBar.getText(),userName); // go to the search form
            searchForm.setVisible(true);
            this.dispose(); // dispose this current form
        }
    }//GEN-LAST:event_issueSearchBarKeyPressed

    private void changeLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLogButtonActionPerformed
        ChangeLogForm changeLogForm = new ChangeLogForm(projectID);
        changeLogForm.setVisible(true);
    }//GEN-LAST:event_changeLogButtonActionPerformed
            
    private void sortPriorityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortPriorityButtonActionPerformed
        for(int i = 1; i<copyIssueList.size(); i++){
            for(int j = 0; j< copyIssueList.size()-1; j++){
                if(copyIssueList.get(j).getIssuePriority()<copyIssueList.get(j+1).getIssuePriority()){
                    copyIssueList.add(j, copyIssueList.remove(j+1));
                }
            }
        }
        insertTableContents(copyIssueList);
    }//GEN-LAST:event_sortPriorityButtonActionPerformed

    private void sortDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortDateButtonActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       for(int i = 1; i<copyIssueList.size(); i++){
            for(int j = 0; j< copyIssueList.size()-1; j++){
                try {
                    Date index1 = sdf.parse(copyIssueList.get(j).getIssueTime().toString());
                    Date index2 = sdf.parse(copyIssueList.get(j+1).getIssueTime().toString());
                    if(index1.compareTo(index2)>0){
                        copyIssueList.add(j, copyIssueList.remove(j+1));
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(IssueDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        insertTableContents(copyIssueList);
    }//GEN-LAST:event_sortDateButtonActionPerformed

    private void filterStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterStatusActionPerformed
        String status = filterStatus.getSelectedItem().toString();
        String tag = "";
        try{
             tag = filterTag.getSelectedItem().toString();// nullpointerException might occur at the beginning because tag is null and cannot parse to string
            
        }catch(NullPointerException ex){
            
        }
        if(!status.equals("Status")){ //Status is default placeholder
            copyIssueList.clear();
            for(int i = 0; i<issueList.size(); i++){
                if(!tag.equals("Tag")){ // Tag is default palceholder
                    if(issueList.get(i).getIssueStatus().equals(status)&& issueList.get(i).getIssueTag().equals(tag)){
                        copyIssueList.add(issueList.get(i));
                    }
                }
                else{
                    if(issueList.get(i).getIssueStatus().equals(status)){
                        copyIssueList.add(issueList.get(i));
                        
                    }
                    
                }
            }
            insertTableContents(copyIssueList);
        }
    }//GEN-LAST:event_filterStatusActionPerformed

    private void filterTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterTagActionPerformed
        String tag = filterTag.getSelectedItem().toString();
        String status = "";
        try{
             status = filterStatus.getSelectedItem().toString();// nullpointerException might occur at the beginning because status is null and cannot parse to string
            
        }catch(NullPointerException ex){
            
        }
        if(!tag.equals("Tag")){ // Tag is default placeholder
            copyIssueList.clear();
            for(int i = 0; i<issueList.size(); i++){
                if(!status.equals("Status")){ // Status is default placeholder
                    if(issueList.get(i).getIssueStatus().equals(status)&& issueList.get(i).getIssueTag().equals(tag)){
                        copyIssueList.add(issueList.get(i));
                    }
                }
                else{
                    
                    if(issueList.get(i).getIssueTag().equals(tag)){
                        copyIssueList.add(issueList.get(i));
                    }
                    
                }
            }
            insertTableContents(copyIssueList);
        }
    }//GEN-LAST:event_filterTagActionPerformed

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
            java.util.logging.Logger.getLogger(IssueDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueDashboard().setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CreateNewIssue;
    private javax.swing.JLabel IssueDashboardLabel;
    private javax.swing.JTable IssueDashboardTable;
    private javax.swing.JButton changeLogButton;
    private javax.swing.JComboBox<String> filterStatus;
    private javax.swing.JComboBox<String> filterTag;
    private javax.swing.JTextField issueSearchBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchBackButton;
    private javax.swing.JButton sortDateButton;
    private javax.swing.JButton sortPriorityButton;
    // End of variables declaration//GEN-END:variables
}