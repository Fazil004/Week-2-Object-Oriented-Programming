public class Circle {
   private double radius ;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double area(){
        return Math.PI * radius * radius;
    }
    public double circumference(){
        return 2 * Math.PI * radius;
    }
    public static void main (String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(10);
        System.out.println("area 1 : " +circle1.area());
        System.out.println("circumference 1 : " +circle1.circumference());
        System.out.println("area 2 : " + circle2.area());
        System.out.println("circumference 2 : " + circle2.circumference());
    }

}