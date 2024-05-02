public class Homework303_2_1 {
    public class Main {
        public static void main(String[] args) {
            // Program 1: Adding two integers
            // Declare two integer variables and assign values to them
            int num1 = 5;
            int num2 = 10;
            // Add the two numbers together and store the result in a variable
            int sumResult = num1 + num2;
            // Print out the result
            System.out.println("Sum of two integers: " + sumResult);

            // Program 2: Adding two doubles
            // Declare two double variables and assign values to them
            double num3 = 3.14;
            double num4 = 2.718;
            // Add the two numbers together and store the result in a variable
            double sumResultDouble = num3 + num4;
            // Print out the result
            System.out.println("Sum of two doubles: " + sumResultDouble);

            // Program 3: Adding an integer and a double
            // Declare an integer variable and a double variable and assign values to them
            int intNum = 5;
            double doubleNum = 3.14;
            // Add the integer and double together and store the result in a variable
            double sumResultMixed = intNum + doubleNum;
            // Print out the result
            System.out.println("Sum of an integer and a double: " + sumResultMixed);
            // The sum variable must be a double to accommodate both integer and double types.

            // Program 4: Dividing larger integer by smaller integer
            // Declare two integer variables and assign values to them
            int num5 = 10;
            int num6 = 5;
            // Perform the division and store the result in a variable
            double resultIntDiv = (double) num5 / num6;
            // Print out the result
            System.out.println("Result of dividing larger integer by smaller integer: " + resultIntDiv);
            // Now change the larger number to a decimal.
            // Declare a double variable and assign a value to it
            double num7 = 10.0;
            // Perform the division and store the result in a variable
            double resultDoubleDiv = num7 / num6;
            // Print out the result
            System.out.println("Result after changing the larger number to a decimal: " + resultDoubleDiv);


            // Program 5: Dividing larger double by smaller double, and casting to integer
            // Declare two double variables and assign values to them
            double num8 = 10.0;
            double num9 = 5.0;
            // Perform the division and store the result in a variable
            double resultDoubleDiv2 = num8 / num9;
            // Print out the result
            System.out.println("Result of dividing larger double by smaller double: " + resultDoubleDiv2);
            int resultAsInt = (int) resultDoubleDiv2;
            // Print out the result
            System.out.println("Result after casting to an integer: " + resultAsInt);
        }
    }

}
