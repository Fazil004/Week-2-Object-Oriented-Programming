public class Circle {
    double radius;

    public Circle() {
        this(1.0); 
    }

   
    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void displayCircleInfo() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
    }

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("Circle 1 (Default):");
        circle1.displayCircleInfo();

        Circle circle2 = new Circle(5.0);
        System.out.println("\nCircle 2 (Parameterized):");
        circle2.displayCircleInfo();
    }
}