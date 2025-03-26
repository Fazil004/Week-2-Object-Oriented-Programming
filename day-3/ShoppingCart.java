class Product {
    public static double discount;
    private static int counter;
    public final int productID;
    public String productName;
    public double price;
    public int quantity;
    static{
         discount = 10.0;
        counter = 0;
    }
    public Product(String productName, double price, int quantity) {
        this.productID = ++counter;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1000, 2);
        Product p2 = new Product("Mouse", 25, 5);

        if (p1 instanceof Product) p1.displayDetails();
        if (p2 instanceof Product) p2.displayDetails();

        Product.updateDiscount(15.0);
        System.out.println("\nUpdated Discount:");
        p1.displayDetails();
    }
}