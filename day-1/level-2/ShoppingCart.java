import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public void displayItem() {
        System.out.println(itemName + " - Quantity: " + quantity + " - Price per item: ₹" + String.format("%.2f", price));
    }
}

public class ShoppingCart {
    private List<CartItem> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void addItem(String itemName, double price, int quantity) {
        CartItem newItem = new CartItem(itemName, price, quantity);
        cart.add(newItem);
        System.out.println(quantity + " " + itemName + "(s) added to the cart.");
    }

    public void removeItem(String itemName) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(itemName)) {
                cart.remove(i);
                System.out.println(itemName + " removed from the cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(itemName + " not found in the cart.");
        }
    }

    public void displayCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\n--- Shopping Cart ---");
        for (CartItem item : cart) {
            item.displayItem();
        }
        System.out.println("---------------------");
        System.out.println("Total cost: ₹" + String.format("%.2f", calculateTotalCost()));
        System.out.println("---------------------");
    }

    public double calculateTotalCost() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotalCost();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart myCart = new ShoppingCart();

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. View cart");
            System.out.println("4. Calculate total cost");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter price per item: ₹");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    myCart.addItem(itemName, price, quantity);
                    break;
                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    myCart.removeItem(itemToRemove);
                    break;
                case 3:
                    myCart.displayCart();
                    break;
                case 4:
                    System.out.println("Total cost of items in the cart: ₹" + String.format("%.2f", myCart.calculateTotalCost()));
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}