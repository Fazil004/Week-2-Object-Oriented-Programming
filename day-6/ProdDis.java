import java.util.ArrayList;
import java.util.List;

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Invalid price. Price not updated.");
        }
    }

    public abstract double calculateDiscount();

    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + String.format("%.2f", price));
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Concrete class Electronics
class Electronics extends Product implements Taxable {
    private String brand;
    private double warranty; //in years

    public Electronics(int productId, String name, double price, String brand, double warranty) {
        super(productId, name, price);
        this.brand = brand;
        this.warranty = warranty;
    }

    public String getBrand() {
        return brand;
    }

    public double getWarranty() {
        return warranty;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "GST 18%";
    }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warranty + " years");
        System.out.println("Tax: ₹" + String.format("%.2f", calculateTax()) + " (" + getTaxDetails() + ")");
        System.out.println("Discount: ₹" + String.format("%.2f", calculateDiscount()));
    }
}

// Concrete class Clothing
class Clothing extends Product implements Taxable {
    private String size;
    private String material;

    public Clothing(int productId, String name, double price, String size, String material) {
        super(productId, name, price);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

     @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }

    @Override
    public String getTaxDetails() {
        return "GST 12%";
    }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
         System.out.println("Tax: ₹" + String.format("%.2f", calculateTax()) + " (" + getTaxDetails() + ")");
        System.out.println("Discount: ₹" + String.format("%.2f", calculateDiscount()));
    }
}

// Concrete class Groceries
class Groceries extends Product {
    private String expiryDate;
    private boolean isOrganic;

    public Groceries(int productId, String name, double price, String expiryDate, boolean isOrganic) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
        this.isOrganic = isOrganic;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    @Override
    public double calculateDiscount() {
        if (isOrganic)
            return getPrice() * 0.02; // 2% discount for organic
        else
            return 0;
    }

    @Override
    public void displayProductDetails() {
        super.displayProductDetails();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Organic: " + isOrganic);
        System.out.println("Discount: ₹" + String.format("%.2f", calculateDiscount()));
    }
}

// Main class
public class ProdDis {

    public static double calculateFinalPrice(List<Product> products) {
        double finalPrice = 0;
        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = 0;
            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }
            finalPrice += product.getPrice() + tax - discount;
        }
        return finalPrice;
    }

    public static void main(String[] args) {
        Electronics electronics1 = new Electronics(101, "Laptop", 60000.00, "Dell", 1);
        Clothing clothing1 = new Clothing(201, "T-Shirt", 1000.00, "M", "Cotton");
        Groceries groceries1 = new Groceries(301, "Organic Apples", 200.00, "2025-05-10", true);
        Groceries groceries2 = new Groceries(302, "Regular Milk", 50.00, "2024-04-20", false);

        List<Product> productList = new ArrayList<>();
        productList.add(electronics1);
        productList.add(clothing1);
        productList.add(groceries1);
        productList.add(groceries2);

        System.out.println("\n--- Product Details ---");
        for (Product product : productList) {
            product.displayProductDetails();
            System.out.println("----------------------");
        }

        double finalPrice = calculateFinalPrice(productList);
        System.out.println("\nTotal Final Price: ₹" + String.format("%.2f", finalPrice));
    }
}