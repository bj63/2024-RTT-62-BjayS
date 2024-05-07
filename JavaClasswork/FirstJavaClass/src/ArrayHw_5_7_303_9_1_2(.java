public class ArrayHw_5_7 {
        public static void main(String[] args) {
            // Create an int array of length 10
            int[] arr = new int[10];

            // Initialize the array to random integers
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt();
            }

            // Get the smallest integer in the array
            int min = arr[0];
            for (int num : arr) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println("Smallest integer in the array: " + min);

            // Get the largest integer in the array
            int max = arr[0];
            for (int num : arr) {
                if (num > max) {
                    max = num;
                }
            }
            System.out.println("Largest integer in the array: " + max);

            // Calculate the average value in the array as a double
            double sum = 0;
            for (int num : arr) {
                sum += num;
            }
            double average = sum / arr.length;
            System.out.println("Average value in the array: " + average);
        }
    }
public class HumanBeing {
    private float weight;
    private float height;
    private float bmi;

    public HumanBeing(float weight, float height, float bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    public HumanBeing() {
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
}
public class EncapsulationExample {
    public static void main(String[] args) {
        HumanBeing h1 = new HumanBeing();
        // using setters of HumanBeing
        h1.setHeight(1.65f);
        h1.setWeight(68);
        h1.setBmi(calculateBmi(h1));
        // using getters of HumanBeing
        System.out.println("Person has " + h1.getWeight() + " kgs and is " + h1.getHeight() + " meters in height, which results in BMI of " + h1.getBmi());
    }

    public static float calculateBmi(HumanBeing h1) {
        return h1.getWeight() / (h1.getHeight() * h1.getHeight());
    }
}
// Step 1: Create a Java project named "inheritanceDemo."

// Step 2: Create a class named Doctor
public class Doctor {
    String DoctorName;
    String Department;

    public void Doctor_Details() {
        System.out.println("Doctor Details...");
    }
}

// Step 3: Create a class named Surgeon that extends Doctor
public class Surgeon extends Doctor {
    void Surgeon_Details() {
        System.out.println("Surgeon Detail...");
        System.out.println(Department = "Cardio");
    }
}

// Step 4: Create a class named Hospital with the main() method
public class Hospital {
    public static void main(String args[]) {
        Surgeon s = new Surgeon();
        s.Doctor_Details();
        s.Surgeon_Details();
    }
}
public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Element at index " + i + ": " + array[i]);
        }
    }
}
public class Task2 {
    public static void main(String[] args) {
        int[] array = {13, 5, 7, 68, 2};
        int middleIndex = array.length / 2;
        System.out.println("Middle element: " + array[middleIndex]);
    }
}
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String[] colors = {"red", "green", "blue", "yellow"};
        System.out.println("Original array length: " + colors.length);

        String[] copy = colors.clone();
        System.out.println("Copy of array: " + Arrays.toString(copy));
    }
}
public class Task4 {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};

        System.out.println("First element: " + myArray[0]);
        System.out.println("Last element: " + myArray[myArray.length - 1]);

        // Uncomment the line below to produce an ArrayIndexOutOfBoundsException
        // System.out.println("Out of bounds index: " + myArray[myArray.length]);

        // Uncomment the line below to produce an ArrayIndexOutOfBoundsException
        // myArray[5] = 6;
    }
}
public class Task5 {
    public static void main(String[] args) {
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println(Arrays.toString(array));
    }
}
public class Task6 {
    public static void main(String[] args) {
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }

        System.out.println(Arrays.toString(array));
    }
}
public class Task7 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        for (int i = 0; i < array.length; i++) {
            if (i != array.length / 2) {
                System.out.println("Element at index " + i + ": " + array[i]);
            }
        }
    }
}
public class Task8 {
    public static void main(String[] args) {
        String[] array = {"One", "Two", "Three", "Four", "Five"};

        // Swap the first element with the middle element
        String temp = array[0];
        array[0] = array[array.length / 2];
        array[array.length / 2] = temp;

        System.out.println(Arrays.toString(array));
    }
}
import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        int[] array = {4, 2, 9, 13, 1, 0};
        Arrays.sort(array);

        System.out.println("Array in ascending order: " + Arrays.toString(array));
        System.out.println("The smallest number is " + array[0]);
        System.out.println("The biggest number is " + array[array.length - 1]);
    }
}
public class Task10 {
    public static void main(String[] args) {
        Object[] array = {1, "Hello", "World", "Java", 3.14};
        System.out.println(Arrays.toString(array));
    }
}
import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many favorite things do you have? ");
        int numFavorites = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] favorites = new String[numFavorites];

        for (int i = 0; i < numFavorites; i++) {
            System.out.print("Enter your thing: ");
            favorites[i] = scanner.nextLine();
        }

        System.out.println("Your favorite things are: ");
        for (String favorite : favorites) {
            System.out.print(favorite + " ");
        }

        scanner.close();
    }
}



