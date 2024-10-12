import java.sql.Connection;
import java.sql.DriverManager;
import java.math.BigDecimal;
import java.sql.CallableStatement;
public class Ch50_CallableStatement_Interface {

	 public static void main(String[] args) {
		 Ch50_CallableStatement_Interface system = new Ch50_CallableStatement_Interface();
	        
	        // Running stored procedure examples
	        system.runTransferFundsProcedure();
	        system.runGenerateStatementProcedure();
	    }

	    // Method to establish a connection to the PostgreSQL database
	    public Connection getConnection() {
	        Connection connection = null;
	        try {
	            // Establish connection to the PostgreSQL database
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");
	            System.out.println("Connection established successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    // Method to call the stored procedure for transferring funds
	    public void runTransferFundsProcedure() {
	        Connection connection = null;
	        CallableStatement callableStatement = null;

	        try {
	            // Get the connection
	            connection = getConnection();

	            if (connection != null) {
	                // Prepare the call to the stored procedure
	            	//String sql = "CALL transfer_funds(?, ?, ?, ?)";
	                String sql = "CALL transfer_funds(CAST(? AS INTEGER), CAST(? AS INTEGER), CAST(? AS NUMERIC), ?)";
	                callableStatement = connection.prepareCall(sql);

	                // Set input parameters
	                callableStatement.setInt(1, 5);  // Source Account ID
	                callableStatement.setInt(2, 8);  // Target Account ID
	                callableStatement.setDouble(3, 700.0); // Transfer Amount

	                // Register output parameter
	                callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);

	                // Execute the stored procedure
	                callableStatement.execute();

	                // Retrieve the output parameter value
	                String status = callableStatement.getString(4);
	                System.out.println("Transfer Status: " + status);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Closing resources
	            try {
	                if (callableStatement != null) callableStatement.close();
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Method to call the stored procedure for generating a statement
	    public void runGenerateStatementProcedure() {
	        Connection connection = null;
	        CallableStatement callableStatement = null;

	        try {
	            // Get the connection
	            connection = getConnection();

	            if (connection != null) {
	                // Prepare the call to the stored procedure
	                String sql = "CALL generate_statement(?, ?, ?, ?, ?)";
	                //String sql = "CALL generate_statement(?::integer, ?::integer, ?::integer, ?::numeric, ?::integer)";
	                //  explicitly cast the parameters when calling the stored procedure. 
	                //This approach is particularly useful when you want to make sure that PostgreSQL understands 
	                //the exact types of the parameters you're passing.

	                callableStatement = connection.prepareCall(sql);

	                // Set input parameters
	                callableStatement.setInt(1, 8);  // Account ID
	                callableStatement.setInt(2, 10);      // Month (August)
	                callableStatement.setInt(3, 2024);   // Year

	                // Register output parameters
	                callableStatement.registerOutParameter(4, java.sql.Types.NUMERIC);  // Total Balance
	                callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);  // Transaction Count

	                // Execute the stored procedure
	                callableStatement.execute();

	                // Retrieve the output parameters
	                BigDecimal totalBalance = callableStatement.getBigDecimal(4);
	                int transactionCount = callableStatement.getInt(5);

	                System.out.println("Total Balance: $" + totalBalance);
	                System.out.println("Transaction Count: " + transactionCount);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Closing resources
	            try {
	                if (callableStatement != null) callableStatement.close();
	                if (connection != null) connection.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
