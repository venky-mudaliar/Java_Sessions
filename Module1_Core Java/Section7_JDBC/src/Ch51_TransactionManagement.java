import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ch51_TransactionManagement {
	 public static void main(String[] args) {
		 Ch51_TransactionManagement bankSystem = new Ch51_TransactionManagement();
	        Connection connection = null;

	        try {
	            // Establish connection to PostgreSQL database
	            connection = bankSystem.getConnection();

	            // Example 1: Transferring money between accounts
	            bankSystem.transferFunds(connection, 1, 2, 500.0);

	            // Example 2: Creating a new customer and opening an account
	            bankSystem.createCustomerAndAccount(connection, "Jane", "Doe", "jane.doe@example.com", 1000.0);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Ensure the connection is closed
	            try {
	                if (connection != null) connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Method to establish a connection
	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");
	    }

	    // Method for transferring funds between two accounts
	    public void transferFunds(Connection connection, int sourceAccountId, int targetAccountId, double amount) throws SQLException {
	        PreparedStatement debitStatement = null;
	        PreparedStatement creditStatement = null;

	        try {
	            // Disable auto-commit mode for manual transaction management
	            connection.setAutoCommit(false);

	            // SQL statements for debiting and crediting accounts
	            String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
	            String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";

	            // Prepare the statements
	            debitStatement = connection.prepareStatement(debitSql);
	            creditStatement = connection.prepareStatement(creditSql);

	            // Set parameters for debiting the source account
	            debitStatement.setDouble(1, amount);
	            debitStatement.setInt(2, sourceAccountId);

	            // Set parameters for crediting the target account
	            creditStatement.setDouble(1, amount);
	            creditStatement.setInt(2, targetAccountId);

	            // Execute the debit and credit operations
	            int debitRowsAffected = debitStatement.executeUpdate();
	            int creditRowsAffected = creditStatement.executeUpdate();

	            // Check if both operations were successful
	            if (debitRowsAffected > 0 && creditRowsAffected > 0) {
	                connection.commit();
	                System.out.println("Transaction successful. Amount transferred.");
	            } else {
	                connection.rollback();
	                System.out.println("Transaction failed. Rolled back.");
	            }

	        } catch (SQLException e) {
	            connection.rollback();
	            System.out.println("Transaction failed due to an error. Rolled back.");
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            if (debitStatement != null) debitStatement.close();
	            if (creditStatement != null) creditStatement.close();
	        }
	    }

	    // Method for creating a new customer and opening an account
	    public void createCustomerAndAccount(Connection connection, String firstName, String lastName, String email, double initialBalance) throws SQLException {
	        PreparedStatement customerStatement = null;
	        PreparedStatement accountStatement = null;

	        try {
	            // Disable auto-commit for transaction management
	            connection.setAutoCommit(false);

	            // SQL statements to create a customer and open an account
	            String customerSql = "INSERT INTO customers (first_name, last_name, email) VALUES (?, ?, ?)";
	            String accountSql = "INSERT INTO accounts (customer_id, balance) VALUES (?, ?)";

	            // Prepare the statements
	            customerStatement = connection.prepareStatement(customerSql, new String[]{"customer_id"});
	            accountStatement = connection.prepareStatement(accountSql);

	            // Set parameters for creating the customer
	            customerStatement.setString(1, firstName);
	            customerStatement.setString(2, lastName);
	            customerStatement.setString(3, email);

	            // Execute the customer creation and retrieve generated customer_id
	            int customerRowsAffected = customerStatement.executeUpdate();
	            if (customerRowsAffected > 0) {
	                try (var generatedKeys = customerStatement.getGeneratedKeys()) {
	                    if (generatedKeys.next()) {
	                        int customerId = generatedKeys.getInt(1);

	                        // Set parameters for creating the account
	                        accountStatement.setInt(1, customerId); // Customer ID
	                        accountStatement.setDouble(2, initialBalance); // Initial balance

	                        // Execute the account creation
	                        int accountRowsAffected = accountStatement.executeUpdate();

	                        if (accountRowsAffected > 0) {
	                            connection.commit();
	                            System.out.println("Customer and account created successfully.");
	                        } else {
	                            connection.rollback();
	                            System.out.println("Transaction failed. Rolled back.");
	                        }
	                    }
	                }
	            } else {
	                connection.rollback();
	                System.out.println("Transaction failed. Rolled back.");
	            }

	        } catch (SQLException e) {
	            connection.rollback();
	            System.out.println("Transaction failed due to an error. Rolled back.");
	            e.printStackTrace();
	        } finally {
	            // Close resources
	            if (customerStatement != null) customerStatement.close();
	            if (accountStatement != null) accountStatement.close();
	        }
	    }
	}

