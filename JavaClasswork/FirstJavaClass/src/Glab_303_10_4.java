public class Glab_303_10_4 {
    public abstract class Shape {
        protected String color;
        protected double height;
        protected double width;
        protected double base;

        public void setColor(String color) {
            this.color = color;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public void setBase(double base) {
            this.base = base;
        }

        public abstract double getArea();

        public String toString() {
            return "Shape[color=" + color + "]";
        }

        public void displayshapName() {
            System.out.println("I am a Shape.");
        }
    }

    public interface Movable {
        void moveUp();

        void moveDown();

        void moveLeft();

        void moveRight();

        String getCoordinate();
    }

    public class Circle extends Shape implements Movable {
        protected double radius;
        private int x, y;
        private final double PI = Math.PI;

        public Circle(int x, int y, double radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public Circle(double radius) {
            this.radius = radius;
        }

        public Circle(double radius, double height) {
            this.radius = radius;
            super.height = height;
        }

        public double getArea() {
            return PI * Math.pow(this.radius, 2);
        }

        public void displayshapName() {
            System.out.println("Drawing a Circle of radius " + this.radius);
        }

        public String toString() {
            return "Circle[ radius = " + radius + super.toString() + "]";
        }

        public String getCoordinate() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public void moveUp() {
            y++;
        }

        @Override
        public void moveDown() {
            y--;
        }

        @Override
        public void moveLeft() {
            x--;
        }

        @Override
        public void moveRight() {
            x++;
        }
    }

    public class myRunner {
        public static void main(String[] args) {
            Circle c1 = new Circle(1, 2, 2);
            System.out.println("Area of Circle " + c1.getArea());
            System.out.println("Coordinates are " + c1.getCoordinate());
            c1.moveDown();
            System.out.println("After move Down, Coordinates are " + c1.getCoordinate());
            c1.moveRight();
            System.out.println("After move right, Coordinates are " + c1.getCoordinate());
            c1.moveUp();
            System.out.println("After move Up, Coordinates are " + c1.getCoordinate());
            c1.moveLeft();
            System.out.println("After move left, Coordinates are " + c1.getCoordinate());
            System.out.println("--------Test Polymorphism-------");
            Movable c2 = new Circle(5, 10, 200);
            c2.moveUp();
            System.out.println("After move up , Coordinates are " + c2.getCoordinate());
            c2.moveLeft();
            System.out.println("After move Left , Coordinates are " + c2.getCoordinate());
        }
    }

}
