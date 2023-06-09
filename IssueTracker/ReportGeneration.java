/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;

import ConnectionToDatabase.Cnx;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author Admin
 */
public class ReportGeneration extends javax.swing.JFrame {
    private String username;
    /**
     * Creates new form ReportGeneration
     */
    public ReportGeneration(){
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    
    public ReportGeneration(String username) {
        initComponents();
        this.username = username;
        this.setLocationRelativeTo(null);
        DateChooserStart.setEnabled(false);
        DateChooserEnd.setEnabled(false);
        UpdateChart.setEnabled(false);

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
        Charts = new javax.swing.JPanel();
        DateChooserStart = new com.toedter.calendar.JDateChooser();
        DateChooserEnd = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IssueStat = new javax.swing.JButton();
        IssueTags = new javax.swing.JButton();
        IssueByDay = new javax.swing.JButton();
        TopPerformer = new javax.swing.JButton();
        UpdateChart = new javax.swing.JButton();
        YearlyIssue = new javax.swing.JButton();
        FrequencyLabel = new javax.swing.JLabel();
        FreqByMonth = new javax.swing.JButton();
        IssueFreq = new javax.swing.JButton();
        WeeklyIssue = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Charts.setBackground(new java.awt.Color(204, 204, 204));
        Charts.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "REPORT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 14))); // NOI18N
        Charts.setLayout(new javax.swing.BoxLayout(Charts, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel1.setText("Date from:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel2.setText("until Date:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Charts, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateChooserStart, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Charts, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateChooserStart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DateChooserEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        IssueStat.setText("STATUS");
        IssueStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueStatActionPerformed(evt);
            }
        });

        IssueTags.setText("ISSUE TAG");
        IssueTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueTagsActionPerformed(evt);
            }
        });

        IssueByDay.setText("BY DAY");
        IssueByDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueByDayActionPerformed(evt);
            }
        });

        TopPerformer.setText("TOP PERFORMER");
        TopPerformer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopPerformerActionPerformed(evt);
            }
        });

        UpdateChart.setText("UPDATE");
        UpdateChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateChartActionPerformed(evt);
            }
        });

        YearlyIssue.setText("BY YEAR");
        YearlyIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearlyIssueActionPerformed(evt);
            }
        });

        FrequencyLabel.setFont(new java.awt.Font("Times New Roman", 3, 11)); // NOI18N
        FrequencyLabel.setForeground(new java.awt.Color(51, 51, 255));
        FrequencyLabel.setText("NUMBER OF ISSUE");

        FreqByMonth.setText("BY MONTH");
        FreqByMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FreqByMonthActionPerformed(evt);
            }
        });

        IssueFreq.setText("ISSUE FREQUENCY");
        IssueFreq.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        IssueFreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IssueFreqActionPerformed(evt);
            }
        });

        WeeklyIssue.setText("BY WEEK");
        WeeklyIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeeklyIssueActionPerformed(evt);
            }
        });

        backButton.setText("HOME");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FrequencyLabel)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(IssueByDay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(YearlyIssue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(FreqByMonth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(WeeklyIssue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(IssueStat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(IssueTags, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TopPerformer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(IssueFreq, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UpdateChart)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(FrequencyLabel)
                        .addGap(18, 18, 18)
                        .addComponent(IssueByDay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FreqByMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(YearlyIssue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(WeeklyIssue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(IssueFreq)
                        .addGap(18, 18, 18)
                        .addComponent(TopPerformer)
                        .addGap(18, 18, 18)
                        .addComponent(IssueTags)
                        .addGap(18, 18, 18)
                        .addComponent(IssueStat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateChart)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IssueStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueStatActionPerformed
        
        DateChooserStart.setEnabled(false);
        DateChooserEnd.setEnabled(false);
        UpdateChart.setEnabled(false);
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {
                        
            String query= "SELECT issueStatus, COUNT(issueID) FROM issue GROUP BY issueStatus"; //select all issue status and count number of issue for each status
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query); //put into dataset
            //Create chart based on dataset
            JFreeChart chart= ChartFactory.createBarChart("Issue Status Chart", "Issue Status", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel); //display chart inside report box
            Charts.updateUI();
            
        } catch (SQLException e) {
        } 
        
    }//GEN-LAST:event_IssueStatActionPerformed

    private void IssueByDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueByDayActionPerformed
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {                  
            String query= "SELECT FORMAT(date,'yyyy-MM-dd'), COUNT(issueID) FROM issue GROUP BY FORMAT(date,'yyyy-MM-dd') ORDER BY FORMAT(date,'yyyy-MM-dd') ";
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
            JFreeChart chart= ChartFactory.createBarChart("Issue by Day Chart ", "Date", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel);
            Charts.updateUI();
            
        } catch (SQLException e) {
        }

        DateChooserStart.setEnabled(false);
        DateChooserEnd.setEnabled(false);
        UpdateChart.setEnabled(false);
        
    }//GEN-LAST:event_IssueByDayActionPerformed

    private void IssueTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueTagsActionPerformed
        
        DateChooserStart.setEnabled(false);
        DateChooserEnd.setEnabled(false);
        UpdateChart.setEnabled(false);
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {
            
            String query= "SELECT issueTag, COUNT(issueID) FROM issue GROUP BY issueTag";
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
            JFreeChart chart= ChartFactory.createBarChart("Issue Tag Chart", "Issue Tag", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel);
            Charts.updateUI();
            
        } catch (SQLException e) {
        }
        
        
    }//GEN-LAST:event_IssueTagsActionPerformed

    private void TopPerformerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopPerformerActionPerformed
        
        DateChooserStart.setEnabled(false);
        DateChooserEnd.setEnabled(false);
        UpdateChart.setEnabled(false);
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {
            
            String query= "SELECT assignee, COUNT(issueID) FROM issue WHERE issueStatus = 'Closed' GROUP BY assignee";
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
            JFreeChart chart= ChartFactory.createBarChart("Top Performer In Team", "Assignee", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel);
            Charts.updateUI();
            
        } catch (SQLException e) {
        }
        
        
    }//GEN-LAST:event_TopPerformerActionPerformed

    private void UpdateChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateChartActionPerformed
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd ");
        String dateStart= sdf.format(DateChooserStart.getDate());
        String dateEnd= sdf.format(DateChooserEnd.getDate()); 
        
        if(dateStart.compareToIgnoreCase(dateEnd)>0){
            JOptionPane.showMessageDialog(null, "Enter date in valid sequence");
        }
        else{
            try{
                String query= "SELECT FORMAT(date,'yyyy-MM-dd'), COUNT(issueID) FROM issue WHERE date>='"+ dateStart + "' AND date<='" + dateEnd + "' GROUP BY FORMAT(date,'yyyy-MM-dd') ORDER BY FORMAT(date,'yyyy-MM-dd') ";
                JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
                JFreeChart chart= ChartFactory.createLineChart("Issue Frequency Chart", "Date", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
                BarRenderer renderer =null;
                CategoryPlot plot= chart.getCategoryPlot();
                plot.setOutlinePaint(Color.CYAN);
                renderer= new BarRenderer();
                ChartPanel panel= new ChartPanel(chart);
                Charts.removeAll();
                Charts.add(panel);
                Charts.updateUI();
            
            } catch (SQLException e) {
            } 
        }
         
    }//GEN-LAST:event_UpdateChartActionPerformed

    private void YearlyIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearlyIssueActionPerformed
        
        
        DateChooserStart.setEnabled(false);
        DateChooserEnd.setEnabled(false);
        UpdateChart.setEnabled(false);
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {
            
            String query= "SELECT YEAR(date), COUNT(issueID) FROM issue GROUP BY YEAR(date) ORDER BY YEAR(date)";
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
            JFreeChart chart= ChartFactory.createBarChart("Issue by Year", "Year", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel);
            Charts.updateUI();
            
        } catch (SQLException e) {
        }
        
        
    }//GEN-LAST:event_YearlyIssueActionPerformed

    private void IssueFreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IssueFreqActionPerformed
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {                  
            String query= "SELECT FORMAT(date,'yyyy-MM-dd'), COUNT(issueID) FROM issue GROUP BY FORMAT(date,'yyyy-MM-dd') ORDER BY FORMAT(date,'yyyy-MM-dd') ";
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
            JFreeChart chart= ChartFactory.createLineChart("Issue Frequency Chart ", "Date", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel);
            Charts.updateUI();
            
        } catch (SQLException e) {
        }
        
        DateChooserStart.setEnabled(true);
        DateChooserEnd.setEnabled(true);
        UpdateChart.setEnabled(true);
        
        JOptionPane.showMessageDialog(null, "Note:\nSelect date range and click 'UPDATE' to see the issue frequency over time range ");
        
    }//GEN-LAST:event_IssueFreqActionPerformed

    private void FreqByMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreqByMonthActionPerformed
        
        DateChooserStart.setEnabled(false);
        DateChooserEnd.setEnabled(false);
        UpdateChart.setEnabled(false);
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {
            
            String query= "SELECT FORMAT(date,'yyyy-MM'), COUNT(issueID) FROM issue GROUP BY FORMAT(date,'yyyy-MM') ORDER BY FORMAT(date,'yyyy-MM')";
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
            JFreeChart chart= ChartFactory.createBarChart("Issue by Month", "Month", "Number ofIssue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel);
            Charts.updateUI();
            
        } catch (SQLException e) {
        }
        
        
    }//GEN-LAST:event_FreqByMonthActionPerformed

    private void WeeklyIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeeklyIssueActionPerformed
        
        Cnx connectionclass= new Cnx();
        Connection connection= connectionclass.getConnection();
        
        try {
            
            String query= "SELECT FORMAT(DATEADD(week, DATEDIFF(week, 0, date), 0),'yyyy-MM-dd'), COUNT(issueID) FROM issue GROUP BY DATEADD(week, DATEDIFF(week, 0, date), 0) ORDER BY DATEADD(week, DATEDIFF(week, 0, date), 0)";
            JDBCCategoryDataset data= new JDBCCategoryDataset(connection,query);
            JFreeChart chart= ChartFactory.createBarChart("Issue by Week", "Week", "Number of Issue", data, PlotOrientation.VERTICAL, true, true, false);
            BarRenderer renderer =null;
            CategoryPlot plot= chart.getCategoryPlot();
            plot.setOutlinePaint(Color.CYAN);
            renderer= new BarRenderer();
            
            ChartPanel panel= new ChartPanel(chart);
            Charts.removeAll();
            Charts.add(panel);
            Charts.updateUI();
            
        } catch (SQLException e) {
        }
        
        
        
    }//GEN-LAST:event_WeeklyIssueActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        ProjectDashboard projectDashboard = new ProjectDashboard(username);
        projectDashboard.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(ReportGeneration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportGeneration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportGeneration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportGeneration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportGeneration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Charts;
    private com.toedter.calendar.JDateChooser DateChooserEnd;
    private com.toedter.calendar.JDateChooser DateChooserStart;
    private javax.swing.JButton FreqByMonth;
    private javax.swing.JLabel FrequencyLabel;
    private javax.swing.JButton IssueByDay;
    private javax.swing.JButton IssueFreq;
    private javax.swing.JButton IssueStat;
    private javax.swing.JButton IssueTags;
    private javax.swing.JButton TopPerformer;
    private javax.swing.JButton UpdateChart;
    private javax.swing.JButton WeeklyIssue;
    private javax.swing.JButton YearlyIssue;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
