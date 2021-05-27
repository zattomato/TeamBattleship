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

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }
    
    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public String getIssueTag() {
        return issueTag;
    }

    public void setIssueTag(String issueTag) {
        this.issueTag = issueTag;
    }

    public int getIssuePriority() {
        return issuePriority;
    }

    public void setIssuePriority(int issuePriority) {
        this.issuePriority = issuePriority;
    }

    public Timestamp getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Timestamp issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssueAssignee() {
        return issueAssignee;
    }

    public void setIssueAssignee(String issueAssignee) {
        this.issueAssignee = issueAssignee;
    }

    public String getIssueCreatedBy() {
        return issueCreatedBy;
    }

    public void setIssueCreatedBy(String issueCreatedBy) {
        this.issueCreatedBy = issueCreatedBy;
    }
    
          
}
