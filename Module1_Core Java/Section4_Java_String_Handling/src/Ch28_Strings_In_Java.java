
public class Ch28_Strings_In_Java {

	public static void main(String[] args) {
		 // 1. Demonstrating String Immutability
        System.out.println("---- String Immutability Example ----");
        String greeting = "Hello";
        System.out.println("Original String: " + greeting); // Output: Hello

        String updatedGreeting = greeting.concat(", World!"); // Creates a new string
        System.out.println("Updated String: " + updatedGreeting); // Output: Hello, World!
        System.out.println("Original String remains unchanged: " + greeting); // Output: Hello


        // 2. String Pool Behavior
        System.out.println("\\n---- String Pool Example ----");
        String branch1 = "Main Branch";
        String branch2 = "Main Branch";  // Points to the same object in string pool
        String branch3 = new String("Main Branch");  // Creates a new object in heap

        System.out.println("branch1 == branch2: " + (branch1 == branch2));  // true (same reference in pool)
        System.out.println("branch1 == branch3: " + (branch1 == branch3));  // false (different objects)


        // 3. Using Common String Methods
        System.out.println("\\n---- String Methods Example ----");

        String accountNumber = "1234567890";

        // Length of the string
        int length = accountNumber.length();
        System.out.println("Account number length: " + length); // Output: 10

        // Extracting a substring (last 4 digits of account number)
        String lastFourDigits = accountNumber.substring(6);
        System.out.println("Last four digits: " + lastFourDigits); // Output: 7890

        // Changing case (to uppercase)
        String bankName = "global bank";
        System.out.println("Uppercase Bank Name: " + bankName.toUpperCase()); // Output: GLOBAL BANK

        // Replacing parts of a string
        String newBankName = bankName.replace("global", "national");
        System.out.println("Replaced Bank Name: " + newBankName); // Output: national bank


        // 4. Concatenation of Strings
        System.out.println("\\n---- String Concatenation Example ----");
        String firstName = "Alice";
        String lastName = "Smith";

        // Using '+' operator
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName);  // Output: Alice Smith

        // Using concat() method
        String welcomeMessage = "Welcome ".concat(fullName);
        System.out.println(welcomeMessage);  // Output: Welcome Alice Smith


        // 5. Comparing Strings (equals() vs ==)
        System.out.println("\\n---- String Comparison Example ----");

        String s1 = "Bank";
        String s2 = "Bank";
        String s3 = new String("Bank");

        // Using '==' operator (compares references)
        System.out.println("s1 == s2: " + (s1 == s2));  // true (same reference in string pool)
        System.out.println("s1 == s3: " + (s1 == s3));  // false (different objects in heap)

        // Using equals() method (compares actual content)
        System.out.println("s1.equals(s3): " + s1.equals(s3));  // true (content is the same)


	}

}
