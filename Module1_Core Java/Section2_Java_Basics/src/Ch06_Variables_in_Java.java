public class Ch06_Variables_in_Java {

	public static void main(String[] args) {
		System.out.println("\n<==== Variable Declaration and Initialization ====>");
		
		// Declaration: Defining a variable without assigning a value yet.
		// The variable 'count_i' is declared but not initialized.
		int count_i;  
		
		// Uncommenting the following line will cause a compilation error because 'count_i' is not initialized.
		// System.out.println("count_i before Initlization\t: " + count_i); // it won't let you use 'count_i' without initialization
		
		// Initialization: Assigning a value to the variable after declaration.
		count_i = 5;  
		System.out.println("count_i after Initlization\t: " + count_i);  // Outputs 5
		
		// Declaration and Initialization in a single step: Defining and assigning a value in one line.
		int count_j = 15;  
		System.out.println("count_j value Initlization\t: " + count_j);  // Outputs 15
		
		// Reassigning a value: Updating the variable value by adding 10 to 'count_j'.
		count_j = count_j + 10;  
		System.out.println("count_j value after Reassign/update\t: " + count_j);  // Outputs 25
		
		System.out.println("\n<==== Final Variables ====>");
		
		// Using 'final' to declare a constant.
		// Once a final variable is initialized, its value cannot be changed.
		final int MAX_COUNT = 100;  
		
		// Uncommenting the following line will cause a compilation error because you cannot reassign a value to a final variable.
		// MAX_COUNT = 150; // it won't let you change final values
		
		// Using descriptive variable names improves code readability and maintainability.
		// 'numberOfStudents' is a descriptive variable name representing the number of students.
		int numberOfStudents = 30;  
		System.out.println("numberOfStudents value \t: " + numberOfStudents);  // Outputs 30
		
		// Demonstrating variable naming conventions:
		// Correct usage: Variables should start with a lowercase letter and follow camelCase.
		int totalAmount;  // Correct: variable starts with a lowercase letter
		
		// Incorrect usage: Variable names should not start with an uppercase letter.
		int TotalAmount;  // Incorrect: avoid starting variable names with an uppercase letter
		
		System.out.println("\n<==== Short Scoped Variables ====>");
		
		// Using a locally scoped variable 'i' within a loop.
		// 'i' is declared in the loop and is only accessible within the loop block.
		for (int i = 0; i < 10; i++) {  
			System.out.println("short scoped variables - value \t: " + i);  // Outputs values from 0 to 9
		}
		
		// Best practice: It is always good to initialize variables before using them in any operations.
		int sum = 0;  // Initializing 'sum' to 0 before using it later in the code
	}
}
