import java.util.ArrayList;
import java.util.LinkedList;

public class Ch34_ListInterfaces_ArrayList_LinkedList {

	public static void main(String[] args) {
        // ArrayList Example
        arrayListExample();

        // LinkedList Example
        linkedListExample();
    }

    public static void arrayListExample() {
        // Creating an ArrayList
        ArrayList<String> names = new ArrayList<>();

        // Adding elements to the ArrayList
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        // Accessing elements by index
        System.out.println("ArrayList - Element at index 1: " + names.get(1));  // Output: Jane

        // Modifying elements
        names.set(1, "Emily");

        // Iterating over the ArrayList
        System.out.println("ArrayList - Updated List:");
        for (String name : names) {
            System.out.println(name);
        }

        // Removing an element
        names.remove(2);
        System.out.println("ArrayList after removal: " + names);  // Output: [John, Emily]
    }

    public static void linkedListExample() {
        // Creating a LinkedList
        LinkedList<String> names = new LinkedList<>();

        // Adding elements to the LinkedList
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        // Adding an element at the beginning
        names.addFirst("Emily");

        // Adding an element at the end
        names.addLast("Mike");

        // Accessing elements
        System.out.println("LinkedList - First element: " + names.getFirst());  // Output: Emily
        System.out.println("LinkedList - Last element: " + names.getLast());    // Output: Mike

        // Removing elements from both ends
        names.removeFirst();
        names.removeLast();

        // Iterating over the LinkedList
        System.out.println("LinkedList - Updated List:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}