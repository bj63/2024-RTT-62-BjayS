import java.util.Scanner;

public class IfStatements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); // Assuming you want to take input from the user

        if (x < 10) {
            System.out.println("Less than 10");
        } else if (x < 20) {
            System.out.println("Less than 20");
        } else if (x < 30) {
            System.out.println("Less than 30");
        }
    }
}
