public class Glab_303_11_5 {
    // TreesetExampletwo.java
import java.util.TreeSet;

    public class TreesetExampletwo {
        public static void main(String[] args) {
            TreeSet<Integer> numbers = new TreeSet<>();
            numbers.add(2);
            numbers.add(5);
            numbers.add(6);
            System.out.println("TreeSet: " + numbers);

            // Using the first() method
            int first = numbers.first();
            System.out.println("First Number: " + first);

            // Using the last() method
            int last = numbers.last();
            System.out.println("Last Number: " + last);
        }
    }

}
// cities_Comparator.java
import java.util.Comparator;

public class cities_Comparator implements Comparator<String> {
    // Override compare method to compare two elements of the TreeSet
    @Override
    public int compare(String cities_one, String cities_two) {
        int value = cities_one.compareTo(cities_two);
        // Sort elements in reverse order
        if (value > 0) {
            return -1;
        } else if (value < 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
// TreeSetExampleCom.java
import java.util.TreeSet;

public class TreeSetExampleCom {
    public static void main(String[] args) {
        // Create a TreeSet with user-defined comparator
        TreeSet<String> cities = new TreeSet<>(new cities_Comparator());
        // Add elements to the comparator
        cities.add("UAE");
        cities.add("Mumbai");
        cities.add("NewYork");
        cities.add("Hyderabad");
        cities.add("Karachi");
        cities.add("Xanadu");
        cities.add("Lahore");
        cities.add("Zagazig");
        cities.add("Yingkou");
        // Print the contents of TreeSet
        System.out.println("TreeSet: " + cities);
    }
}

