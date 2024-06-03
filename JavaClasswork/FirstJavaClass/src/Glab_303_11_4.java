public class Glab_303_11_4 {
    // exampleOne.java
import java.util.HashSet;

    public class exampleOne {
        public static void main(String[] args) {
            HashSet<Integer> evenNumber = new HashSet<>();
            // Using add() method
            evenNumber.add(2);
            evenNumber.add(4);
            evenNumber.add(6);
            System.out.println("HashSet: " + evenNumber);

            HashSet<Integer> numbers = new HashSet<>();
            // Using addAll() method
            numbers.addAll(evenNumber);
            numbers.add(5);
            System.out.println("New HashSet: " + numbers);
        }
    }

}
// exampletwo.java
import java.util.HashSet;

public class exampletwo {
    public static void main(String[] args) {
        HashSet<Integer> evenNumbers = new HashSet<>();
        evenNumbers.add(2);
        evenNumbers.add(4);
        System.out.println("HashSet1: " + evenNumbers);

        HashSet<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(3);
        System.out.println("HashSet2: " + numbers);

        // Union of two sets
        numbers.addAll(evenNumbers);
        System.out.println("Union is: " + numbers);
    }
}
// examplethree.java
import java.util.HashSet;

public class examplethree {
    public static void main(String[] args) {
        HashSet<Integer> primeNumbers = new HashSet<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        System.out.println("HashSet1: " + primeNumbers);

        HashSet<Integer> oddNumbers = new HashSet<>();
        oddNumbers.add(1);
        oddNumbers.add(3);
        oddNumbers.add(5);
        System.out.println("HashSet2: " + oddNumbers);

        // Difference between HashSet1 and HashSet2
        primeNumbers.removeAll(oddNumbers);
        System.out.println("Difference : " + primeNumbers);
    }
}
// Examplefour.java
import java.util.HashSet;

public class Examplefour {
    public static void main(String args[]) {
        // HashSet declaration
        HashSet<String> hset = new HashSet<String>();

        // Adding elements to the HashSet
        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");

        // Addition of duplicate elements
        hset.add("Apple");
        hset.add("Mango");

        // Addition of null values
        hset.add(null);
        hset.add(null);

        // Using advanced for loop
        for (String str : hset) {
            System.out.println(" ---> " + str);
        }
    }
}
// TreesetExampleone.java
import java.util.TreeSet;
import java.util.Iterator;

public class TreesetExampleone {
    public static void main(String[] args) {
        TreeSet<Integer> num_Treeset = new TreeSet<>();
        num_Treeset.add(20);
        num_Treeset.add(5);
        num_Treeset.add(15);
        num_Treeset.add(25);
        num_Treeset.add(10);

        // Call iterator() method to define Iterator for TreeSet
        Iterator<Integer> iter_set = num_Treeset.iterator();
        System.out.print("TreeSet using Iterator: ");

        // Access TreeSet elements using Iterator
        while(iter_set.hasNext()) {
            System.out.print(iter_set.next());
            System.out.print(", ");
        }
    }
}
// TreesetExampletwo.java
import java.util.TreeSet;

public class TreesetExampletwo {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);

        System.out.println("TreeSet: " + numbers);

        // Using the remove() method
        boolean value1 = numbers.remove(5);
        System.out.println("Is 5 removed? " + value1);

        // Using the removeAll() method
        boolean value2 = numbers.removeAll(numbers);
        System.out.println("Are all elements removed? " + value2);
    }
}

