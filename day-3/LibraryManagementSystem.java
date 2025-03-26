class Book {
    public static String libraryName;
    public String title;
    public String author;
    public final int isbn; // Declared as final

    static {
        libraryName = "SRM Central Library";
    }

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn; // Initializing the final variable
    }

    public void displayDetails() {
        System.out.println("The book title is :" + title);
        System.out.println("The book author is :" + author);
        System.out.println("The book isbn no is :" + isbn);
        System.out.println("The book is in :" + libraryName);
    }

    public static void displayLibraryName() { // Made static as per requirement
        System.out.println(libraryName);
    }
}

public class LibraryManagementSystem {
    public static void main(String args[]) {
        Book obj1 = new Book("java 8", "Raoul-Gabriel Urma", 978161729);

        if (obj1 instanceof Book) {
            obj1.displayDetails();
        }

        if (obj1 instanceof Book) {
            Book.displayLibraryName(); 
    }
}