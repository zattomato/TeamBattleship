/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;

import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class CommentTable {
    private int commentID;
    private int issueID;
    private int projectID;
    private String text;
    private Timestamp datetime;
    private String username;

    public CommentTable(int commentID, int issueID,int projectID,String text, Timestamp datetime, String username) {
        this.commentID = commentID;
        this.issueID = issueID;
        this.projectID = projectID;
        this.text = text;
        this.datetime = datetime;
        this.username = username;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
