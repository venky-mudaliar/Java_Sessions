import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Ch37_Iterators_ForEachLoop {

	public static void main(String[] args) {
        // Example with LinkedList and ListIterator
        listIteratorExample();

        // Example with ArrayList and For-each loop
        forEachExample();
    }

    public static void listIteratorExample() {
        // Create a linked list
        List<String> names = new LinkedList<>();
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        // Create a ListIterator for the list
        ListIterator<String> listIterator = names.listIterator();

        // Forward traversal
        System.out.println("ListIterator - Forward traversal:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // Backward traversal
        System.out.println("ListIterator - Backward traversal:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    public static void forEachExample() {
        // Create an ArrayList
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Jack");

        // Iterate using for-each loop
        System.out.println("For-each loop - Traversal:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}