import java.time.LocalDate;

class Order {
    int orderId;
    LocalDate orderDate;

    public Order(int orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }

    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(int orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

class DeliveredOrder extends ShippedOrder {
    LocalDate deliveryDate;

    public DeliveredOrder(int orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered";
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }

    public static void main(String[] args) {
        Order order = new Order(101, LocalDate.now());
        ShippedOrder shippedOrder = new ShippedOrder(102, LocalDate.now().minusDays(2), "TRACK123");
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, LocalDate.now().minusDays(5), "TRACK456", LocalDate.now().minusDays(1));

        System.out.println("--- Order ---");
        order.displayOrderInfo();

        System.out.println("\n--- Shipped Order ---");
        shippedOrder.displayOrderInfo();

        System.out.println("\n--- Delivered Order ---");
        deliveredOrder.displayOrderInfo();
    }
}