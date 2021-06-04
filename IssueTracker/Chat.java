/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IssueTracker;
import java.sql.*;
public class Chat {
    private String userName;
    private String text;
    private Timestamp date;
    
    public Chat(String name, String text, Timestamp date){
        this.userName = name;
        this.text = text;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }

    public Timestamp getDate() {
        return date;
    }
    
    
}
