
package ConnectionToDatabase;

import java.sql.DriverManager;

public class Cnx {
    
    public java.sql.Connection connection;   
     
    public java.sql.Connection getConnection()
    {
        
       
       String userName = "haziq@bugslife";
       String password = "Pieisdelicious123";
       
       try{
          
        connection = DriverManager.getConnection("jdbc:sqlserver://bugslife.database.windows.net:1433;database=BugsLife",userName,password);
        System.out.println("connected to database");
       }
       catch(Exception e){
           e.printStackTrace();
       }

        
        return connection;
    }
}
