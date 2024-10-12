import java.util.ArrayList;

public class Ch12_Arrays_in_Java {
	public static void main(String[] args) {

        // <==== Single-Dimensional Array ====>
        System.out.println("Single-Dimensional Array:");
        // Declaring and initializing a single-dimensional array with 5 elements
        int[] numbers = {10, 20, 30, 40, 50};

        // Accessing an element from the single-dimensional array using index
        System.out.println("Element at index 2: " + numbers[2]);  // Output: 30

        // Iterating over the single-dimensional array and printing each element
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }

        // <==== Two-Dimensional Array (2D Array) ====>
        System.out.println("\nTwo-Dimensional Array:");
        // Declaring and initializing a 2D array (matrix) with 3 rows and 3 columns
        int[][] matrix = {
            {1, 2, 3},  // Row 0
            {4, 5, 6},  // Row 1
            {7, 8, 9}   // Row 2
        };

        // Accessing an element from the 2D array (row 1, column 2)
        System.out.println("Element at row 1, column 2: " + matrix[1][2]);  // Output: 6

        // Iterating over the 2D array and printing each element
        // Outer loop iterates over the rows, inner loop iterates over the columns
        for (int i = 0; i < matrix.length; i++) {  // Loop over rows
            for (int j = 0; j < matrix[i].length; j++) {  // Loop over columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();  // Move to the next line after printing each row
        }

        // <==== Three-Dimensional Array (3D Array) ====>
        System.out.println("\nThree-Dimensional Array:");
        // Declaring and initializing a 3D array with dimensions 2x3x4
        int[][][] threeDArray = new int[2][3][4];  // A 2x3x4 3D array

        // Assigning values to the 3D array at a specific location [1][2][3]
        threeDArray[1][2][3] = 100;

        // Accessing an element from the 3D array (at [1][2][3])
        System.out.println("Element at [1][2][3]: " + threeDArray[1][2][3]);  // Output: 100

        // <==== Dynamic Array (ArrayList) ====>
        System.out.println("\nDynamic Array using ArrayList:");
        // Declaring a dynamic array using ArrayList (can grow and shrink dynamically)
        ArrayList<Integer> dynamicArray = new ArrayList<>();

        // Adding elements to the ArrayList
        dynamicArray.add(10);  // Adds 10 to the ArrayList
        dynamicArray.add(20);  // Adds 20 to the ArrayList
        dynamicArray.add(30);  // Adds 30 to the ArrayList

        // Removing an element from the ArrayList (removes the element at index 1, which is 20)
        dynamicArray.remove(1);  // Removes element 20 from the ArrayList

        // Printing the elements of the ArrayList after removal
        System.out.println("Elements in ArrayList: " + dynamicArray);  // Output: [10, 30]

        // Iterating over the ArrayList using a for-each loop and printing each element
        for (int element : dynamicArray) {
            System.out.println("ArrayList element: " + element);
        }
    }
}
