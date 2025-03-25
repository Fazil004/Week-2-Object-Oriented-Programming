public class Product {
    String productName;
    double price;
    static int totalProducts = 0; // Class variable

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products when a new product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + String.format("%.2f", price));
    }

    // Class method to display the total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 50000.00);
        Product product2 = new Product("Mouse", 500.00);
        Product product3 = new Product("Keyboard", 1200.00);

        System.out.println("--- Product 1 Details ---");
        product1.displayProductDetails();

        System.out.println("\n--- Product 2 Details ---");
        product2.displayProductDetails();

        System.out.println("\n--- Product 3 Details ---");
        product3.displayProductDetails();

        System.out.println("\n--- Total Products ---");
        Product.displayTotalProducts(); // Calling the class method using the class name
    }
}