import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Ch45_Connect_to_Database {

	public static void main(String[] args) {
		 Connection connection = null;
	        try {
	            // Step 1: Load PostgreSQL JDBC Driver
	            Class.forName("org.postgresql.Driver");
	            System.out.println("PostgreSQL JDBC Driver Registered!");

	            // Step 2: Establish the connection to the PostgreSQL database
	            String url = "jdbc:postgresql://localhost:5432/bankdatabase";  // URL for PostgreSQL database
	            String username = "postgres";  // Database username
	            String password = "lazycoffee";   // Database password

	            // Establishing the connection
	            connection = DriverManager.getConnection(url, username, password);
	            System.out.println("Connection to PostgreSQL database established successfully!");

	            // Perform any database operations here (queries, inserts, updates, etc.)
	            // For now, just confirming the connection

	        } catch (ClassNotFoundException e) {
	            // If PostgreSQL JDBC Driver is not found
	            System.out.println("PostgreSQL JDBC Driver not found. Make sure it's in the classpath.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // Handle errors when connecting to the PostgreSQL database
	            System.out.println("Failed to connect to PostgreSQL database.");
	            e.printStackTrace();
	        } finally {
	            // Step 3: Properly closing the connection
	            if (connection != null) {
	                try {
	                    connection.close();  // Closing the connection
	                    System.out.println("Connection to PostgreSQL database closed.");
	                } catch (SQLException e) {
	                    // Handle exceptions during connection close
	                    System.out.println("Failed to close the connection.");
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}
