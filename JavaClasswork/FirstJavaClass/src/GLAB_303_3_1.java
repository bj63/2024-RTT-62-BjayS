public class GLAB_303_3_1 {
    public static void main(String[] args) {
        // Previous code...

        String s1 = "";
        String s2 = "hello";
        System.out.println(s1.isEmpty()); // Output: true
        System.out.println(s2.isEmpty()); // Output: false

        String s3 = " hello ";
        System.out.println(s3 + "how are you"); // Output:  hello how are you
        System.out.println(s3.trim() + "how are you"); // Output: hellohow are you

        String s1Upper = "HELLO HOW Are You?";
        String s1Lower = s1Upper.toLowerCase();
        System.out.println(s1Lower); // Output: hello how are you?

        // Concatenation examples
        String str3 = "Learn ";
        String str4 = "Java";
        System.out.println(str3.concat(str4)); // Output: Learn Java
        System.out.println(str4.concat(str3)); // Output: JavaLearn

        String s5 = "hello";
        String s6 = "Learners";
        String s7 = s5.concat(s6); // Same as s7 = s5 + s6;
        // Both s7 concatenations will give you the same result

        String message = "Welcome " + "to " + "Java"; // Output: Welcome to Java

        String s8 = "Chapter" + 2; // s8 becomes "Chapter2"

        String s9 = "Supplement" + 'B'; // s9 becomes "SupplementB"

        // Additional examples:

        // Using the length() method
        System.out.println("Length of \"Java\": " + "Java".length()); // Output: 4

        // Using the trim() method
        String s10 = "  hello  ";
        System.out.println("Before trim: \"" + s10 + "\""); // Output: Before trim: "  hello  "
        System.out.println("After trim: \"" + s10.trim() + "\""); // Output: After trim: "hello"

        // Using the toLowerCase() method
        String s11 = "Hello World";
        System.out.println("Lowercase of \"" + s11 + "\": " + s11.toLowerCase()); // Output: Lowercase of "Hello World": hello world

        // Using the toUpperCase() method
        String s12 = "hello world";
        System.out.println("Uppercase of \"" + s12 + "\": " + s12.toUpperCase()); // Output: Uppercase of "hello world": HELLO WORLD
    }
}
public class GLAB_303_3_1 {
    public static void main(String[] args) {
        // Previous code...

        String s1 = "";
        String s2 = "hello";
        System.out.println(s1.isEmpty()); // Output: true
        System.out.println(s2.isEmpty()); // Output: false

        String s3 = " hello ";
        System.out.println(s3 + "how are you"); // Output:  hello how are you
        System.out.println(s3.trim() + "how are you"); // Output: hellohow are you

        String s1Upper = "HELLO HOW Are You?";
        String s1Lower = s1Upper.toLowerCase();
        System.out.println(s1Lower); // Output: hello how are you?

        // Concatenation examples
        String str3 = "Learn ";
        String str4 = "Java";
        System.out.println(str3.concat(str4)); // Output: Learn Java
        System.out.println(str4.concat(str3)); // Output: JavaLearn

        String s5 = "hello";
        String s6 = "Learners";
        String s7 = s5.concat(s6); // Same as s7 = s5 + s6;
        // Both s7 concatenations will give you the same result

        String message = "Welcome " + "to " + "Java"; // Output: Welcome to Java

        String s8 = "Chapter" + 2; // s8 becomes "Chapter2"

        String s9 = "Supplement" + 'B'; // s9 becomes "SupplementB"

        // Additional examples:

        // Using the length() method
        System.out.println("Length of \"Java\": " + "Java".length()); // Output: 4

        // Using the trim() method
        String s10 = "  hello  ";
        System.out.println("Before trim: \"" + s10 + "\""); // Output: Before trim: "  hello  "
        System.out.println("After trim: \"" + s10.trim() + "\""); // Output: After trim: "hello"

        // Using the toLowerCase() method
        String s11 = "Hello World";
        System.out.println("Lowercase of \"" + s11 + "\": " + s11.toLowerCase()); // Output: Lowercase of "Hello World": hello world

        // Using the toUpperCase() method
        String s12 = "hello world";
        System.out.println("Uppercase of \"" + s12 + "\": " + s12.toUpperCase()); // Output: Uppercase of "hello world": HELLO WORLD
    }
}
