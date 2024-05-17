import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;


public class Glab_30_13_1 {


    public class ScanDelimiterdFile {
        public static void main(String[] args) throws FileNotFoundException {
            try {
                String location = "C:/Users/Downloads/cars.csv";
                File file = new File(location);
                Scanner input = new Scanner(file);
                ArrayList<String[]> data = new ArrayList<String[]>();

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] splitedLine = line.split(",");
                    data.add(splitedLine);
                }

                for (String[] line : data) {
                    System.out.println("Car Name :" + line[0]);
                    System.out.println("MPG :" + line[1]);
                    System.out.println("Cylinder :" + line[2]);
                    System.out.println("Displacement :" + line[3]);
                    System.out.println("Horsepower :" + line[4]);
                    System.out.println("Weight :" + line[5]);
                    System.out.println("Acceleration :" + line[6]);
                    System.out.println("Model :" + line[7]);
                    System.out.println("Origin :" + line[8]);
                    System.out.println("===============================");
                }

                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found! ");
                e.printStackTrace();
            }
        }
    }
    public class Course {
        private String code;
        private String courseName;
        private String instructorName;

        public Course(String code, String courseName, String instructorName) {
            this.code = code;
            this.courseName = courseName;
            this.instructorName = instructorName;
        }

        public Course() {
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getInstructorName() {
            return instructorName;
        }

        public void setInstructorName(String instructorName) {
            this.instructorName = instructorName;
        }
    }


    public class MyRunner {
        public static void main(String[] args) throws FileNotFoundException {
            try {
                //-----  change file path, as per your file location
                String location = "C:/Users/Downloads/CourseData.csv";
                File file = new File(location);
                Scanner input = new Scanner(file);
                ArrayList<Course> data = new ArrayList<Course>();

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] splitedLine = line.split(",");

                    Course cObj = new Course();
                    cObj.setCode(splitedLine[0]);
                    cObj.setCourseName(splitedLine[1]);
                    cObj.setInstructorName(splitedLine[2]);
                    data.add(cObj);
                }

                for (Course c : data) {
                    System.out.println(c.getCode() + " | " + c.getCourseName() + " | " + c.getInstructorName());
                    System.out.println("===============================");
                }

                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found! ");
                e.printStackTrace();
            }
        }
    }


}
