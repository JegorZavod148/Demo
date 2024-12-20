public class Main {

    public static void main(String[] args){
        System.out.println("-----------------------------\n");

        Shape circle = new Circle(4);
        Shape rectangle = new Rectangle(2.4, 4.5);
        Shape triangle = new Triangle(4, 5, 6);

        System.out.println("Площа кола: "+circle.calculateArea()+".\n");
        System.out.println("Площа прямокутника: " + rectangle.calculateArea()+".\n");
        System.out.println("Площа трикутника: " + triangle.calculateArea()+".\n");

        System.out.println("-----------------------------");
    }
}

//---------------------------------------

interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14*radius*radius;
    }
}

class Rectangle implements Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width*height;
    }
}

class Triangle implements Shape {
    double side1;
    double side2;
    double side3;
    double s;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.s = (side1 + side2 + side3) / 2;
    }

    @Override
    public double calculateArea() {
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
}




