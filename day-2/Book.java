public class Book {
    String title;
    String author;
    double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Anonymous";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + String.format("%.2f", price));
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        System.out.println("Book 1 (Default):");
        book1.displayBookInfo();

        Book book2 = new Book("The Great Novel", "Jane Doe", 299.99);
        System.out.println("\nBook 2 (Parameterized):");
        book2.displayBookInfo();
    }
}