import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Ch52_BatchProcessing {
	 public static void main(String[] args) {
	        Ch52_BatchProcessing system = new Ch52_BatchProcessing();
	        system.insertCustomers();
	        system.updateAccountBalances();
	    }

	    // Method to get a connection to the PostgreSQL database
	    public Connection getConnection() {
	        Connection connection = null;
	        try {
	            // Establish connection to the PostgreSQL database
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");
	            System.out.println("Connection established successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    // Method to insert multiple customers
	    public void insertCustomers() {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            // Get the database connection
	            connection = getConnection();

	            if (connection != null) {
	                // SQL statement for inserting a customer
	                String sql = "INSERT INTO customers (first_name, last_name, email) VALUES (?, ?, ?)";

	                // Create a PreparedStatement object
	                preparedStatement = connection.prepareStatement(sql);

	                // Add multiple Indian-origin customers to the batch
	                preparedStatement.setString(1, "Deepak");
	                preparedStatement.setString(2, "Chopra");
	                preparedStatement.setString(3, "deepak.chopra@example.com");
	                preparedStatement.addBatch();

	                preparedStatement.setString(1, "Kiran");
	                preparedStatement.setString(2, "Desai");
	                preparedStatement.setString(3, "kiran.desai@example.com");
	                preparedStatement.addBatch();

	                preparedStatement.setString(1, "Manish");
	                preparedStatement.setString(2, "Mishra");
	                preparedStatement.setString(3, "manish.mishra@example.com");
	                preparedStatement.addBatch();

	                preparedStatement.setString(1, "Rekha");
	                preparedStatement.setString(2, "Bose");
	                preparedStatement.setString(3, "rekha.bose@example.com");
	                preparedStatement.addBatch();

	                preparedStatement.setString(1, "Kunal");
	                preparedStatement.setString(2, "Rao");
	                preparedStatement.setString(3, "kunal.rao@example.com");
	                preparedStatement.addBatch();

	                preparedStatement.setString(1, "Ayesha");
	                preparedStatement.setString(2, "Iyer");
	                preparedStatement.setString(3, "ayesha.iyer@example.com");
	                preparedStatement.addBatch();

	                preparedStatement.setString(1, "Vivek");
	                preparedStatement.setString(2, "Menon");
	                preparedStatement.setString(3, "vivek.menon@example.com");
	                preparedStatement.addBatch();

	                // Execute the batch
	                int[] result = preparedStatement.executeBatch();

	                // Check the result
	                for (int i = 0; i < result.length; i++) {
	                    if (result[i] >= 0) {
	                        System.out.println("Customer " + (i + 1) + " inserted successfully.");
	                    } else {
	                        System.out.println("Customer " + (i + 1) + " insertion failed.");
	                    }
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close resources
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Method to update account balances
	    public void updateAccountBalances() {
	        Connection connection = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            // Get the database connection
	            connection = getConnection();

	            if (connection != null) {
	                // SQL statement for updating account balances
	                String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

	                // Create a PreparedStatement object
	                preparedStatement = connection.prepareStatement(sql);

	                // Add balance updates to the batch
	                preparedStatement.setDouble(1, 100.0);
	                preparedStatement.setInt(2, 1001);  // Account 1
	                preparedStatement.addBatch();

	                preparedStatement.setDouble(1, 200.0);
	                preparedStatement.setInt(2, 1002);  // Account 2
	                preparedStatement.addBatch();

	                preparedStatement.setDouble(1, 300.0);
	                preparedStatement.setInt(2, 1003);  // Account 3
	                preparedStatement.addBatch();

	                // Execute the batch
	                int[] result = preparedStatement.executeBatch();

	                // Check the result
	                for (int i = 0; i < result.length; i++) {
	                    if (result[i] >= 0) {
	                        System.out.println("Account " + (i + 1) + " updated successfully.");
	                    } else {
	                        System.out.println("Account " + (i + 1) + " update failed.");
	                    }
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close resources
	                if (preparedStatement != null) preparedStatement.close();
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}