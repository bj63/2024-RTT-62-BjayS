public class Glab_303_10_2 {
    public class Shape {
        private String color;
        protected double area = 1.0;
        protected double base = 1.0;
        protected double width = 1.0;
        protected double height = 1.0;

        public Shape(String color) {
            this.color = color;
        }

        public Shape() {
        }

        public Shape(String color, double area, double base, double width, double height) {
            this.color = color;
            this.area = area;
            this.base = base;
            this.width = width;
            this.height = height;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setArea(double area) {
            this.area = area;
        }

        public void setBase(double base) {
            this.base = base;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Shape[color=" + color + "]";
        }

        public double getArea() {
            System.out.println("Shape unknown! Cannot compute area!");
            return 0;
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
            super.area = PI * Math.pow(this.radius, 2);
            return super.area;
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
            super(color);
        }

        public Rectangle() {
        }

        public Rectangle(String color, double area, double base, double width, double height) {
            super(color, area, base, width, height);
        }

        @Override
        public void setBase(double base) {
            super.base = base;
        }

        @Override
        public void setWidth(double width) {
            super.width = width;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        public double perimeter() {
            super.area = super.width * super.height;
            return super.area;
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

        public Triangle(String color, double area, double base, double width, double height) {
            super(color, area, base, width, height);
        }

        public Triangle(String color) {
            super(color);
        }

        @Override
        public void setBase(double base) {
            super.base = base;
        }

        @Override
        public void setWidth(double width) {
            super.width = width;
        }

        @Override
        public double getArea() {
            return 0.5 * base * height;
        }

        @Override
        public void displayshapName() {
            System.out.println("I am a TriAngle");
        }

        @Override
        public String toString() {
            return "Triangle[base=" + base + ",height=" + height + "," + super.toString() + "]";
        }
    }

    public class Cylinder extends Circle {
        private final double PI = Math.PI;

        public Cylinder(double radius, double height) {
            super(radius, height);
        }

        public Cylinder(double radius) {
            super(radius);
        }

        public double getVolumne() {
            return (PI * Math.pow(super.radius, 2)) * super.height;
        }

        public double getSurfaceArea() {
            return 2.0 * Math.PI * super.radius * super.height;
        }

        @Override
        public void displayshapName() {
            System.out.println("Drawing a Cylinder for radius " + super.radius);
        }

        @Override
        public String toString() {
            return "radius is: " + super.radius + "height is : " + super.height;
        }
    }

    public class myRunner {
        public static void main(String[] args) {
            Circle c = new Circle(100);
            System.out.println("Area of Circle " + c.getArea());

            Shape sObj = new Shape();
            sObj.displayshapName();
            System.out.println(sObj instanceof Shape); // true

            System.out.println("+++++++++");

            Shape shapeCircleObj = new Circle(100);  // UpCasting
            shapeCircleObj.displayshapName();
            System.out.println("Area of Circle " + shapeCircleObj.getArea());
            System.out.println(shapeCircleObj);  // Run circle's toString()

            System.out.println(shapeCircleObj instanceof Circle); // true
            System.out.println(sObj instanceof Circle); // false

            System.out.println("--------------------");

            Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
            shapeRectangleObj.displayshapName();
            shapeRectangleObj.setHeight(2);
            shapeRectangleObj.setWidth(2);
            System.out.println("Area of Rectangle is " + shapeRectangleObj.getArea());
            System.out.println(shapeRectangleObj);  // Run Rectangle's toString()

            System.out.println(shapeRectangleObj instanceof Rectangle); // true
            System.out.println(sObj instanceof Rectangle); // false

            System.out.println("--------------------");

            Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
            shapeTriangleObj.displayshapName();
            shapeTriangleObj.setHeight(2);
            shapeTriangleObj.setBase(3);
            System.out.println("Area of Triangle is " + shapeTriangleObj.getArea());
            System.out.println(shapeTriangleObj);  // Run Triangle's toString()

            System.out.println(shapeTriangleObj instanceof Triangle); // true
            System.out.println(sObj instanceof Triangle); // false

            System.out.println("--------------------");

            Cylinder cylinderShape = new Cylinder(3); //UpCasting
            cylinderShape.displayshapName();
            cylinderShape.setHeight(3);
            System.out.println("Area of Cylinder is " + cylinderShape.getVolumne());
            System.out.println(cylinderShape);  // Run cylinderShape's toString()
        }
    }

}
