import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.charset.StandardCharsets;
public class Ch32_StringConversion_StringEncoding {

	public static void main(String[] args) {
		// 1. String Conversion: Converting Strings to Numbers
        System.out.println("---- String Conversion: Strings to Numbers ----");
        String amountString = "1000.50";
        double amount = Double.parseDouble(amountString); // Convert string to double

        String accountNumberString = "12345";
        int accountNumber = Integer.parseInt(accountNumberString); // Convert string to int

        System.out.println("Amount: " + amount); // Output: 1000.5
        System.out.println("Account Number: " + accountNumber); // Output: 12345

        // 2. String Conversion: Converting Numbers to Strings
        System.out.println("\n---- String Conversion: Numbers to Strings ----");
        double balance = 5000.75;
        String balanceString = Double.toString(balance); // Convert double to string

        int transactions = 15;
        String transactionsString = Integer.toString(transactions); // Convert int to string

        System.out.println("Balance: " + balanceString); // Output: 5000.75
        System.out.println("Number of Transactions: " + transactionsString); // Output: 15

        // 3. String Conversion: Converting Strings to Dates
        System.out.println("\n---- String Conversion: Strings to Dates ----");
        String dateString = "2024-09-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = formatter.parse(dateString); // Convert string to Date
            System.out.println("Date: " + date); // Output: Sun Sep 01 00:00:00 UTC 2024
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 4. String Conversion: Converting Dates to Strings
        System.out.println("\n---- String Conversion: Dates to Strings ----");
        Date currentDate = new Date(); // Get current date
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");

        String formattedDateString = dateFormatter.format(currentDate); // Convert Date to string
        System.out.println("Formatted Date: " + formattedDateString); // Output example: 26-09-2024

        // 5. String Encoding: Encoding Strings to Bytes
        System.out.println("\n---- String Encoding: Strings to Bytes ----");
        String customerName = "John Doe";

        // Encode string to UTF-8 and ISO-8859-1
        byte[] utf8Bytes = customerName.getBytes(StandardCharsets.UTF_8);
        byte[] isoBytes = customerName.getBytes(StandardCharsets.ISO_8859_1);

        System.out.println("UTF-8 Encoded: " + new String(utf8Bytes)); // Output: John Doe
        System.out.println("ISO-8859-1 Encoded: " + new String(isoBytes)); // Output: John Doe

        // 6. String Encoding: Decoding Bytes to Strings
        System.out.println("\n---- String Encoding: Bytes to Strings ----");
        byte[] utf8SampleBytes = {74, 111, 104, 110, 32, 68, 111, 101}; // UTF-8 byte array for "John Doe"
        String decodedString = new String(utf8SampleBytes, StandardCharsets.UTF_8); // Decode bytes to string

        System.out.println("Decoded String: " + decodedString); // Output: John Doe

	}

}
