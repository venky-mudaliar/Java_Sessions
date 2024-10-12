import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Ch38_Comparable_Comparator {
	public static void main(String[] args) {
        // Creating a list of MyClass objects
        List<MyClass> list = new ArrayList<>();
        list.add(new MyClass(3, "Charlie"));
        list.add(new MyClass(1, "Alice"));
        list.add(new MyClass(2, "Bob"));

        // Sorting the list using Comparable (sort by id)
        System.out.println("Sorting by ID using Comparable:");
        Collections.sort(list);  // Sort by id using Comparable
        for (MyClass item : list) {
            System.out.println(item);
        }

        // Sorting the list using Comparator (sort by name)
        System.out.println("\nSorting by Name using Comparator:");
        Collections.sort(list, MyClass.compareByName);  // Sort by name using Comparator
        for (MyClass item : list) {
            System.out.println(item);
        }
    }
}

// MyClass implementing Comparable to sort by id
class MyClass implements Comparable<MyClass> {
    private int id;
    private String name;

    public MyClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Implementing the compareTo method to sort by id
    @Override
    public int compareTo(MyClass other) {
        return Integer.compare(this.id, other.id);
    }

    // Comparator to sort by name
    public static Comparator<MyClass> compareByName = new Comparator<MyClass>() {
        @Override
        public int compare(MyClass o1, MyClass o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
