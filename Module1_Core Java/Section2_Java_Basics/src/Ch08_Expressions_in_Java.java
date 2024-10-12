
public class Ch08_Expressions_in_Java {
	
	public static void main(String[] args) {

        System.out.println("\n<==== Arithmetic Expressions ====>");
        // Arithmetic expressions: Perform mathematical operations
        int a = 5, b = 3;
        int sum = a + b;  // Addition of a and b
        int product = a * b;  // Multiplication of a and b
        System.out.println("Sum of a and b: " + sum);  // Outputs 8
        System.out.println("Product of a and b: " + product);  // Outputs 15

        System.out.println("\n<==== Relational Expressions ====>");
        // Relational expressions: Compare two values and return boolean results
        int x = 10, y = 5;
        boolean isGreater = x > y;  // Checks if x is greater than y
        boolean isEqual = x == y;  // Checks if x is equal to y
        System.out.println("Is x greater than y? " + isGreater);  // true
        System.out.println("Is x equal to y? " + isEqual);  // false

        System.out.println("\n<==== Logical Expressions ====>");
        // Logical expressions: Combine boolean values using logical operators
        boolean condition1 = true, condition2 = false;
        boolean logicalAnd = condition1 && condition2;  // Logical AND
        boolean logicalOr = condition1 || condition2;  // Logical OR
        System.out.println("Logical AND result: " + logicalAnd);  // false
        System.out.println("Logical OR result: " + logicalOr);  // true

        System.out.println("\n<==== Assignment Expressions ====>");
        // Assignment expressions: Assign values to variables
        int c = 10;  // Simple assignment of 10 to c
        c += 5;  // Compound assignment: Adds 5 to c (equivalent to c = c + 5)
        System.out.println("Updated value of c: " + c);  // Outputs 15

        System.out.println("\n<==== Conditional (Ternary) Expressions ====>");
        // Conditional (ternary) expressions: Short form for if-else statements
        int max = (a > b) ? a : b;  // If a is greater than b, assign a to max; otherwise, assign b
        System.out.println("Max of a and b: " + max);  // Outputs 5

        System.out.println("\n<==== Bitwise Expressions ====>");
        // Bitwise expressions: Perform bit-level operations
        int bitwiseAnd = a & b;  // Bitwise AND between a and b
        int bitwiseOr = a | b;  // Bitwise OR between a and b
        System.out.println("Bitwise AND of a and b: " + bitwiseAnd);  // Outputs 1 (binary AND result)
        System.out.println("Bitwise OR of a and b: " + bitwiseOr);  // Outputs 7 (binary OR result)

        System.out.println("\n<==== Cast Expressions ====>");
        // Cast expressions: Convert one data type to another
        double d = 9.8;
        int intValue = (int) d;  // Casting double to int (truncates the decimal part)
        System.out.println("Cast double to int: " + intValue);  // Outputs 9

        System.out.println("\n<==== Instanceof Expressions ====>");
        // Instanceof expressions: Check if an object is an instance of a specific class
        String str = "Hello, World!";
        boolean isString = str instanceof String;  // Checks if str is an instance of the String class
        System.out.println("Is str an instance of String? " + isString);  // Outputs true

        System.out.println("\n<==== Array Access Expressions ====>");
        // Array access expressions: Access elements of an array using indices
        int[] arr = {10, 20, 30};
        int secondElement = arr[1];  // Accessing the second element of the array (index starts from 0)
        System.out.println("Second element of the array: " + secondElement);  // Outputs 20

        System.out.println("\n<==== Method Call Expressions ====>");
        // Method call expressions: Call methods to perform an action and return a result
        int maxResult = Math.max(a, b);  // Calls the Math.max method to find the maximum of a and b
        System.out.println("Max of a and b using Math.max: " + maxResult);  // Outputs 5

        System.out.println("\n<==== New Object Expressions ====>");
        // New object expressions: Create new objects or arrays using the 'new' keyword
        String newStr = new String("Hello, Java!");  // Creates a new String object
        int[] newArr = new int[5];  // Creates a new integer array with 5 elements
        System.out.println("New String object: " + newStr);  // Outputs "Hello, Java!"
        System.out.println("New integer array length: " + newArr.length);  // Outputs 5
    }
}
