
package ConnectionToDatabase;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Guide {
    /*
    example on how to connect to database and how to query/insert to database, note that this is just an example, there's no appointment table inside our database 
    */
    public static void main(String[]args)throws SQLException{
        int appointmentNo = 0;
        Date date = null;
        int time = 0;
        String id = null;
        //ArrayList<Appointment> list = new ArrayList<>(); //arraylist to store appointments, commented because Appointment class have not been created
        
        
        /**get data from database**/
//....................................................................................................................................
        Cnx connectionClass = new Cnx(); //create connection
        Connection connection = connectionClass.getConnection(); //create connection
        
        Statement st = connection.createStatement(); 
        String query1 = "SELECT COUNT(*) FROM appointment"; // 'appointment' here is the table inside database
        String query2 = "SELECT* FROM appointment"; //example of query statement to get data from database
        
        ResultSet result1 = st.executeQuery(query1); //execute query 
        result1.next();
        int rows =  result1.getInt(""); //  to get how many rows(instances of data) that table 'appointment' have
        
        ResultSet result2 = st.executeQuery(query2);
        for (int i = 0; i < rows; i++) { //to get every rows inside 'appointment' table and add the data into arraylist
                result2.next();
                appointmentNo = result1.getInt("appointment"); // the name inside " " must be the same as the name of the columns(fields) inside table 'appointment'
                date = result1.getDate("date");
                time = result1.getInt("times");
                id = result1.getString("id");
                //list.add(new Appointment(appointmentNo,date,time)); //add appointment into arraylist
                
        }
        connection.close(); //to close connection
//..........................................................................................................................
        
        
        
        
        /**insert data into database**/
//...........................................................................................................................

//        Cnx connectionClass = new Cnx(); //commented because already declared 
//        Connection connection = connectionClass.getConnection();  
//        Statement st = connection.createStatement(); 
         String query3 = "INSERT INTO appointment VALUES ("+appointmentNo+",'"+date+"',"+time+",'"+id+"')";
         st.executeUpdate(query3);
         connection.close();
//...........................................................................................................................
    }
}
