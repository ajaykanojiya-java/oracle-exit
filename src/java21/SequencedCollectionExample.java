package java21;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class SequencedCollectionExample {
    public static void main(String[] args) {
        SequencedCollection<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Add elements at specific ends
        names.addFirst("Zara");
        names.addLast("David");

        System.out.println("Original List: " + names);
        System.out.println("First Element: " + names.getFirst());
        System.out.println("Last Element: " + names.getLast());

        // Remove from ends
        names.removeFirst();
        names.removeLast();
        System.out.println("After removing first & last: " + names);

        // Reversed view (no copy, just a view)
        SequencedCollection<String> reversed = names.reversed();
        System.out.println("Reversed view: " + reversed);
    }
}
