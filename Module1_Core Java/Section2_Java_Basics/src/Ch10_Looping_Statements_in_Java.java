
public class Ch10_Looping_Statements_in_Java {
public static void main(String[] args) {
        
        System.out.println("\n<==== for Loop Example ====>");
        // 'for' loop: Repeats the block of code a known number of times.
        // It has three parts: initialization (int i = 0), condition (i < 5), and update (i++).
        // This loop will run 5 times and print the iteration count.
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + i);  // Prints i from 0 to 4
        }

        System.out.println("\n<==== while Loop Example ====>");
        // 'while' loop: Repeats the block of code as long as the condition is true.
        // The condition (i < 5) is checked before each iteration.
        // The loop runs until the condition becomes false.
        int i = 0;
        while (i < 5) {
            System.out.println("Iteration " + i);  // Prints i from 0 to 4
            i++;  // Increment the loop variable
        }

        System.out.println("\n<==== do-while Loop Example ====>");
        // 'do-while' loop: Executes the block of code at least once, even if the condition is false.
        // The condition (j < 5) is checked after each iteration.
        int j = 0;
        do {
            System.out.println("Iteration " + j);  // Prints j from 0 to 4
            j++;
        } while (j < 5);

        System.out.println("\n<==== Enhanced for (for-each) Loop Example ====>");
        // Enhanced 'for' loop (for-each loop): Used for iterating over arrays and collections.
        // In this case, it iterates through each element in the 'numbers' array and prints it.
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println(num);  // Prints each number in the array
        }

        System.out.println("\n<==== break Statement Example ====>");
        // 'break' statement: Used to exit the loop entirely when a specific condition is met.
        // This loop prints values from 0 to 2, and exits the loop when k == 3.
        for (int k = 0; k < 10; k++) {
            if (k == 3) {
                break;  // Exit the loop when k == 3
            }
            System.out.println("Value: " + k);  // Prints 0, 1, 2
        }

        System.out.println("\n<==== continue Statement Example ====>");
        // 'continue' statement: Skips the current iteration and moves to the next one.
        // When l == 2, the 'continue' statement is triggered, skipping that iteration.
        for (int l = 0; l < 5; l++) {
            if (l == 2) {
                continue;  // Skip the iteration when l == 2
            }
            System.out.println("Value: " + l);  // Prints 0, 1, 3, 4 (skips 2)
        }
        
        System.out.println("\n<==== Infinite Loop Example (Stopped manually) ====>");
        // Example of an infinite loop: The condition is always true, so the loop runs forever.
        // Infinite loops are useful in certain scenarios like game loops or servers.
        // Uncomment the code below to run an infinite loop (Stopped manually).
        /*
        while (true) {
            System.out.println("This is an infinite loop.");
        }
        */
    }
}
