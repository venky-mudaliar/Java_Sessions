import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Ch48_ResultSets {
	 public static void main(String[] args) {
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;

	        try {
	            // Establish connection to the PostgreSQL database
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");

	            // Example 1: Retrieve Customer Details
	            System.out.println("Retrieving Customer Details:");
	            retrieveCustomerDetails(connection);

	            // Example 2: Retrieve Account Balances
	            System.out.println("\nRetrieving Account Balances:");
	            retrieveAccountBalances(connection);

	            // Example 3: Retrieve Transaction History
	            System.out.println("\nRetrieving Transaction History:");
	            retrieveTransactionHistory(connection);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the connection when done
	            try {
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Method to retrieve customer details
	    public static void retrieveCustomerDetails(Connection connection) {
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = connection.createStatement();
	            String sql = "SELECT first_name, last_name, email FROM customers WHERE customer_id = 2";
	            resultSet = statement.executeQuery(sql);

	            if (resultSet.next()) {
	                String firstName = resultSet.getString("first_name");
	                String lastName = resultSet.getString("last_name");
	                String email = resultSet.getString("email");
	                System.out.println("First Name: " + firstName);
	                System.out.println("Last Name: " + lastName);
	                System.out.println("Email: " + email);
	            } else {
	                System.out.println("Customer not found.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(statement, resultSet);
	        }
	    }

	    // Method to retrieve account balances
	    public static void retrieveAccountBalances(Connection connection) {
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = connection.createStatement();
	            String sql = "SELECT account_id, balance FROM accounts WHERE customer_id = 2";
	            resultSet = statement.executeQuery(sql);

	            System.out.println("Account Balances:");
	            while (resultSet.next()) {
	                int accountId = resultSet.getInt("account_id");
	                double balance = resultSet.getDouble("balance");
	                System.out.println("Account ID: " + accountId + ", Balance: $" + balance);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(statement, resultSet);
	        }
	    }

	    // Method to retrieve transaction history
	    public static void retrieveTransactionHistory(Connection connection) {
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = connection.createStatement();
	            String sql = "SELECT transaction_id, transaction_date, amount FROM transactions WHERE account_id = 2 ORDER BY transaction_date DESC";
	            resultSet = statement.executeQuery(sql);

	            System.out.println("Transaction History:");
	            while (resultSet.next()) {
	                int transactionId = resultSet.getInt("transaction_id");
	                java.sql.Date transactionDate = resultSet.getDate("transaction_date");
	                double amount = resultSet.getDouble("amount");
	                System.out.println("Transaction ID: " + transactionId + ", Date: " + transactionDate + ", Amount: $" + amount);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(statement, resultSet);
	        }
	    }

	    // Utility method to close Statement and ResultSet resources
	    public static void closeResources(Statement statement, ResultSet resultSet) {
	        try {
	            if (resultSet != null) resultSet.close();
	            if (statement != null) statement.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

