import java.util.HashSet;
import java.util.TreeSet;


public class Ch35_SetInterfaces_Hashset_Treeset {

	public static void main(String[] args) {
        // HashSet Example
        hashSetExample();

        // TreeSet Example
        treeSetExample();
    }

    public static void hashSetExample() {
        // Creating a HashSet of cities
        HashSet<String> cities = new HashSet<>();

        // Adding elements to the HashSet
        cities.add("New York");
        cities.add("Los Angeles");
        cities.add("Chicago");
        cities.add("New York");  // Duplicate, will be ignored

        // Displaying elements (order is not guaranteed)
        System.out.println("HashSet - Cities: " + cities);  // Output order may vary

        // Checking if an element exists
        System.out.println("HashSet - Contains Los Angeles? " + cities.contains("Los Angeles"));

        // Removing an element
        cities.remove("Chicago");
        System.out.println("HashSet - After removal: " + cities);

        // Size of the HashSet
        System.out.println("HashSet - Number of cities: " + cities.size());
    }

    public static void treeSetExample() {
        // Creating a TreeSet of numbers
        TreeSet<Integer> numbers = new TreeSet<>();

        // Adding elements
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(40);

        // TreeSet stores elements in sorted order
        System.out.println("TreeSet - Sorted Set: " + numbers);  // Output: [10, 20, 30, 40]

        // Accessing first and last elements
        System.out.println("TreeSet - First Element: " + numbers.first());  // Output: 10
        System.out.println("TreeSet - Last Element: " + numbers.last());    // Output: 40

        // Finding elements lower and higher than a given value
        System.out.println("TreeSet - Element lower than 30: " + numbers.lower(30));  // Output: 20
        System.out.println("TreeSet - Element higher than 30: " + numbers.higher(30)); // Output: 40

        // Removing an element
        numbers.remove(20);
        System.out.println("TreeSet - After removal: " + numbers);  // Output: [10, 30, 40]
    }

}
