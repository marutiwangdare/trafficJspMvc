/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author King
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/traffic?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    public UserDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public List < Violation > selectAllViolations() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < Violation > violations = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from violations");) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String phone = rs.getString("phone");
                String country = rs.getString("country");
                String city = rs.getString("city");
                String picture_video = rs.getString("picture_video");
                String violation_type = rs.getString("violation_type");
                int is_approved = rs.getInt("is_approved");
                int is_expired = rs.getInt("is_expired");
                violations.add(new Violation(id, phone, country, city, picture_video, violation_type, is_approved, is_expired));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return violations;
    }
    
    public String selectAllStatus(String country, String city, String violation) {

        String status="";
        int cnt=0,limit=1;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from violations where country=? and city=? and violation_type=? and is_approved=? and is_expired =?");) {
            
            preparedStatement.setString(1, country);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, violation);
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, 0);
            
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            // Step 4: Process the ResultSet object.
            while (rs.next()) { 
               cnt++;
            }

            if(cnt>=limit){
              switch(violation){
               case "red light crossing":
                    status = "red light crossing : city is dangerous";
                   break;
               case "running a stop sign":
                    status = "running a stop sign : city is dangerous";
                   break;
               case "jaywalking":
                    status = "jaywalking : city is insane";
                   break;
               case "littering":
                    status = "littering : city is dirty";
                   break;    
                }
            }else{
                switch(violation){
                case "red light crossing":
                    status = "red light crossing : city is safe";
                   break;
               case "running a stop sign":
                    status = "running a stop sign : city is safe";
                   break;
               case "jaywalking":
                    status = "jaywalking : city is sane";
                   break;
               case "littering":
                    status = "littering : city is clean";
                   break;      
                }
            }


            
        } catch (SQLException e) {
            printSQLException(e);
        }
        return status + " Number of Violations: "+cnt;
    }
    


    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
