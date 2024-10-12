import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class Ch36_MapInterfaces_HashMap_TreeMap {

	public static void main(String[] args) {
        // HashMap Example
        hashMapExample();

        // TreeMap Example
        treeMapExample();
    }

    public static void hashMapExample() {
        // Creating a HashMap to store names and ages
        HashMap<String, Integer> ageMap = new HashMap<>();

        // Adding key-value pairs
        ageMap.put("John", 25);
        ageMap.put("Jane", 30);
        ageMap.put("Jack", 35);
        ageMap.put(null, 40);  // HashMap allows one null key
        ageMap.put("John", 28);  // Replaces the old value for the key "John"

        // Retrieving a value by key
        System.out.println("HashMap - Jane's age: " + ageMap.get("Jane"));  // Output: Jane's age: 30

        // Checking if a key exists
        System.out.println("HashMap - Contains key 'John'? " + ageMap.containsKey("John"));  // Output: true

        // Iterating over key-value pairs
        System.out.println("HashMap - Key-Value pairs:");
        for (HashMap.Entry<String, Integer> entry : ageMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Removing a key-value pair
        ageMap.remove("Jack");
        System.out.println("HashMap - After removal: " + ageMap);  // Output: After removal: {null=40, Jane=30, John=28}
    }

    public static void treeMapExample() {
        // Creating a TreeMap to store names and ages
        TreeMap<String, Integer> ageMap = new TreeMap<>();

        // Adding key-value pairs
        ageMap.put("John", 25);
        ageMap.put("Jane", 30);
        ageMap.put("Jack", 35);
        // TreeMap does not allow null keys
        // ageMap.put(null, 40);  // This will throw a NullPointerException

        // Retrieving a value by key
        System.out.println("TreeMap - Jane's age: " + ageMap.get("Jane"));  // Output: Jane's age: 30

        // Iterating over key-value pairs in sorted order by key
        System.out.println("TreeMap - Key-Value pairs in sorted order:");
        for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Retrieving the first and last entries
        System.out.println("TreeMap - First Entry: " + ageMap.firstEntry());  // Output: First Entry: Jack=35
        System.out.println("TreeMap - Last Entry: " + ageMap.lastEntry());    // Output: Last Entry: John=25

        // Removing a key-value pair
        ageMap.remove("Jack");
        System.out.println("TreeMap - After removal: " + ageMap);  // Output: After removal: {Jane=30, John=25}
    }
}
