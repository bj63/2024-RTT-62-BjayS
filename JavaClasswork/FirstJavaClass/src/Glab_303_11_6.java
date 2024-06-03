import java.util.HashMap;

public class Glab_303_11_6 {
        public static void main(String[] args) {

            HashMap<Integer, String> languages = new HashMap<>();
            languages.put(1, "Java");
            languages.put(2, "Python");
            languages.put(3, "JavaScript");
            languages.put(4, "C Sharp");

            System.out.println("HashMap: " + languages);

            // remove element associated with key 2
            String value = languages.remove(2);
            System.out.println("Removed value: " + value);
            System.out.println("Updated HashMap: " + languages);
        }
    }

// Example Two: Create HashMap and Remove HashMap Elements
import java.util.HashMap;

    public class ExampleTwoHashMap {
        public static void main(String[] args) {
            HashMap<String, String> newHashMap = new HashMap<>();
            // Addition of key and value
            newHashMap.put("Key1", "Lenovo");
            newHashMap.put("Key2", "Motorola");
            newHashMap.put("Key3", "Nokia");
            newHashMap.put("Key4", null);
            newHashMap.put(null, "Sony");
            System.out.println("Original map contains:" + newHashMap);
            // getting size of HashMap
            System.out.println("Size of original Map is:" + newHashMap.size());
            // copy contents of one HashMap to another
            HashMap<String, String> copyHashMap = new HashMap<>();
            copyHashMap.putAll(newHashMap);
            System.out.println("copyHashMap mappings= " + copyHashMap);
            // Removal of null key
            String nullKeyValue = copyHashMap.remove(null);
            System.out.println("copyHashMap null key value = " + nullKeyValue);
            System.out.println("copyHashMap after removing null key = " + copyHashMap);
            System.out.println("Size of copyHashMap is:" + copyHashMap.size());
        }
    }

// Example One: Remove TreeMap Elements
import java.util.TreeMap;

    public class ExampleTreemapOne {
        public static void main(String[] args) {

            TreeMap<String, Integer> numbers = new TreeMap<>();
            numbers.put("One", 1);
            numbers.put("Two", 2);
            numbers.put("Three", 3);
            System.out.println("TreeMap: " + numbers);

            // remove method with single parameter
            int value = numbers.remove("Two");
            System.out.println("Removed value: " + value);

            // remove method with two parameters
            boolean result = numbers.remove("Three", 3);
            System.out.println("Is the entry {Three=3} removed? " + result);
            System.out.println("Updated TreeMap: " + numbers);
        }
    }

// Example Two: Methods for Navigation
import java.util.TreeMap;

    public class ExampleTreemapTwo {
        public static void main(String[] args) {
            TreeMap<String, Integer> numbers = new TreeMap<>();
            numbers.put("First", 1);
            numbers.put("Second", 2);
            numbers.put("Third", 3);
            System.out.println("TreeMap: " + numbers);

            // Using the firstKey() method
            String firstKey = numbers.firstKey();
            System.out.println("First Key: " + firstKey);

            // Using the lastKey() method
            String lastKey = numbers.lastKey();
            System.out.println("Last Key: " + lastKey);

            // Using firstEntry() method
            System.out.println("First Entry: " + numbers.firstEntry());

            // Using the lastEntry() method
            System.out.println("Last Entry: " + numbers.lastEntry());
        }
    }

// Example Three: TreeMap Comparator
import java.util.Comparator;

    public class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String number1, String number2) {
            int value = number1.compareTo(number2);
            // elements are sorted in reverse order
            if (value > 0) {
                return -1;
            } else if (value < 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

import java.util.TreeMap;

    public class MainComparator {
        public static void main(String[] args) {
            // Creating a treemap with a customized comparator
            TreeMap<String, Integer> numbers = new TreeMap<>(new CustomComparator());
            numbers.put("First", 1);
            numbers.put("Second", 2);
            numbers.put("Third", 3);
            numbers.put("Fourth", 4);
            System.out.println("TreeMap: " + numbers);
        }
    }

}
