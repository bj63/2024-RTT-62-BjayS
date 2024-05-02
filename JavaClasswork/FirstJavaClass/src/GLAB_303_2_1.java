public class GLAB_303_2_1 {
}
public class GLAB_303_2_1 {
    public static void main(String[] args) {
        // Exercise 1
        int x = 9; // Predicted decimal value after left shift by 1: 18, Binary string: 10010
        x = x << 1;
        System.out.println("Exercise 1:");
        System.out.println("Decimal value of x: " + x);
        System.out.println("Binary string of x: " + Integer.toBinaryString(x));

        // Exercise 2
        x = 225; // Predicted decimal value after right shift by 2: 56, Binary string: 111000
        x = x >> 2;
        System.out.println("\nExercise 2:");
        System.out.println("Decimal value of x: " + x);
        System.out.println("Binary string of x: " + Integer.toBinaryString(x));

        // Exercise 3
        int y = 17;
        int z;
        // Predicted result of bitwise AND operation: 1 (binary: 0001)
        z = x & y;
        System.out.println("\nExercise 3:");
        System.out.println("Result of bitwise AND operation: " + z);
        System.out.println("Binary string of z: " + Integer.toBinaryString(z));

        // Exercise 4
        // Predicted result of bitwise OR operation: 25 (binary: 11001)
        z = x | y;
        System.out.println("\nExercise 4:");
        System.out.println("Result of bitwise OR operation: " + z);
        System.out.println("Binary string of z: " + Integer.toBinaryString(z));

        // Exercise 5
        int num = 5;
        System.out.println("\nExercise 5:");
        System.out.println("Value of num before increment: " + num);
        num++;
        System.out.println("Value of num after increment: " + num);

        // Exercise 6
        int var = 10;
        System.out.println("\nExercise 6:");
        System.out.println("Initial value of var: " + var);
        var += 1;
        System.out.println("Value of var after increment: " + var);
        var++;
        System.out.println("Value of var after postfix increment: " + var);
        ++var;
        System.out.println("Value of var after prefix increment: " + var);
    }
}




