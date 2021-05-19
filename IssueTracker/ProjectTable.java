
package IssueTracker;

/**
 * this class is use to represent the data fetched from external database
 * this class is used in ProjectDashboard.java
 */
public class ProjectTable {
    private int projectID;
    private String projectName;
    private String description;
    private int issueCount;

    public ProjectTable(int projectID, String projectName, String description, int issueCount) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.description = description;
        this.issueCount = issueCount;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public int getIssueCount() {
        return issueCount;
    }
    
    
  
    
}
