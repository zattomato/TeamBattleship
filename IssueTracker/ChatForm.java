
package IssueTracker;
import ConnectionToDatabase.Cnx;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatForm extends javax.swing.JFrame {
    
    static GroupLayout jPanel2Layout;
    static SequentialGroup subGroup; 
    static ParallelGroup group ;
    static int NUMOFRECORDS;
    static String executionTimeStamp;
    static String userName = "TheRealKayshav";
    /**
     * Creates new form ChatForm
     */
    public ChatForm() throws SQLException, InterruptedException {
        jPanel2 = new JPanel();
        this.jPanel2Layout = new GroupLayout(jPanel2);
        this.group = jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        this.subGroup = jPanel2Layout.createSequentialGroup();

        init();
        this.setLocationRelativeTo(null);
        
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // format precision up to day
        executionTimeStamp = sdf.format(dt);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(executionTimeStamp)); // set date to current date
        } catch (ParseException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        calendar.add(Calendar.DATE, 1); //increment date by one
        String nextDay = sdf.format(calendar.getTime());
        Statement st = new Cnx().getConnection().createStatement();
        ResultSet result = st.executeQuery("select* from chat where date>'" + executionTimeStamp + "' and date<'"+nextDay+"' order by date"); // select chat for current day

        SimpleDateFormat trueFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); // format precision up to millisecond
        executionTimeStamp = trueFormat.format(dt);

        ArrayList<Chat> chatList = new ArrayList<>();
        while (result.next()) {
            chatList.add(new Chat(result.getString("userName"), result.getString("text"), result.getTimestamp("date")));
            NUMOFRECORDS++;
        }

        int count = 0;
        for (int i = 0; i < chatList.size(); i++) {// create textfield and set it with the data obtained from database

            JTextArea textArea = new JTextArea();
            JScrollPane scrollPanel = new JScrollPane();
            textArea.setColumns(30);
            textArea.setRows(5);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setText(chatList.get(i).getUserName() + ":\n\n" + chatList.get(i).getText() + "\n\n\t" + chatList.get(i).getDate().toString());
            scrollPanel.setViewportView(textArea);
            if (chatList.get(i).getUserName().equals(userName)) {
                scrollPanel.setBounds(323, 57 + count * (83 + 18), 273, 83);// set text to the right
            } else {

                scrollPanel.setBounds(50, 57 + count * (83 + 18), 273, 83); // (coordinate x, coordinate y, width, height) 
            }
            //coordinate y = 57 is the initial gap, 83 is the height of the textField and 18 is the gap used for each text field
            jPanel2.add(scrollPanel);
            jScrollPane1.setViewportView(jPanel2);
            count++;
            group.addGap(57 + count * (83 + 18)); // extend the gap 
            group.addGroup(subGroup);
            jPanel2Layout.setVerticalGroup(group);

        }
        
    }
    
    public static void refresh() throws InterruptedException, SQLException{
        
        Thread.sleep(1000);//sleep for 1 second
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime = sdf.format(dt);    // get current date and time
        ResultSet result = new Cnx().getConnection().createStatement().executeQuery("select* from chat where date>'" + executionTimeStamp + "' and date<='" + currentTime + "' order by date");
        executionTimeStamp = currentTime;
        
        ArrayList<Chat> chatList = new ArrayList<>();
        while (result.next()) {
            chatList.add(new Chat(result.getString("userName"), result.getString("text"), result.getTimestamp("date")));
        }
        if (chatList.size() > 0) {
            update(chatList);

        }
        refresh();
        
    }
    public static void update(ArrayList<Chat> chatList){
        
        for (int i = 0; i < chatList.size(); i++) {// create text field and set it with the data obtained from the database

            JTextArea textArea = new JTextArea();
            JScrollPane scrollPanel = new JScrollPane();
            textArea.setColumns(30);
            textArea.setRows(5);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setText(chatList.get(i).getUserName() + ":\n\n" + chatList.get(i).getText() + "\n\n\t" + chatList.get(i).getDate().toString());
            scrollPanel.setViewportView(textArea);
            if (chatList.get(i).getUserName().equals(userName)) {
                scrollPanel.setBounds(323, 57 + NUMOFRECORDS * (83 + 18), 273, 83);// set text to the right
            } else {

                scrollPanel.setBounds(50, 57 + NUMOFRECORDS * (83 + 18), 273, 83); // (coordinate x, coordinate y, width, height) 
            }
            //coordinate y = 57 is the initial gap, 83 is the height of the textField and 18 is the gap used for each text field
            jPanel2.add(scrollPanel);
            jScrollPane1.setViewportView(jPanel2);
            NUMOFRECORDS++;
            group.addGap(57 + NUMOFRECORDS * (83 + 18)); // increase the gap
            group.addGroup(subGroup);
            jPanel2Layout.setVerticalGroup(group);

        }
        
        Toolkit.getDefaultToolkit().beep(); // set a sound to notify if there's an update
    }

    
    private void init(){
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTextArea.setColumns(20);
        userTextArea.setForeground(new java.awt.Color(153, 153, 153));
        userTextArea.setRows(5);
        userTextArea.setText("Type a message");
        userTextArea.setLineWrap(true);
        userTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userTextAreaFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                userTextAreaFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(userTextArea);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(backButton)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 13, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(submitButton))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(backButton)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

//        jPanel2.setPreferredSize(new java.awt.Dimension(700, 403));
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 600, Short.MAX_VALUE)
        );

        group = jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        group.addGap(0, 403, Short.MAX_VALUE);
        subGroup = jPanel2Layout.createSequentialGroup();
        subGroup.addGap(57, 57, 57);
        subGroup.addGap(179);
        group.addGroup(subGroup);
        jPanel2Layout.setVerticalGroup(group);
//        jPanel2Layout.setVerticalGroup(
//            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 403, Short.MAX_VALUE)
//        );

        jScrollPane1.setViewportView(jPanel2);
        
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chat Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTextArea.setColumns(20);
        userTextArea.setForeground(new java.awt.Color(153, 153, 153));
        userTextArea.setRows(5);
        userTextArea.setText("Type a message");
        userTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userTextAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userTextAreaFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(userTextArea);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(backButton)
                .addGap(87, 87, 87)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(submitButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(backButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 403));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chat Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String text = userTextArea.getText();
        text = text.replaceAll("'", "''"); // replace for example I'm with I''m because inside sql, single quotation mark is the escape character
        userTextArea.setText("Type a message");
        userTextArea.setForeground(new Color(153, 153, 153));
        Date dt = new Date(System.currentTimeMillis() + 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String currentTime = sdf.format(dt);
        try {
            new Cnx().getConnection().createStatement().executeUpdate("insert into chat values('" + userName + "','" + text + "','" + currentTime + "')"); // insert into database
        } catch (SQLException ex) {
            Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // no implementation yet
    }//GEN-LAST:event_backButtonActionPerformed

    private void userTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextAreaFocusGained
        if (userTextArea.getText().trim().toLowerCase().equals("type a message")) {
            userTextArea.setText("");
            userTextArea.setForeground(Color.black);
        }
    }//GEN-LAST:event_userTextAreaFocusGained

    private void userTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextAreaFocusLost
        if (userTextArea.getText().trim().toLowerCase().equals("type a message")
               || userTextArea.getText().trim().equals("")) {
           userTextArea.setText("Type a message");
           userTextArea.setForeground(new Color(153, 153, 153));
       }
    }//GEN-LAST:event_userTextAreaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException, SQLException {
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
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChatForm().setVisible(true);
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ChatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread.sleep(4000); // wait for a while for the form to pop up
        refresh(); // call refresh after the form has been instantiated
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextArea userTextArea;
    // End of variables declaration//GEN-END:variables
}
