public class Glab_303_11_3 {
    import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

    public class RemoveElementsFromArrayList {
        public static void main(String[] args) {
            List<String> programmingLanguages = new ArrayList<>();
            programmingLanguages.add("C");
            programmingLanguages.add("C++");
            programmingLanguages.add("Java");
            programmingLanguages.add("Kotlin");
            programmingLanguages.add("Python");
            programmingLanguages.add("Perl");
            programmingLanguages.add("Ruby");

            System.out.println("Initial List: " + programmingLanguages);

            // Remove the element at index `5`
            programmingLanguages.remove(5);
            System.out.println("After remove(5): " + programmingLanguages);

            // Remove the first occurrence of the given element from the ArrayList
            // (The remove() method returns false if the element does not exist in the ArrayList)
            boolean isRemoved = programmingLanguages.remove("Kotlin");
            System.out.println("After remove(\"Kotlin\"): " + programmingLanguages);

            // Remove all the elements that exist in a given collection
            List<String> scriptingLanguages = new ArrayList<>();
            scriptingLanguages.add("Python");
            scriptingLanguages.add("Ruby");
            scriptingLanguages.add("Perl");

            programmingLanguages.removeAll(scriptingLanguages);
            System.out.println("After removeAll(scriptingLanguages): " + programmingLanguages);

            // Remove all elements from the ArrayList
            programmingLanguages.clear();
            System.out.println("After clear(): " + programmingLanguages);
        }
    }

}
import java.util.*;

public class IterateOverArrayList {
    public static void main(String[] args) {
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Breaking Bad");
        tvShows.add("Game Of Thrones");
        tvShows.add("Friends");
        tvShows.add("Prison break");

        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> tvShowIterator = tvShows.iterator();
        while (tvShowIterator.hasNext()) {
            String tvShow = tvShowIterator.next();
            System.out.println(tvShow);
        }

        System.out.println("==Iterate using an iterator() and forEachRemaining() method ===");
        tvShowIterator = tvShows.iterator();
        tvShowIterator.forEachRemaining(tvShow -> {
            System.out.println(tvShow);
        });

        System.out.println("\n=== Iterate using simple for-each loop ===");
        for (String tvShow : tvShows) {
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using for loop with index ===");
        for (int i = 0; i < tvShows.size(); i++) {
            System.out.println(tvShows.get(i));
        }

        System.out.println("\n=== Iterate using listIterator ===");
        ListIterator<String> iterator = tvShows.listIterator();
        System.out.println("Elements in forward direction:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n=== Iterate using listIterator in backward direction ===");
        System.out.println("Elements in backward direction:");

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
import java.util.*;

public class IterateOverArrayList {
    public static void main(String[] args) {
        List<String> tvShows = new ArrayList<>();
        tvShows.add("Breaking Bad");
        tvShows.add("Game Of Thrones");
        tvShows.add("Friends");
        tvShows.add("Prison break");

        System.out.println("\n=== Iterate using an iterator() ===");
        Iterator<String> tvShowIterator = tvShows.iterator();
        while (tvShowIterator.hasNext()) {
            String tvShow = tvShowIterator.next();
            System.out.println(tvShow);
        }

        System.out.println("==Iterate using an iterator() and forEachRemaining() method ===");
        tvShowIterator = tvShows.iterator();
        tvShowIterator.forEachRemaining(tvShow -> {
            System.out.println(tvShow);
        });

        System.out.println("\n=== Iterate using simple for-each loop ===");
        for (String tvShow : tvShows) {
            System.out.println(tvShow);
        }

        System.out.println("\n=== Iterate using for loop with index ===");
        for (int i = 0; i < tvShows.size(); i++) {
            System.out.println(tvShows.get(i));
        }

        System.out.println("\n=== Iterate using listIterator ===");
        ListIterator<String> iterator = tvShows.listIterator();
        System.out.println("Elements in forward direction:");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n=== Iterate using listIterator in backward direction ===");
        System.out.println("Elements in backward direction:");

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}


