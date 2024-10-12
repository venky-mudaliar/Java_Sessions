
public class Ch29_Basic_String_Functions {

	public static void main(String[] args) {
		// 1. Demonstrating String Length
        System.out.println("---- String Length Example ----");
        String accountNumber = "SA12345";
        int length = accountNumber.length();
        System.out.println("Account Number Length: " + length);  // Output: 7

        // 2. Demonstrating Character Extraction
        System.out.println("\n---- Character Extraction Example ----");
        char accountTypePrefix = accountNumber.charAt(0);  // Gets the first character
        System.out.println("Account Type Prefix: " + accountTypePrefix);  // Output: S

        // 3. Demonstrating Substring Extraction
        System.out.println("\n---- Substring Extraction Example ----");
        String identifier = accountNumber.substring(2);  // Extracts from index 2 onwards
        System.out.println("Account Identifier: " + identifier);  // Output: 12345

        // 4. Demonstrating String Comparison
        System.out.println("\n---- String Comparison Example ----");
        String accountType1 = "Savings";
        String accountType2 = "savings";
        
        boolean isEqual = accountType1.equals(accountType2);  // Case-sensitive comparison
        boolean isEqualIgnoreCase = accountType1.equalsIgnoreCase(accountType2);  // Case-insensitive comparison
        int comparisonResult = accountType1.compareTo(accountType2);

        System.out.println("Are account types equal? " + isEqual);  // Output: false
        System.out.println("Are account types equal (ignore case)? " + isEqualIgnoreCase);  // Output: true
        System.out.println("Comparison result: " + comparisonResult);  // Output: negative number

        // 5. Demonstrating Searching Within Strings
        System.out.println("\n---- Searching Within Strings Example ----");
        String transactionDescription = "Deposit of $500 into account SA12345";
        
        int indexOfAccount = transactionDescription.indexOf("SA12345");
        int indexOfLastOf = transactionDescription.lastIndexOf("of");

        System.out.println("Index of Account Number: " + indexOfAccount);  // Output: 28
        System.out.println("Index of Last 'of': " + indexOfLastOf);  // Output: 12

        // 6. Demonstrating String Concatenation
        System.out.println("\n---- String Concatenation Example ----");
        String customerName = "John Doe";
        String message = "Customer " + customerName + " has account number " + accountNumber;
        String welcomeMessage = "Welcome, ".concat(customerName).concat("!");

        System.out.println("Message: " + message);
        System.out.println("Welcome Message: " + welcomeMessage);

        // 7. Demonstrating String Modification
        System.out.println("\n---- String Modification Example ----");
        String nameWithSpaces = "   John Doe   ";
        String cleanName = nameWithSpaces.trim();  // Removes leading and trailing spaces
        String upperCaseName = cleanName.toUpperCase();  // Converts to uppercase
        String lowerCaseName = cleanName.toLowerCase();  // Converts to lowercase
        String maskedAccount = accountNumber.replace("12345", "*****");  // Replaces part of the string

        System.out.println("Clean Name: '" + cleanName + "'");
        System.out.println("Uppercase Name: " + upperCaseName);
        System.out.println("Lowercase Name: " + lowerCaseName);
        System.out.println("Masked Account: " + maskedAccount);

        // 8. Demonstrating Splitting Strings
        System.out.println("\n---- Splitting Strings Example ----");
        String transactionRecord = "SA12345,Deposit,500.00";
        String[] details = transactionRecord.split(",");

        String splitAccountNumber = details[0];
        String transactionType = details[1];
        String amount = details[2];

        System.out.println("Account Number: " + splitAccountNumber);
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);

        // 9. Demonstrating Joining Strings
        System.out.println("\n---- Joining Strings Example ----");
        String[] accountDetails = {"SA12345", "John Doe", "5000.00"};
        String csvRecord = String.join(",", accountDetails);

        System.out.println("CSV Record: " + csvRecord);  // Output: SA12345,John Doe,5000.00
    }

}
