import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Ch49_ResultSetMetaData {
	 public static void main(String[] args) {
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;

	        try {
	            // Connect to PostgreSQL database
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");

	            // Example 1: Retrieve account information for customer 56789
	            System.out.println("Account Information for Customer 56789:");
	            retrieveAccountInfo(connection);

	            // Example 2: Retrieve transaction history for account 12345
	            System.out.println("\nTransaction History for Account 12345:");
	            retrieveTransactionHistory(connection);

	            // Example 3: Dynamic query based on user input (balance > 5000 for customer 56789)
	            System.out.println("\nAccounts with Balance > 5000 for Customer 56789:");
	            searchAccountsByBalance(connection);

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Always close the connection at the end
	            try {
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Method to retrieve account information
	    public static void retrieveAccountInfo(Connection connection) {
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = connection.createStatement();
	            String sql = "SELECT * FROM accounts WHERE customer_id = 7";
	            resultSet = statement.executeQuery(sql);

	            // Get ResultSetMetaData to retrieve metadata about the result set
	            ResultSetMetaData metaData = resultSet.getMetaData();
	            int columnCount = metaData.getColumnCount();

	            // Print column names dynamically
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.print(metaData.getColumnLabel(i) + "\t");
	            }
	            System.out.println();

	            // Iterate through the rows and print each column’s data
	            while (resultSet.next()) {
	                for (int i = 1; i <= columnCount; i++) {
	                    System.out.print(resultSet.getString(i) + "\t");
	                }
	                System.out.println();
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
	            String sql = "SELECT transaction_id, transaction_date, amount FROM transactions WHERE account_id = 7";
	            resultSet = statement.executeQuery(sql);

	            // Get ResultSetMetaData
	            ResultSetMetaData metaData = resultSet.getMetaData();
	            int columnCount = metaData.getColumnCount();

	            // Print metadata for each column
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.println("Column Name: " + metaData.getColumnName(i));
	                System.out.println("Column Type: " + metaData.getColumnTypeName(i));
	                System.out.println("Is Nullable: " + (metaData.isNullable(i) == ResultSetMetaData.columnNullable ? "YES" : "NO"));
	                System.out.println("Display Size: " + metaData.getColumnDisplaySize(i));
	                System.out.println();
	            }

	            // Print the transaction data
	            while (resultSet.next()) {
	                for (int i = 1; i <= columnCount; i++) {
	                    System.out.print(resultSet.getString(i) + "\t");
	                }
	                System.out.println();
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeResources(statement, resultSet);
	        }
	    }

	    // Method to search for accounts based on a dynamic condition (balance > 5000)
	    public static void searchAccountsByBalance(Connection connection) {
	        Statement statement = null;
	        ResultSet resultSet = null;
	        try {
	            statement = connection.createStatement();
	            String sql = "SELECT account_id, balance FROM accounts WHERE customer_id = 7 AND balance > 5000";
	            resultSet = statement.executeQuery(sql);

	            // Get ResultSetMetaData
	            ResultSetMetaData metaData = resultSet.getMetaData();
	            int columnCount = metaData.getColumnCount();

	            // Print column names dynamically
	            for (int i = 1; i <= columnCount; i++) {
	                System.out.print(metaData.getColumnLabel(i) + "\t");
	            }
	            System.out.println();

	            // Iterate through rows and print column data
	            while (resultSet.next()) {
	                for (int i = 1; i <= columnCount; i++) {
	                    System.out.print(resultSet.getString(i) + "\t");
	                }
	                System.out.println();
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