
public class Ch09_Conditional_Statements_in_Java {
	 public static void main(String[] args) {

	        System.out.println("\n<==== if Statement Example ====>");
	        // Simple if statement: It checks if a condition is true.
	        // If the condition is true, it executes the code inside the if block.
	        int number = 10;
	        if (number > 5) {
	            // This code block executes because the condition (number > 5) is true.
	            System.out.println("The number is greater than 5.");  // This will be printed
	        }

	        System.out.println("\n<==== if-else Statement Example ====>");
	        // if-else statement: It checks a condition.
	        // If the condition is true, it executes the 'if' block; otherwise, it executes the 'else' block.
	        if (number < 5) {
	            // This code block won't execute because the condition is false.
	            System.out.println("The number is less than 5.");
	        } else {
	            // This code block executes because the 'if' condition was false.
	            System.out.println("The number is not less than 5.");  // This will be printed
	        }

	        System.out.println("\n<==== if-else if-else Statement Example ====>");
	        // if-else if-else statement: It allows checking multiple conditions sequentially.
	        // The first true condition will have its block executed, and the remaining conditions are skipped.
	        if (number == 0) {
	            // This block won't be executed because the condition is false.
	            System.out.println("The number is zero.");
	        } else if (number > 0 && number <= 5) {
	            // This block won't be executed because the condition is false.
	            System.out.println("The number is between 1 and 5.");
	        } else if (number > 5 && number <= 10) {
	            // This block will be executed because the condition is true.
	            System.out.println("The number is between 6 and 10.");  // This will be printed
	        } else {
	            // This block won't be executed because one of the previous conditions was true.
	            System.out.println("The number is greater than 10.");
	        }

	        System.out.println("\n<==== switch Statement Example ====>");
	        // switch statement: It allows checking the value of a variable against multiple possible cases.
	        // The block corresponding to the matching case will be executed.
	        int day = 3;  // Representing Wednesday
	        switch (day) {
	            case 1:
	                // This block won't be executed because day is not 1.
	                System.out.println("Monday");
	                break;
	            case 2:
	                // This block won't be executed because day is not 2.
	                System.out.println("Tuesday");
	                break;
	            case 3:
	                // This block will be executed because day is 3.
	                System.out.println("Wednesday");  // This will be printed
	                break;
	            case 4:
	                // This block won't be executed because day is not 4.
	                System.out.println("Thursday");
	                break;
	            case 5:
	                // This block won't be executed because day is not 5.
	                System.out.println("Friday");
	                break;
	            default:
	                // This block will execute if none of the cases match, but it won't be reached here.
	                System.out.println("Weekend");
	        }

	        System.out.println("\n<==== Ternary Operator Example ====>");
	        // Ternary operator: It is a shorthand for a simple if-else condition.
	        // It returns one value if the condition is true, and another value if the condition is false.
	        int age = 20;
	        // Checks if age is greater than or equal to 18. If true, assigns "You are an adult."
	        // Otherwise, it assigns "You are a minor."
	        String message = (age >= 18) ? "You are an adult." : "You are a minor.";
	        System.out.println(message);  // "You are an adult." will be printed
	    }
	}

