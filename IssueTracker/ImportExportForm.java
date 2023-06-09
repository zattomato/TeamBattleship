
package IssueTracker;

import ConnectionToDatabase.Cnx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ImportExportForm extends javax.swing.JFrame {
    private String userName;
    /**
     * Creates new form ImportExportForm
     */
    public ImportExportForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public ImportExportForm(String userName){
        this.userName = userName;
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
        importExportLabel = new javax.swing.JLabel();
        importButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        importExportLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        importExportLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        importExportLabel.setText("Import/Export JSON to Database");

        importButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        exportButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        exportButton.setText("Export");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        homeButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("click here to Import");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("click here to Export");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(143, 143, 143)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(importExportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(importExportLabel)
                .addGap(28, 28, 28)
                .addComponent(homeButton)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importButton)
                    .addComponent(exportButton))
                .addContainerGap(251, Short.MAX_VALUE))
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

    
    private String formatJSONContents(Scanner contents)throws SQLException{
        String formattedContents ="";
        String temp; // string to store each line inside contents before insert it into formattedContents
        String tempModified; // modified version of temp
        
        Cnx connectionClass = new Cnx(); 
        Connection connection = connectionClass.getConnection(); //establish connection
        while(contents.hasNextLine()){
            temp = contents.nextLine(); // store one line from contents
            if(temp.trim().matches("\"timestamp\"[\\s]*:[\\s]*[0-9]+[\\s]*,")){ // test whether temp contains information about timestamp and if the timestamp is in unix timestamp format (initial JSON file given have timestamp in unix format)
                tempModified = temp.trim().replaceAll("[^0-9]", ""); // assign tempModified with the modified version of temp, which only contains numbers (unix timestamp)
                Statement st = connection.createStatement(); // create statement with the connection that have been establish
                
                //this query is to convert unix timestamp into 'datetime' data type which is used inside tables inside database
                String query1 = "DECLARE @TestVariable AS datetime\n" +
                "SET @TestVariable = dateadd(S, "+tempModified+", '1970-01-01')\n" +
                "SELECT @TestVariable";
                ResultSet result1 = st.executeQuery(query1); 
                result1.next();
                tempModified = result1.getString(""); // get result and assign it to tempModified
                formattedContents += temp.replaceAll("[0-9]+", "\""+tempModified+"\""); // replace the unix timestamp inside temp with the information inside tempModified(enclosed the information inside tempModified with double quotation mark first) and assign it to formattedContents 
            }
            else{
                formattedContents += temp; // if temp does not contains information about timestamp which is unix timestamp, the program will just add it to formattedContents
            }

            formattedContents += "\n"; // put a new line before retrieving the next line inside contents

        }

        formattedContents = formattedContents.replaceAll("'", "''"); // we need to replace all single quotation mark with two single quotation mark. this is because single quotation is the character we use to escape sequence inside sql, like the function of backslash inside java 
        return formattedContents; // returns formattedContents to the caller
    }
    
    private boolean isJSON(String formattedContents) throws SQLException{
        Cnx connectionClass = new Cnx();
        Connection connection = connectionClass.getConnection();
        Statement st = connection.createStatement();
        ResultSet result;
       
        
        String isJSON = "DECLARE @json NVARCHAR(MAX);\n" +
                        "SET @json = N'"+formattedContents+"'\n" +
                        "select ISJSON(@json)";
        
        result = st.executeQuery(isJSON);
        result.next();
        if(result.getInt("")==1)
            return true;
        else
            return false;
        
    }
    
    private void insertFormattedJSONContents(String formattedContents) throws SQLException{
        
        Cnx connectionClass = new Cnx();
        Connection connection = connectionClass.getConnection();
        Statement st1 = connection.createStatement();
        int i=0; //for projects
        int j=0; //for issues
        int k=0; //for comments
        int l=0;//for react
        int success; // whether insertion to database is success or not
        
        //this query is to initialize variables inside sql, with the value of the variable as formattedContents
        String initializeSQLVariable = "DECLARE @json NVARCHAR(MAX);\n" +
                        "SET @json = N'"+formattedContents+"'\n";
        
        String insertProject = "insert into project\n" +
                        "select * from OPENJSON (@json, '$.projects')\n" +
                        "with(\n" +
                        "	projectID int '$.id',\n" +
                        "	projectName nvarchar(50) '$.name',\n" +
                        "	projectDetails nvarchar(50) '$.projectDetails'\n" +
                        ")";

        String insertUser = "insert into [users]\n" +
                        "select * from OPENJSON (@json, '$.users')\n" +
                        "with(\n" +
                        "	userID int '$.userid',\n" +
                        "	name nvarchar(50) '$.username',\n" +
                        "	email nvarchar(50) '$.email',\n" +
                        "	password nvarchar(50) '$.password',\n" +
                        "	jobLevel nvarchar(20) '$.jobLevel',\n" +
                        "	phoneNum nvarchar(13) '$.phoneNum'\n" +
                        "	\n" +
                        "\n" +
                        ")";

        st1.executeUpdate(initializeSQLVariable+insertProject); // insert all information about projects into 'projects' table
        st1 = connection.createStatement(); // reuse the variable and recreate statement using the established connection
        st1.executeUpdate(initializeSQLVariable+insertUser); // insert all information about users into 'users' table
        st1 = connection.createStatement(); // reuse the variable and recreate statement using the established connection
        
        
        //insert information about issue into 'issue' table one by one based on index i and j
        while(true){
            while(true){
                try{

                    String insertIssue = "insert into issue\n" +
                        "	select * from OPENJSON (@json, '$.projects["+i+"]')\n" +
                        "		with(\n" +
                        "			issueID int '$.issues["+j+"].id',\n" +
                        "			issueName nvarchar(50) '$.issues["+j+"].title',\n" +
                        "			projectID int '$.id',\n" +
                        "			issueStatus nvarchar(50) '$.issues["+j+"].status',\n" +
                        "			issueTag nvarchar(50) '$.issues["+j+"].tag[0]',\n" +
                        "			date datetime '$.issues["+j+"].timestamp',\n" +
                        "			assignee nvarchar(20) '$.issues["+j+"].assignee',\n" +
                        "			creator nvarchar(20) '$.issues["+j+"].createdBy',\n" +
                        "			description nvarchar(max) '$.issues["+j+"].descriptionText',\n" +
                        "			priority int '$.issues["+j+"].priority'\n" +
                        "	\n" +
                        "		)";
                    success = st1.executeUpdate(initializeSQLVariable+insertIssue); //insert information into 'issue'
                    if(success>0){ // if success update index j
                        j++;
                    }

                    else // if not success, then all issue for the particular project have already been inserted
                        break;
                }
                catch(SQLException ex){ //error can occur if sql try to insert issue which is not present, when this case happened, all issue for the particular project have already been inserted, so we need to break to update index i to insert issue for another project
                    break;
                }



            }
            if(j==0) //  if j==0 it means the project no longer have any issue to be inserted, so we can break the second while loop
                break;
            i++;
            j=0;
        }



        st1 = connection.createStatement();
        i = 0;
        j = 0;
        
        //insert information about issue into 'comment' table one by one based on index i, j and k
        while(true){
            while(true){
                while(true){
                    try{
                        String insertComment = 
                        "declare @tmp table (commentID int not null,issueID int,projectID int, text nvarchar(MAX), date datetime, userName nvarchar(20))\n" +
                        "declare @tmpcommentID int\n" +
                        "declare @tmpissueID int\n" +
                        "declare @tmpprojectID int\n" +
                        "declare @tmptext nvarchar(max)\n" +
                        "declare @tmpdate datetime\n" +
                        "declare @tmpuserName nvarchar(20)"+
                        "insert into @tmp\n" +
                        "select * from OPENJSON (@json, '$.projects["+i+"]')\n" +
                        "			with(\n" +
                        "			commentID int '$.issues["+j+"].comments["+k+"].comment_id',\n" +
                        "			issueID int '$.issues["+j+"].id',\n" +
                        "			projectID int '$.id',\n" +
                        "			text nvarchar(max) '$.issues["+j+"].comments["+k+"].text',\n" +
                        "			date datetime '$.issues["+j+"].comments["+k+"].timestamp',\n" +
                        "			userName nvarchar(20) '$.issues["+j+"].comments["+k+"].user'\n" +
                        "			)\n"+
                        "SET @tmpcommentID = (select commentID from @tmp )\n" +
                        "SET @tmpissueID = (select issueID from @tmp)\n" +
                        "SET @tmpprojectID = (select projectID from @tmp)\n" +
                        "SET @tmptext = (select text from @tmp)\n" +
                        "SET @tmpdate = (select date from @tmp)\n" +
                        "SET @tmpuserName = (select userName from @tmp)\n" +
                        "delete from @tmp\n" +
                        "insert into comment values (@tmpcommentID,@tmpissueID,@tmpprojectID, @tmptext, @tmpdate, @tmpuserName, null)";
                        success = st1.executeUpdate(initializeSQLVariable+insertComment); //insert information into 'comment'
                        if(success>0) // if success update index k
                            k++;
                        else // if not success, then all comment for the particular issue and project have already been inserted
                            break;
                    }
                    catch(SQLException ex){ //error can occur if sql try to insert comment which is not present, when this case happened, all comment for the particular issue or project have already been inserted, so we need to break to update index j to insert comment for another issue
                        break;
                    }
                }
                if(k==0) //  when the break for the inner 'while' occurred, it means that the comment for index k is not present, so if k==0 it means the issue no longer have any comment to be inserted, so we can break the second while loop
                    break;
                j++;
                k = 0;
            }
            if(j==0) // if j==0 it means the project no longer have any comment to be inserted, so we can break the first while loop
                break;
            i++;
            j=0;
            k=0;
        }


        st1 = connection.createStatement();
        i = 0;
        j = 0;
        k = 0;
        
        //insert information about react into 'react' table one by one based on index i,j,k and l
        while(true){
            while(true){
                while(true){
                    while(true){
                        try{

                            String insertReact = "insert into react\n" +
                            "select * from OPENJSON (@json, '$.projects["+i+"]')\n" +
                            "			with(\n" +
                            "			reaction nvarchar(20) '$.issues["+j+"].comments["+k+"].react["+l+"].reaction',\n" +
                            "			counts int '$.issues["+j+"].comments["+k+"].react["+l+"].count',\n" +
                            "			commentID int '$.issues["+j+"].comments["+k+"].comment_id',\n" +
                            "                   issueID int '$.issues["+j+"].id',\n" +
                            "			projectID int '$.id'\n" +
                            "			)";
                            success = st1.executeUpdate(initializeSQLVariable+insertReact); //insert information into 'react'
                            if(success>0) // if success update index l
                                l++;
                            else // if not success, then all react for the particular issue or project or comment have already been inserted
                                break;
                        }
                        catch(SQLException ex){  //error can occur if sql try to insert react which is not present, when this case happened, all react for the particular issue or project or comment have already been inserted, so we need to break to update index k to insert react for another comment
                            break;
                        }
                    }
                    if(l==0) // when the break for the inner 'while' occurred, it means that the react for index l is not present, so if l==0 it means the comment no longer have any react to be inserted, so we can break the third while loop
                        break;
                    k++;
                    l = 0;
                }
                if(k==0) //  if k==0 it means the issue no longer have any react to be inserted, so we can break the second while loop
                    break;
                j++;
                k=0;
                l=0;
            }
            if(j==0) // if j==0 it means the project no longer have any react to be inserted, so we can break the first while loop 
                break;
            i++;
            j=0;
            k=0;
            l=0;
        }
    }
    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        File file;
        Scanner contents;
        int response;
        String formattedContents;
        JFileChooser chooser = new JFileChooser("."); // create a file chooser dialog, '.' to open dialog start from this project directory
        
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
        response = chooser.showOpenDialog(null); 
        
        if(response == JFileChooser.APPROVE_OPTION){ // check if user have clicked the file
            file = chooser.getSelectedFile();  // get the selected file
            try{
                contents = new Scanner(file); // retrieve contents from file
                if(file.isFile()){ // check whether the selected item is a file or not
                    String fileType = file.getAbsolutePath();
                    if(fileType.contains(".json")){ // check if file is JSON type file
                        try {
                            JOptionPane.showMessageDialog(null, "The processing is ongoing....please wait for a while");
                            formattedContents = formatJSONContents(contents);
                            if(isJSON(formattedContents)){ // determine whether the formattedContents follow the JSON style format or not
                                insertFormattedJSONContents(formattedContents);
                                JOptionPane.showMessageDialog(null, "SUCCESS!\nyou have imported your JSON file!");
                            }
                            else
                                JOptionPane.showMessageDialog(null, "ALERT!\nyour JSON file is not formatted properly!");
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(ImportExportForm.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null, "ALERT!\nSome error occurs. Please try again.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ALERT!\nThis file is not JSON type file, please try again");
                    }
                }        
            }catch(FileNotFoundException e){
                
            }
        }
        
    }//GEN-LAST:event_importButtonActionPerformed

    
    private void exportDatabaseContents()throws SQLException, FileNotFoundException{
        Cnx connectionClass = new Cnx();
        Connection connection = connectionClass.getConnection();
        Statement st = connection.createStatement();
        ResultSet result;
        
        
        String exportProjectDetails = "select \n" +
                                    "[p].[projectID] as 'id',\n" +
                                    "[p].[projectName] as 'name',\n" +
                                    "[p].[projectDetails] as 'details',\n" +
                                    "[issues].[issueID] as 'id',\n" +
                                    "[issues].[issueName] as 'title',\n" +
                                    "[issues].[priority] as 'priority',\n" +
                                    "[issues].[issueStatus] as 'status',\n" +
                                    "[issues].[issueTag] as 'tag',\n" +
                                    "[issues].[description] as 'descriptionText',\n" +
                                    "[issues].[creator] as 'createdBy',\n" +
                                    "[issues].[assignee] as 'assignee',\n" +
                                    "[issues].[date] as 'timestamp',\n" +
                                    "[comments].[commentID] as 'comment_id',\n" +
                                    "[comments].[text] as 'text',\n" +
                                    "[react].[reaction] as 'reaction',\n" +
                                    "[react].[counts] as 'count',\n" +
                                    "[comments].[date] as 'timeStamp',\n" +
                                    "[comments].[userName] as 'user'\n" +
                                    "\n" +
                                    "from project as [p]\n" +
                                    "INNER JOIN issue as [issues]\n" +
                                    "	on [issues].[projectID] = [p].projectID\n" +
                                    "INNER JOIN comment as [comments]\n" +
                                    "	on [comments].[issueID] = [issues].[issueID] and [comments].[projectID] = [p].projectID\n" +
                                    "INNER JOIN react\n" +
                                    "	on [react].commentID = [comments].[commentID] and [react].[issueID] = [issues].[issueID] and [react].[projectID] = [p].projectID\n" +
                                    "order by [p].[projectID], [issues].[issueID], [comments].[commentID]\n"+
                                    "for JSON AUTO";
        
        
        String exportUsersDetails = "select \n" +
                            "[users].[userID] as 'userID',\n" +
                            "[users].[name] as'name',\n" +
                            "[users].[email] as 'email',\n" +
                            "[users].[password] as 'password',\n" +
                            "[users].[jobLevel] as 'jobLevel',\n" +
                            "[users].[phoneNum] as 'phoneNum'\n" +
                            "from users\n" +
                            "\n" +
                            "for JSON AUTO";
        
        String projectDetails = "";  //string to store data from table 'project', 'issue', 'comment', 'react' 
        String usersDetails = "";    //string to store data from table 'users'
        
        //we separate projectDetails and usersDetails because we want to format the JSON file similar to the initial JSON file given by assignment question
        
        String JSONText;  // string to store joined projectDetails and UsersDetails
        
        
        result = st.executeQuery(exportProjectDetails); //perform query to convert data inside all tables except for table 'users' to JSON format
        while(result.next())
        {
            projectDetails += result.getString("JSON_F52E2B61-18A1-11d1-B105-00805F49916B");  //store into projectDetails data that have been converted to JSON format
        }
        
        StringBuilder copyProjectDetails = new StringBuilder(projectDetails); // make a copy of projectDetails to format the root of the JSON file (because database did not return the root)
        copyProjectDetails.insert(0, "{\"projects\":"); // insert the root at the start of copyProjectDetails
        copyProjectDetails.insert(copyProjectDetails.length(),","); // insert comma to the last of copyProjectDetails because latter we want to join this string with usersDetails
        projectDetails = copyProjectDetails.toString(); // assign the modified version of projectDetails(copyProjectDetails) to the original projectDetails
        
        
        st = connection.createStatement();
        result = st.executeQuery(exportUsersDetails); // perform query to convert data inside table 'users' to JSON format
        while(result.next())
        {
            usersDetails += result.getString("JSON_F52E2B61-18A1-11d1-B105-00805F49916B"); //store into usersDetails data that have been converted to JSON format
        }
        
        StringBuilder copyUsersDetails = new StringBuilder(usersDetails); // make a copy of usersDetails to format the root of the JSON file (because database did not return the root)
        copyUsersDetails.insert(0,"\"users\":"); // insert the root at the start of copyUsersDetails
        copyUsersDetails.insert(copyUsersDetails.length(),"}"); // insert close curly braces to the last of copyUsersDetails because latter we want to join this string with projectDetails
        usersDetails = copyUsersDetails.toString(); // assign the modified version of usersDetails(copyUsersDetails) to the original usersDetails
        
        JSONText = projectDetails + usersDetails; // combine the two string to make a complete JSON text to be printed out to .json file
        JSONText = JSONText.replaceAll("\\\\/", "/"); // extra thing to put because java somehow escape the forward slash at the hyperlinks inside JSONText for example https://streamable.com/hkyg3 becomes https:\/\/streamable.com\/hkyg3

        PrintWriter out = new PrintWriter(new FileOutputStream( new File("exportedData.json"))); // create a new file inside project folder with .json extension
        out.println(JSONText); // output the JSONText to .json file
        out.close(); // close the PrintWriter
        
    }
    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        try {
            exportDatabaseContents();
            JOptionPane.showMessageDialog(null, "The processing is ongoing....please wait for a while");
            JOptionPane.showMessageDialog(null, "SUCCESS!\nyou have exported JSON file!");
            
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ALERT!\nSome errors occurs. Please try again.");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportExportForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ALERT!\nSome errors occurs. Please try again.");
        }
    }//GEN-LAST:event_exportButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ImportExportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportExportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportExportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportExportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportExportForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton importButton;
    private javax.swing.JLabel importExportLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
