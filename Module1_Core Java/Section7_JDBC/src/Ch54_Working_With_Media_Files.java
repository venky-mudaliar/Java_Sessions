import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Ch54_Working_With_Media_Files {
	public static void main(String[] args) {
		Ch54_Working_With_Media_Files system = new Ch54_Working_With_Media_Files();
        
        // Inserting customer with profile picture
        system.insertCustomerWithProfilePicture();
        
        // Retrieving customer profile picture
        system.retrieveCustomerProfilePicture();
        
        // Inserting document for a customer
        system.insertCustomerDocument();
        
        // Retrieving document of a customer
        system.retrieveCustomerDocument();
    }

    // Method to insert a customer with a profile picture
    public void insertCustomerWithProfilePicture() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            // SQL query to insert a customer with a profile picture
            String sql = "INSERT INTO customers (first_name, last_name, email, profile_picture) VALUES (?, ?, ?, ?)";

            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);

            // Set customer details
            preparedStatement.setString(1, "John");
            preparedStatement.setString(2, "Doe");
            preparedStatement.setString(3, "john.doe@example.com");

            // Read the image file as InputStream
            InputStream inputStream = new FileInputStream("path/to/profile_picture.jpg");

            // Set the profile picture as BYTEA
            preparedStatement.setBinaryStream(4, inputStream);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer with profile picture inserted successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement, null);
        }
    }

    // Method to retrieve a customer's profile picture
    public void retrieveCustomerProfilePicture() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            // SQL query to retrieve the profile picture
            String sql = "SELECT profile_picture FROM customers WHERE customer_id = ?";

            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1); // Assuming customer_id = 1

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result is found
            if (resultSet.next()) {
                InputStream inputStream = resultSet.getBinaryStream("profile_picture");
                OutputStream outputStream = new FileOutputStream("output/profile_picture.jpg");

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("Profile picture retrieved and saved to disk.");
                outputStream.close();
            } else {
                System.out.println("Profile picture not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
    }

    // Method to insert a document for a customer
    public void insertCustomerDocument() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            // SQL query to insert a PDF document
            String sql = "UPDATE customers SET document = ? WHERE customer_id = ?";

            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);

            // Read the PDF file as InputStream
            InputStream inputStream = new FileInputStream("path/to/document.pdf");

            // Set the PDF file as BYTEA
            preparedStatement.setBinaryStream(1, inputStream);
            preparedStatement.setInt(2, 1); // Assuming customer_id = 1

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer document stored successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement, null);
        }
    }

    // Method to retrieve a document of a customer
    public void retrieveCustomerDocument() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();

            // SQL query to retrieve the document
            String sql = "SELECT document FROM customers WHERE customer_id = ?";

            // Create a PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1); // Assuming customer_id = 1

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if a result is found
            if (resultSet.next()) {
                InputStream inputStream = resultSet.getBinaryStream("document");
                OutputStream outputStream = new FileOutputStream("output/document.pdf");

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                System.out.println("Document retrieved and saved to disk.");
                outputStream.close();
            } else {
                System.out.println("Document not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
    }

    // Method to establish connection to the PostgreSQL database
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bankdatabase", "postgres", "lazycoffee");
            System.out.println("Connection established successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close resources
    public void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}