
public class Ch11_Branching_Statements_in_Java {
	public static void main(String[] args) {

		System.out.println("\n<==== break Statement in a Loop ====>");
		// 'break' statement in a loop:
		// This loop prints numbers from 0 to 4, but when the value of 'i' reaches 5,
		// the 'break' statement exits the loop, so the loop doesn't complete all 10
		// iterations.
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				break; // Exit the loop when i equals 5
			}
			System.out.println("Iteration: " + i); // Prints i from 0 to 4
		}

		System.out.println("\n<==== break Statement in a switch ====>");
		// 'break' statement in a switch statement:
		// This switch case checks the value of 'day'. When 'day' equals 3,
		// it prints "Wednesday" and then the 'break' statement prevents the code from
		// falling through to other cases.
		int day = 3;
		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday"); // This will be printed
			break; // Exits the switch block after the matching case is executed
		default:
			System.out.println("Invalid day");
		}

		System.out.println("\n<==== continue Statement in a Loop ====>");
		// 'continue' statement in a loop:
		// This loop prints numbers from 0 to 4, but skips printing when 'i' equals 2.
		// The 'continue' statement causes the loop to jump to the next iteration,
		// skipping the current iteration.
		for (int i = 0; i < 5; i++) {
			if (i == 2) {
				continue; // Skip the iteration when i equals 2
			}
			System.out.println("Iteration: " + i); // Prints 0, 1, 3, 4 (skips 2)
		}

		System.out.println("\n<==== return Statement in a void Method ====>");
		// 'return' statement in a void method:
		// This method checks whether the number is negative or positive. If the number
		// is negative,
		// the 'return' statement exits the method early, skipping the rest of the code
		// in the method.
		checkNumber(5); // The number is positive: 5
		checkNumber(-3); // No output, method returns early due to negative number

		System.out.println("\n<==== return Statement with Value ====>");
		// 'return' statement with a value:
		// This method takes two integers as input, adds them, and returns the result to
		// the caller.
		// The result is printed in the main method after calling the 'addNumbers'
		// method.
		int result = addNumbers(10, 20); // Call the method and store the returned value
		System.out.println("The sum of 10 and 20 is: " + result); // Prints 30
	}

	// Example of a 'return' statement in a void method:
	// This method checks whether the input number is positive or negative.
	// If the number is negative, it returns early and does not execute the
	// remaining code.
	public static void checkNumber(int num) {
		if (num < 0) {
			return; // Exits the method early if the number is negative
		}
		System.out.println("The number is positive: " + num); // Prints the positive number
	}

	// Example of a 'return' statement with a value:
	// This method takes two integers as input, adds them together, and returns the
	// result.
	public static int addNumbers(int a, int b) {
		return a + b; // Returns the sum of a and b
	}
}
