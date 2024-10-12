
public class Ch30_String_Manipulation {

	public static void main(String[] args) {
		// 1. Concatenation
        System.out.println("---- String Concatenation ----");
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;

        String accountNumber = "SA12345";
        String transactionType = "Deposit";
        String message = "Customer " + fullName + " has made a " + transactionType + " to account " + accountNumber;
        System.out.println(message);  // Output: Customer John Doe has made a Deposit to account SA12345

        // 2. Replacement
        System.out.println("\n---- String Replacement ----");
        String maskedAccountNumber = accountNumber.replace("12345", "*****");
        String transactionDescription = "Withdrawal of $500";
        String updatedDescription = transactionDescription.replace("Withdrawal", "Deposit");

        System.out.println("Masked Account Number: " + maskedAccountNumber);  // Output: SA*****
        System.out.println("Updated Description: " + updatedDescription);  // Output: Deposit of $500

        // 3. Case Conversion
        System.out.println("\n---- Case Conversion ----");
        String upperCaseName = fullName.toUpperCase();
        String lowerCaseName = fullName.toLowerCase();

        System.out.println("Uppercase Name: " + upperCaseName);  // Output: JOHN DOE
        System.out.println("Lowercase Name: " + lowerCaseName);  // Output: john doe

        // 4. Trimming
        System.out.println("\n---- String Trimming ----");
        String nameWithSpaces = "   John Doe   ";
        String trimmedName = nameWithSpaces.trim();

        System.out.println("Original Name: '" + nameWithSpaces + "'");  // Output: '   John Doe   '
        System.out.println("Trimmed Name: '" + trimmedName + "'");  // Output: 'John Doe'

        // 5. Substring Extraction
        System.out.println("\n---- Substring Extraction ----");
        String accountType = accountNumber.substring(0, 2);  // Extracts "SA"
        String accountIdentifier = accountNumber.substring(2);  // Extracts "12345"

        System.out.println("Account Type: " + accountType);  // Output: SA
        System.out.println("Account Identifier: " + accountIdentifier);  // Output: 12345

        // 6. Searching
        System.out.println("\n---- Searching Within Strings ----");
        int indexOfAccount = transactionDescription.indexOf("SA12345");
        boolean containsDeposit = transactionDescription.contains("Deposit");

        System.out.println("Index of Account Number: " + indexOfAccount);  // Output: -1 (not found)
        System.out.println("Contains 'Deposit'? " + containsDeposit);  // Output: false

        // 7. Splitting
        System.out.println("\n---- Splitting Strings ----");
        String transactionRecord = "SA12345,Deposit,500.00";
        String[] details = transactionRecord.split(",");

        String splitAccountNumber = details[0];
        String splitTransactionType = details[1];
        String splitAmount = details[2];

        System.out.println("Account Number: " + splitAccountNumber);  // Output: SA12345
        System.out.println("Transaction Type: " + splitTransactionType);  // Output: Deposit
        System.out.println("Amount: " + splitAmount);  // Output: 500.00

        // 8. Joining
        System.out.println("\n---- Joining Strings ----");
        String[] accountDetails = {"SA12345", "John Doe", "5000.00"};
        String csvRecord = String.join(",", accountDetails);

        System.out.println("CSV Record: " + csvRecord);  // Output: SA12345,John Doe,5000.00

        // 9. Formatting
        System.out.println("\n---- String Formatting ----");
        double balance = 5000.00;
        String accountSummary = String.format("Account Summary for %s: Account Number: %s, Balance: $%.2f",
                                              fullName, accountNumber, balance);

        System.out.println(accountSummary);  // Output: Account Summary for John Doe: Account Number: SA12345, Balance: $5000.00
    }

}
