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



