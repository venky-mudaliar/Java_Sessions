
public class Ch07_Operators_in_Java {
	 public static void main(String[] args) {

	        System.out.println("\n<==== Arithmetic Operators ====>");
	        // Arithmetic operators are used for basic mathematical operations.
	        int a = 10, b = 5;
	        System.out.println("Addition (a + b): " + (a + b));  // Adds a and b
	        System.out.println("Subtraction (a - b): " + (a - b));  // Subtracts b from a
	        System.out.println("Multiplication (a * b): " + (a * b));  // Multiplies a and b
	        System.out.println("Division (a / b): " + (a / b));  // Divides a by b (integer division)
	        System.out.println("Modulus (a % b): " + (a % b));  // Remainder of a divided by b

	        System.out.println("\n<==== Assignment Operators ====>");
	        // Assignment operators assign values to variables.
	        int c = 10;  // Assigns 10 to c
	        System.out.println("Initial value of c: " + c);
	        c += 5;  // Equivalent to c = c + 5
	        System.out.println("After c += 5: " + c);  // Outputs 15
	        c *= 2;  // Equivalent to c = c * 2
	        System.out.println("After c *= 2: " + c);  // Outputs 30

	        System.out.println("\n<==== Relational (Comparison) Operators ====>");
	        // Relational operators compare two values and return a boolean result.
	        System.out.println("a == b: " + (a == b));  // Checks if a is equal to b (false)
	        System.out.println("a != b: " + (a != b));  // Checks if a is not equal to b (true)
	        System.out.println("a > b: " + (a > b));  // Checks if a is greater than b (true)
	        System.out.println("a < b: " + (a < b));  // Checks if a is less than b (false)
	        System.out.println("a >= b: " + (a >= b));  // Checks if a is greater than or equal to b (true)
	        System.out.println("a <= b: " + (a <= b));  // Checks if a is less than or equal to b (false)

	        System.out.println("\n<==== Logical Operators ====>");
	        // Logical operators combine multiple boolean expressions.
	        boolean x = true, y = false;
	        System.out.println("x && y: " + (x && y));  // Logical AND: true if both x and y are true
	        System.out.println("x || y: " + (x || y));  // Logical OR: true if either x or y is true
	        System.out.println("!x: " + (!x));  // Logical NOT: inverts the value of x (false)

	        System.out.println("\n<==== Unary Operators ====>");
	        // Unary operators operate on a single operand.
	        int d = 5;
	        System.out.println("Initial value of d: " + d);  // d starts as 5
	        d++;  // Increments d by 1 (equivalent to d = d + 1)
	        System.out.println("After d++: " + d);  // Outputs 6
	        d--;  // Decrements d by 1 (equivalent to d = d - 1)
	        System.out.println("After d--: " + d);  // Outputs 5
	        System.out.println("Unary minus (-d): " + (-d));  // Negates the value of d (-5)

	        System.out.println("\n<==== Bitwise Operators ====>");
	        // Bitwise operators work at the bit level of integers.
	        int e = 6, f = 4;  // 6 = 110, 4 = 100 in binary
	        System.out.println("e & f (bitwise AND): " + (e & f));  // Bitwise AND (110 & 100 = 100 -> 4)
	        System.out.println("e | f (bitwise OR): " + (e | f));  // Bitwise OR (110 | 100 = 110 -> 6)
	        System.out.println("e ^ f (bitwise XOR): " + (e ^ f));  // Bitwise XOR (110 ^ 100 = 010 -> 2)
	        System.out.println("~e (bitwise NOT): " + (~e));  // Bitwise NOT (~110 = 001 -> -7 in two's complement)

	        System.out.println("\n<==== Ternary Operator ====>");
	        // The ternary operator is a shorthand for if-else conditions.
	        int g = (a > b) ? a : b;  // If a is greater than b, assign a to g; otherwise, assign b
	        System.out.println("Ternary result (larger of a and b): " + g);  // Outputs 10 (a is greater than b)

	        System.out.println("\n<==== Shift Operators ====>");
	        // Shift operators shift bits to the left or right.
	        int h = 8;  // Binary representation: 1000
	        System.out.println("h << 1 (left shift): " + (h << 1));  // Shifts bits of h left by 1 (10000 -> 16)
	        System.out.println("h >> 1 (right shift): " + (h >> 1));  // Shifts bits of h right by 1 (0100 -> 4)
	        System.out.println("h >>> 1 (unsigned right shift): " + (h >>> 1));  // Unsigned right shift (0100 -> 4)

	        System.out.println("\n<==== Instanceof Operator ====>");
	        // The instanceof operator checks if an object is of a specific class type.
	        String str = "Hello, World!";
	        boolean result = str instanceof String;  // Returns true if str is an instance of the String class
	        System.out.println("Is str an instance of String? " + result);  // Outputs true
	    }
}
