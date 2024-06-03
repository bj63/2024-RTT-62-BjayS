public class Glab_303_10_3 {
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

        @Override
        public String toString() {
            return "Shape[color=" + color + "]";
        }

        public void displayshapName() {
            System.out.println("I am a Shape.");
        }
    }

    public class Circle extends Shape {
        protected double radius;
        private final double PI = Math.PI;

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

        @Override
        public void displayshapName() {
            System.out.println("Drawing a Circle of radius " + this.radius);
        }

        @Override
        public String toString() {
            return "Circle[ radius = " + radius + super.toString() + "]";
        }
    }

    public class Rectangle extends Shape {
        public Rectangle(String color) {
            super.color = color;
        }

        public Rectangle() {
        }

        public Rectangle(String color, double width, double height) {
            super.height = height;
            super.width = width;
            super.color = color;
        }

        @Override
        public double getArea() {
            return super.width * super.height;
        }

        @Override
        public void displayshapName() {
            System.out.println("I am a Rectangle");
        }

        @Override
        public String toString() {
            return "Rectangle[height=" + height + ",width=" + width + "," + super.toString() + "]";
        }
    }

    public class Triangle extends Shape {
        public Triangle() {
        }

        public Triangle(String color) {
            super.color = color;
        }

        public void setBase(int base) {
            this.base = base;
        }

        @Override
        public double getArea() {
            return 0.5 * super.base * super.height;
        }

        @Override
        public void displayshapName() {
            System.out.println("I am a TriAngle");
        }

        @Override
        public String toString() {
            return "Triangle[base=" + super.base + ",height=" + super.height + "," + super.toString() + "]";
        }
    }

    public class myRunner {
        public static void main(String[] args) {
            Circle c = new Circle(100);
            System.out.println("Area of Circle " + c.getArea());

            System.out.println("+++++++++++++++++");

            Shape shapeCircleObj = new Circle(100);  // UpCasting
            shapeCircleObj.displayshapName();
            System.out.println("Area of Circle " + shapeCircleObj.getArea());
            System.out.println(shapeCircleObj);  // Run circle's toString()

            System.out.println(shapeCircleObj instanceof Circle); // true
            System.out.println("+++++++++++++++++");

            Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
            shapeRectangleObj.displayshapName();
            shapeRectangleObj.setHeight(2);
            shapeRectangleObj.setWidth(4);
            System.out.println("Area of Rectangle is " + shapeRectangleObj.getArea());
            System.out.println(shapeRectangleObj);  // Run Rectangle's toString()

            System.out.println(shapeRectangleObj instanceof Rectangle); // true
            System.out.println("--------------------");

            Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
            shapeTriangleObj.displayshapName();
            shapeTriangleObj.setHeight(10);
            shapeTriangleObj.setBase(15);
            System.out.println("Area of Triangle is " + shapeTriangleObj.getArea());
            System.out.println(shapeTriangleObj);  // Run Triangle's toString()
        }
    }

}
