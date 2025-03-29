import java.util.ArrayList;
import java.util.List;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Added setter for quantity with validation
    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Invalid quantity. Quantity not updated.");
        }
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: ₹" + String.format("%.2f", price));
        System.out.println("Quantity: " + quantity);
    }
}

// Interface Discountable
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Class VegItem
class VegItem extends FoodItem implements Discountable {
    private String category; // e.g., "Main Course", "Appetizer"

    public VegItem(String itemName, double price, int quantity, String category) {
        super(itemName, price, quantity);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount for veg items
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount";
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Category: " + category);
        System.out.println("Total Price: ₹" + String.format("%.2f", calculateTotalPrice()));
    }
}

// Class NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    private String foodType; // e.g., "Chicken", "Mutton", "Fish"
    private double additionalCharge;

    public NonVegItem(String itemName, double price, int quantity, String foodType, double additionalCharge) {
        super(itemName, price, quantity);
        this.foodType = foodType;
        this.additionalCharge = additionalCharge;
    }

    public String getFoodType() {
        return foodType;
    }

    public double getAdditionalCharge() {
        return additionalCharge;
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + additionalCharge;
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.02; // 2% discount for non-veg
    }

    @Override
    public String getDiscountDetails() {
        return "2% discount";
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Food Type: " + foodType);
        System.out.println("Additional Charge: ₹" + String.format("%.2f", additionalCharge));
        System.out.println("Total Price: ₹" + String.format("%.2f", calculateTotalPrice()));
    }
}

// Class to process order
class OrderProcessor {
    // Method to process a list of FoodItems and calculate total order price
    public double processOrder(List<FoodItem> orderItems) {
        double orderTotal = 0;
        for (FoodItem item : orderItems) {
            item.getItemDetails(); // Display details of each item
            double itemTotal = item.calculateTotalPrice();
            double discount = 0;
            if (item instanceof Discountable) {
                discount = ((Discountable) item).applyDiscount();
                System.out.println("Discount: ₹" + String.format("%.2f", discount) + " (" + ((Discountable) item).getDiscountDetails() + ")");
            }
            itemTotal -= discount;
            orderTotal += itemTotal;
            System.out.println("Final Item Price: ₹" + String.format("%.2f", itemTotal));
            System.out.println("----------------------");
        }
        return orderTotal;
    }
}

// Main class
public class FoodDetails {
    public static void main(String[] args) {
        // Create food items
        VegItem veg1 = new VegItem("Paneer Tikka", 250.00, 2, "Appetizer");
        NonVegItem nonVeg1 = new NonVegItem("Chicken Biryani", 350.00, 1, "Chicken", 50.00);
        VegItem veg2 = new VegItem("Veg Curry", 300, 2, "Main Course");

        // Create an order
        List<FoodItem> order = new ArrayList<>();
        order.add(veg1);
        order.add(nonVeg1);
        order.add(veg2);

        // Create an order processor
        OrderProcessor orderProcessor = new OrderProcessor();

        // Process the order and display total
        System.out.println("\n--- Order Details ---");
        double totalOrderPrice = orderProcessor.processOrder(order);
        System.out.println("Total Order Price: ₹" + String.format("%.2f", totalOrderPrice));

        //Demonstrate setQuantity
        veg1.setQuantity(3);
        System.out.println("\n---Updated Veg Item 1 Details---");
        veg1.getItemDetails();
    }
}