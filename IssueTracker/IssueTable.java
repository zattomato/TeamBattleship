/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author User
 */
public class IssueTable {
    private int issueID;
    private String issueName;
    private int projectID;
    private String issueStatus;
    private String issueTag;
    private int issuePriority;
    private Timestamp issueTime;
    private String issueAssignee;
    private String issueCreatedBy;
    private String issueDescription;

    public IssueTable(int issueID, String issueName,int projectID, String issueStatus, String issueTag,Timestamp issueTime,String issueAssignee, String issueCreatedBy, String description,int issuePriority) {
        this.issueID = issueID;
        this.issueName = issueName;
        this.projectID = projectID;
        this.issueStatus = issueStatus;
        this.issueTag = issueTag;
        this.issuePriority = issuePriority;
        this.issueTime = issueTime;
        this.issueAssignee = issueAssignee;
        this.issueCreatedBy = issueCreatedBy;
        this.issueDescription = description;
    }

    public int getIssueID() {
        return issueID;
    }

    public String getIssueName() {
        return issueName;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public String getIssueTag() {
        return issueTag;
    }

    public int getIssuePriority() {
        return issuePriority;
    }

    public Timestamp getIssueTime() {
        return issueTime;
    }

    public String getIssueAssignee() {
        return issueAssignee;
    }

    public String getIssueCreatedBy() {
        return issueCreatedBy;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

   
}
