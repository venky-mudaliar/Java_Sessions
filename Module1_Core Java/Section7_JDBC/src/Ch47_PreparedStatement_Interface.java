
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ch47_PreparedStatement_Interface {
	public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection to the PostgreSQL database
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");

            // Perform operations in sequence

            // 1. Deposit money to an account
            depositToAccount(connection);

            // 2. Update customer email
            updateCustomerEmail(connection);

            // 3. Validate user login credentials
            validateUserLogin(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method to deposit money to an account
    public static void depositToAccount(Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the query
            preparedStatement.setDouble(1, 500.0);  // Deposit amount
            preparedStatement.setInt(2, 6);     // Account ID

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method to update customer email
    public static void updateCustomerEmail(Connection connection) {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE customers SET email = ? WHERE customer_id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the query
            preparedStatement.setString(1, "rohan.kumarnew@example.com"); // New email address
            preparedStatement.setInt(2, 7);                     // Customer ID

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Customer information updated successfully.");
            } else {
                System.out.println("Customer not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method to validate user login
    public static void validateUserLogin(Connection connection) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters for the query
            preparedStatement.setString(1, "amit_sharma");  // Username
            preparedStatement.setString(2, "password123"); // Password

            // Execute the query and get the ResultSet
            resultSet = preparedStatement.executeQuery();

            // Process the result
            if (resultSet.next()) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}