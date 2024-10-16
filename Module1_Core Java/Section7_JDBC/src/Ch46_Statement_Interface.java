import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ch46_Statement_Interface {
	public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection to the PostgreSQL database
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");

            // 1. Retrieve account balance
            retrieveAccountBalance(connection);

            // 2. Deposit $500 into account
            depositToAccount(connection);

            // 3. Retrieve transaction history
            retrieveTransactionHistory(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method to retrieve account balance
    public static void retrieveAccountBalance(Connection connection) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Create a Statement object
            statement = connection.createStatement();

            // SQL query to retrieve account balance
            String sql = "SELECT balance FROM accounts WHERE account_id = 8";

            // Execute the query and get the result
            resultSet = statement.executeQuery(sql);

            // Process the result
            if (resultSet.next()) {
                double balance = resultSet.getDouble("balance");
                System.out.println("Account Balance: $" + balance);
            } else {
                System.out.println("Account not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method to deposit $500 into the account
    public static void depositToAccount(Connection connection) {
        Statement statement = null;

        try {
            // Create a Statement object
            statement = connection.createStatement();

            // SQL query to update account balance by depositing $500
            String sql = "UPDATE accounts SET balance = balance + 500 WHERE account_id = 8";
            

            // Execute the update
            int rowsAffected = statement.executeUpdate(sql);

            if (rowsAffected > 0) {
                System.out.println("Deposit successful.");
                retrieveAccountBalance(connection);
                String transationInsertQuery = "INSERT INTO TRANSACTIONS(account_id, amount) VALUES (8, 500.00)";
                int rowsAffectedInsertTransaction = statement.executeUpdate(transationInsertQuery);
           
            } else {
                System.out.println("Account not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method to retrieve transaction history
    public static void retrieveTransactionHistory(Connection connection) {
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Create a Statement object
            statement = connection.createStatement();

            // SQL query to retrieve transaction history
            String sql = "SELECT transaction_id, amount, transaction_date FROM transactions WHERE account_id = 8 ORDER BY transaction_date DESC";

            // Execute the query and get the result
            resultSet = statement.executeQuery(sql);

            // Process the result
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transaction_id");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("transaction_date");

                System.out.println("Transaction ID: " + transactionId + ", Amount: $" + amount + ", Date: " + date);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
