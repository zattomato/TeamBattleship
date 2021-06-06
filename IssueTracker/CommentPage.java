/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import ConnectionToDatabase.Cnx;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author User
 */
public class CommentPage extends javax.swing.JFrame implements MouseListener {
    private static int projectIDs;
    private static int issueIDs;
    private static int commentIDs;
    private static String text;
    private static Timestamp datetime;
    private static String username;
    private byte[] picture = null;
    private JTextArea addComment;
    private JTextArea commentCreator;
    private JTextArea[] jTextArea;
    private JButton undoButton;
    private JButton redoButton;
    private JButton submitButton;
    private JButton uploadPictureButton;
    private JButton[] jButton;
    private JButton[] jPictureButton;
    private JScrollPane scrollAddComment;
    private JScrollPane[] jScrollPane;
    private JLabel addYourName;
    private JLabel[] jLabelID;
    private JLabel[] jLabelcommentID;
    private JLabel[] jLabelCreatedby;
    private JLabel[] jLabelCreator ;
    private JLabel[] jLabelCreatedon ;
    private JLabel[] jLabelDate;
    private int index = 0;
    private ArrayList<Integer> indexOfJPictureButton = new ArrayList<>();
    
    /**
     * Creates new form 
     */
    public CommentPage() {
        initComponents();
        this.setTitle("Comment Page");
        this.setLocationRelativeTo(null);
    }
    public CommentPage(int projectID, int issueID){
        try{
        picture = null;
        Cnx connectionClass = new Cnx(); //establish connection
        Connection connection = connectionClass.getConnection(); //establish connection
        Statement initialStatement = connection.createStatement();
        String countComments = "select count(*) from comment where projectID = " +projectID + "and issueID = " +issueID;
        ResultSet countCommentsResult = initialStatement.executeQuery(countComments);
        countCommentsResult.next();
        int count = countCommentsResult.getInt("");
        init(count);
        this.setTitle("Comment Page");
        this.setLocationRelativeTo(null);
        this.projectIDs = projectID;
        this.issueIDs = issueID;
            
            String query = "SELECT* FROM comment WHERE projectID = " +projectID + " and issueID = " + issueID +" order by commentID";
            Statement st = connection.createStatement(); //create a statement using connection that already establish
            ResultSet result = st.executeQuery(query); // execute query and store the result into result
            
            String query1 = "SELECT* FROM comment WHERE projectID = " +projectID + " and issueID = " + issueID+" order by commentID";
            Statement st1 = connection.createStatement(); //create a statement using connection that already establish
            ResultSet result1 = st1.executeQuery(query); // execute query1 and store the result into result1
            
            while(result1.next()){
                index++; //get total number of comments in comment table in database 
            }
            
            jLabelID = new JLabel[index];
            jLabelcommentID = new JLabel[index];
            jLabelCreatedby = new JLabel[index];
            jLabelCreator = new JLabel[index];
            jLabelCreatedon = new JLabel[index];
            jLabelDate = new JLabel[index];
                    
            jTextArea = new JTextArea[index];
            jButton = new JButton[index];
            jPictureButton = new JButton[index];
            jScrollPane = new JScrollPane[index];
            

            int gap = 0;
            int i = 0;
            
            while(result.next()){
                commentIDs = result.getInt("commentID"); //get the data inside column 'commentID'(one of the column for table 'comment') and store it into variable commentID
                issueIDs = result.getInt("issueID");
                projectIDs = result.getInt("projectID");
                text = result.getString("text");
                datetime = result.getTimestamp("date");
                username = result.getString("userName");
                picture = result.getBytes("images");

                jLabelID[i] = new JLabel("ID : ");//create label named "ID" 
                jLabelID[i].setBounds(50, 200+gap, 100, 23);
                jPanel1.add(jLabelID[i]);

                jLabelcommentID[i] = new JLabel(String.valueOf(commentIDs));
                jLabelcommentID[i].setBounds(100, 200+gap, 100, 23);
                jPanel1.add(jLabelcommentID[i]);

                jLabelCreatedby[i] = new JLabel("Created by : ");
                jLabelCreatedby[i].setBounds(50, 230+gap, 100, 23);
                jPanel1.add(jLabelCreatedby[i]);

                jLabelCreator[i] = new JLabel(username);
                jLabelCreator[i].setBounds(150, 230+gap, 100, 23);
                jPanel1.add(jLabelCreator[i]);

                jLabelCreatedon[i] = new JLabel("Created on : ");
                jLabelCreatedon[i].setBounds(50, 250+gap, 100, 23);
                jPanel1.add(jLabelCreatedon[i]);

                String dates = datetime.toString();
                jLabelDate[i] = new JLabel(dates);
                jLabelDate[i].setBounds(150, 250+gap, 150, 23);
                jPanel1.add(jLabelDate[i]);

                jTextArea[i] = new JTextArea(text);
                jTextArea[i].setBounds(300, 200+gap, 450, 100);
                jTextArea[i].setWrapStyleWord(true);
                jTextArea[i].setLineWrap(true);
                jTextArea[i].setEditable(false);//set text area not editable
                
                jScrollPane[i] = new JScrollPane(); 
                jScrollPane[i].setViewportView(jTextArea[i]);
                jScrollPane[i].setBounds(300, 200+gap, 450, 100);
                jPanel1.add(jScrollPane[i]);//add scroll pane on text area

                jButton[i] = new JButton("See reaction");
                jButton[i].setBounds(800, 200+gap, 100, 23);
                jPanel1.add(jButton[i]);
                
                if(picture!=null){
                    jPictureButton[i] = new JButton("picture");
                    jPictureButton[i].setBounds(800,220+gap,100,23);
                    jPanel1.add(jPictureButton[i]);
                    indexOfJPictureButton.add(i);
                }
                picture = null;
                System.out.println("i : " + i);
                
                gap+= 100;
                i++;
                
            }
            addComment();
            setUpButtonListener();
        }
        catch (SQLException ex) {
            Logger.getLogger(CommentPage.class.getName()).log(Level.SEVERE, null, ex); // will just print the errors to our console
        }
        UndoRedo ur = new UndoRedo(redoButton,undoButton,addComment);
    }
    public void setUpButtonListener(){
        ActionListener buttonListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i=0;i<index;i++){
                    if(e.getSource() == jButton[i]){
                        goToReactionForm(i+1,issueIDs,projectIDs);
                        break;
                    }
                    else if(e.getSource() == jPictureButton[i]){
                       goToPictureForm(i+1,issueIDs,projectIDs);
                       break;
                    }
                }
                if (e.getSource() == submitButton){
                    submitComment();
                }
            }
        };
        for(int i=0;i<index;i++){
            jButton[i].addActionListener(buttonListener);
        }
        for(int i=0; i<indexOfJPictureButton.size();i++){
            jPictureButton[indexOfJPictureButton.get(i)].addActionListener(buttonListener);
        }
        submitButton.addActionListener(buttonListener);
    }
    public void goToReactionForm(int commentID,int issueID,int projectID){
        ReactionForm reactPage = new ReactionForm(commentID,issueID,projectID);
        this.dispose();//dispose the current ProjectDashboard GUI
        reactPage.setVisible(true);
    }
    
    public void goToPictureForm(int commentID, int issueID, int projectID){
        PictureForm pictureForm = new PictureForm(commentID, issueID, projectID);
        pictureForm.setVisible(true);
    }
    public void submitComment(){
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to submit?", "Alert!",JOptionPane.YES_NO_OPTION); // prompt dialog panel
            if(option==0){ // if yes
                try{

                    String description = this.addComment.getText(); 
                    String name = this.commentCreator.getText();
                    
                    //check if any field is empty
                    if(name.equals("")||description.equals("")){
                        JOptionPane.showMessageDialog(null, "ALERT!Please enter all requirement field");
                        throw new Exception("");
                    }

                    try{

                        Cnx connectionClass = new Cnx(); // create connection 
                        Connection connection = connectionClass.getConnection(); //create connection

                        Date dt = new java.util.Date();

                        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

                        String currentTime = sdf.format(dt);    // get current date and time

                        Statement st1 = connection.createStatement(); // create statement from the established connection

                        String query1 = "SELECT MAX(commentID) FROM comment where issueID = "+issueIDs+" and projectID = " +projectIDs;   // selecting the highest id currently inside database
                        ResultSet result1 = st1.executeQuery(query1); // execute query1 and store it inside result1
                        result1.next();
                        int commentID = result1.getInt("") + 1; // adding 1 to the highest id inside database and assign it to current issueID to be created
                        //String sql = "INSERT INTO comment VALUES ("+commentID+","+issueIDs+",'"+projectIDs+"','"+description+"','"+currentTime+"','"+name+")";
                        String sql = "INSERT INTO comment VALUES (?,?,?,?,?,?,?)"; 
                        PreparedStatement st2 = connection.prepareStatement(sql);
                        st2.setInt(1, commentID);
                        st2.setInt(2, issueIDs);
                        st2.setInt(3, projectIDs);
                        st2.setString(4, description);
                        st2.setString(5, currentTime);
                        st2.setString(6, name);
                        st2.setBytes(7, picture);
                        if(st2.executeUpdate() != 0){
                            JOptionPane.showMessageDialog(null,"Your comment has been added");
                            CommentPage newCommentPage = new CommentPage(Integer.valueOf(projectIDs),Integer.valueOf(issueIDs));
                            newCommentPage.setVisible(true); 
                            newCommentPage.setLocationRelativeTo(null);
                            // close previous Comment Page 
                            this.dispose();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Check your information");
                        }

                    }//end second try//end second try
                    catch (SQLException ex) {
                        Logger.getLogger(ProjectDashboard.class.getName()).log(Level.SEVERE, null, ex); // print to the console if sql exceptions occurs
                    } 
                }//end first try//end first try
                catch(Exception e){

                }
            }
    }
    
    public void addComment(){
        addYourName = new JLabel("Name : ");
        addYourName.setBounds(50, 70, 100, 23);
        jPanel1.add(addYourName);
        
        commentCreator = new JTextArea();
        commentCreator.setBounds(100, 70, 100, 23);
        jPanel1.add(commentCreator);
        
        addComment = new JTextArea("Add your comment here");
        addComment.setForeground(Color.LIGHT_GRAY);
        addComment.setBounds(300, 70, 450, 100);
        addComment.setWrapStyleWord(true);
        addComment.setLineWrap(true);
        addComment.setOpaque(true);
        addComment.addMouseListener(this);
        jPanel1.add(addComment);
        
        scrollAddComment = new JScrollPane(); 
        scrollAddComment.setViewportView(addComment);
        scrollAddComment.setBounds(300, 70, 450, 100);
        jPanel1.add(scrollAddComment);
        
        undoButton = new JButton("Undo");
        undoButton.setBounds(100, 100, 80, 23);
        jPanel1.add(undoButton);
        redoButton = new JButton("Redo");
        redoButton.setBounds(100, 120, 80, 23);
        jPanel1.add(redoButton);
        submitButton = new JButton("Submit");
        submitButton.setBounds(800, 70, 100, 23);
        jPanel1.add(submitButton);
        uploadPictureButton = new JButton("Choose Pic");
        uploadPictureButton.setBounds(800,90,100,23);
        uploadPictureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPictureButtonActionPerformed(evt);
            }
        });
        jPanel1.add(uploadPictureButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void init(int count){
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setMaximumSize(new java.awt.Dimension(100000, 100000));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(5000, 5000));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Comment Page");

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
                .addGap(20, 20, 20)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addContainerGap(616, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(backButton)))
                .addContainerGap(150 * count, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setMaximumSize(new java.awt.Dimension(100000, 100000));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(5000, 5000));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Comment Page");

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
                .addGap(20, 20, 20)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addContainerGap(616, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(backButton)))
                .addContainerGap(490, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void uploadPictureButtonActionPerformed(java.awt.event.ActionEvent evt){
         JFileChooser chooser = new JFileChooser(".");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int response = chooser.showOpenDialog(null); // dialog where user can choose a file
        if(response == JFileChooser.APPROVE_OPTION){
            
            File f = chooser.getSelectedFile();
            String fileName = f.getAbsolutePath();
            Double lengthOfFile = f.length()/Math.pow(1024, 2);// convert bytes to MB
            System.out.println(lengthOfFile);
            if(f.isFile()){
                if(fileName.contains(".png") || fileName.contains(".jpg")){
                    if(lengthOfFile<5){
                        // do the insertion into database and to the place to insert image
//                        ImageIcon imageIcon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(0/*label width*/, 0/*labelheight*/, 0/*smooth scale or something*/));
                        // set label with the image   label.setIcon(imageIcon)
                        try{
                            File image = new File(fileName);
                            FileInputStream fis = new FileInputStream(image);
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            byte[] buf = new byte[(int)Math.pow(1024, 2)];
                            try {
                                for(int readNum; (readNum=fis.read(buf))!=1;){
                                    bos.write(buf,0,readNum);
                                }
                            } catch (Exception ex) {
//                                Logger.getLogger(CommentPage.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            picture = bos.toByteArray();
                        }
                        
                        catch(FileNotFoundException ex){
                            
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ALERT!!\nThe size of your image is too large.");
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "ALERT!!\nThe file you're choosing is not a picture format supported");
                }
            }
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try{
            PreparedStatement st;
            String query = "SELECT * FROM issue WHERE issueID = ? AND projectID = ?" ;
            Cnx connectionClass = new Cnx(); //create connection
            st = connectionClass.getConnection().prepareStatement(query);
            st.setInt(1, issueIDs);
            st.setInt(2, projectIDs);
            IssuePage form = new IssuePage(st, projectIDs);
            form.setVisible(true);
            form.pack();
            form.setLocationRelativeTo(null);
            // close Issue Dashboard Form
            this.dispose();
        }
        catch (SQLException ex) {
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommentPage(1,1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        addComment.setText("");
        addComment.setForeground(Color.BLACK);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
