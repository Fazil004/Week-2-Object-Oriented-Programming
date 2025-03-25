public class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // Initially, the book is available
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' has been borrowed.");
        } else {
            System.out.println("Book '" + title + "' is currently not available.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book '" + title + "' has been returned.");
        } else {
            System.out.println("Book '" + title + "' was already available.");
        }
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + String.format("%.2f", price));
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("The Secret Garden", "Frances Hodgson Burnett", 199.50);
        book1.displayBookInfo();

        book1.borrowBook();
        book1.displayBookInfo();

        book1.borrowBook(); // Try to borrow again

        book1.returnBook();
        book1.displayBookInfo();

        book1.returnBook(); // Try to return again
    }
}