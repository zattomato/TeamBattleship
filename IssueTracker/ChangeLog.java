
package IssueTracker;

import ConnectionToDatabase.Cnx;
import java.sql.*;
public class ChangeLog {
    private int projectID;
    private String userName;
    private String date;
    private String description;

    public ChangeLog(int projectID ,String userName, String date, String description) {
        this.projectID = projectID;
        this.userName = userName;
        this.date = date;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    
    
    public void addLog() throws SQLException{
        new Cnx().getConnection().createStatement().executeUpdate("insert into changelog values("+projectID+", '"+userName+"', '"+date+"', '"+description+"')");
    }
}
