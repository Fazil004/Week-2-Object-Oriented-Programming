class Book {
    public String ISBN;
    protected String title;
    private String author;

    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to get the author name
    public String getAuthor() {
        return author;
    }

    // Public method to set the author name
    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("ISBN (Public): " + ISBN);
        System.out.println("Title (Protected): " + title);
        System.out.println("Author (Private - Accessible via public method): " + getAuthor());
    }
}

class EBook extends Book {
    String fileFormat;

    public EBook(String ISBN, String title, String author, String fileFormat) {
        super(ISBN, title, author);
        this.fileFormat = fileFormat;
    }

    public void displayEBookInfo() {
        System.out.println("--- EBook Info ---");
        System.out.println("ISBN (Public - Accessible in subclass): " + ISBN);
        System.out.println("Title (Protected - Accessible in subclass): " + title);
        System.out.println("Author (Private - Accessible via superclass method): " + getAuthor());
        System.out.println("File Format: " + fileFormat);
    }

    // Example of accessing protected member
    public String getBookTitle() {
        return this.title; // Accessing the protected 'title' member
    }

    // Example of modifying private member using public method
    public void updateAuthor(String newAuthor) {
        setAuthor(newAuthor); // Using the public setter method for 'author'
    }
}

public class BookLibrarySystem {
    public static void main(String[] args) {
        Book regularBook = new Book("978-1234567890", "The Old Man and the Sea", "Ernest Hemingway");
        System.out.println("--- Regular Book Info ---");
        System.out.println("ISBN (Public): " + regularBook.ISBN);
        System.out.println("Title (Protected - Not directly accessible here): " + regularBook.title);
        System.out.println("Author (Private - Accessible via public method): " + regularBook.getAuthor());

        // Accessing and modifying author using public methods
        regularBook.setAuthor("Ernest H.");
        System.out.println("Updated Author: " + regularBook.getAuthor());

        EBook eBook = new EBook("978-0987654321", "Pride and Prejudice", "Jane Austen", "EPUB");
        eBook.displayEBookInfo();

        // Accessing public and protected members from subclass
        System.out.println("EBook ISBN (via subclass): " + eBook.ISBN);
        System.out.println("EBook Title (via subclass method): " + eBook.getBookTitle());

        // Modifying private member from subclass using public method
        eBook.updateAuthor("J. Austen");
        System.out.println("Updated EBook Author: " + eBook.getAuthor());
    }
}