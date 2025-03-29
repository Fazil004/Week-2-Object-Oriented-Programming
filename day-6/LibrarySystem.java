import java.util.ArrayList;
import java.util.List;

// Abstract class LibraryItem
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Interface Reservable
interface Reservable {
    void reserveItem(String borrowerName, String borrowerContact);
    boolean checkAvailability();
    String getReservationDetails(); // Added for completeness
}

// Class Book
class Book extends LibraryItem implements Reservable {
    private String ISBN;
    private boolean isAvailable;
    private String borrowerName;  //Encapsulated
    private String borrowerContact; //Encapsulated

    public Book(int itemId, String title, String author, String ISBN) {
        super(itemId, title, author);
        this.ISBN = ISBN;
        this.isAvailable = true;
        this.borrowerName = null;
        this.borrowerContact = null;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public int getLoanDuration() {
        return 21; // Loan duration for books: 21 days
    }

     @Override
    public void reserveItem(String borrowerName, String borrowerContact) {
        if (isAvailable) {
            this.isAvailable = false;
            this.borrowerName = borrowerName;
            this.borrowerContact = borrowerContact;
            System.out.println("Book \"" + getTitle() + "\" reserved successfully by " + borrowerName + ".");
        } else {
            System.out.println("Book \"" + getTitle() + "\" is currently unavailable for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

      @Override
    public String getReservationDetails() {
        if (isAvailable) {
            return "Available";
        } else {
            return "Reserved by: " + borrowerName + ", Contact: " + borrowerContact;
        }
    }


    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("ISBN: " + ISBN);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Availability: " + getReservationDetails());
    }
}

// Class Magazine
class Magazine extends LibraryItem implements Reservable {
    private String issueNumber;
    private boolean isAvailable;
     private String borrowerName;  //Encapsulated
    private String borrowerContact; //Encapsulated

    public Magazine(int itemId, String title, String author, String issueNumber) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.isAvailable = true;
         this.borrowerName = null;
        this.borrowerContact = null;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    @Override
    public int getLoanDuration() {
        return 7; // Loan duration for magazines: 7 days
    }

    @Override
     public void reserveItem(String borrowerName, String borrowerContact) {
        if (isAvailable) {
            this.isAvailable = false;
             this.borrowerName = borrowerName;
            this.borrowerContact = borrowerContact;
            System.out.println("Magazine \"" + getTitle() + "\" reserved successfully by " + borrowerName+ ".");
        } else {
            System.out.println("Magazine \"" + getTitle() + "\" is currently unavailable for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    @Override
    public String getReservationDetails() {
        if (isAvailable) {
            return "Available";
        } else {
            return "Reserved by: " + borrowerName + ", Contact: " + borrowerContact;
        }
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Issue Number: " + issueNumber);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
         System.out.println("Availability: " + getReservationDetails());
    }
}

// Class DVD
class DVD extends LibraryItem implements Reservable{
    private String director;
    private boolean isAvailable;
     private String borrowerName;  //Encapsulated
    private String borrowerContact; //Encapsulated

    public DVD(int itemId, String title, String author, String director) {
        super(itemId, title, author);
        this.director = director;
        this.isAvailable = true;
         this.borrowerName = null;
        this.borrowerContact = null;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public int getLoanDuration() {
        return 3; // Loan duration for DVDs: 3 days
    }

     @Override
    public void reserveItem(String borrowerName, String borrowerContact) {
        if (isAvailable) {
            this.isAvailable = false;
            this.borrowerName = borrowerName;
            this.borrowerContact = borrowerContact;
            System.out.println("DVD \"" + getTitle() + "\" reserved successfully by " + borrowerName +".");
        } else {
            System.out.println("DVD \"" + getTitle() + "\" is currently unavailable for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    @Override
    public String getReservationDetails() {
        if (isAvailable) {
            return "Available";
        } else {
            return "Reserved by: " + borrowerName + ", Contact: " + borrowerContact;
        }
    }

    @Override
    public void getItemDetails() {
        super.getItemDetails();
        System.out.println("Director: " + director);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Availability: " + getReservationDetails());
    }
}

// Main class
public class LibrarySystem {
    public static void main(String[] args) {
        // Create library items
        Book book1 = new Book(101, "The Lord of the Rings", "J.R.R. Tolkien", "978-0547928227");
        Magazine magazine1 = new Magazine(201, "National Geographic", "Various", "April 2024");
        DVD dvd1 = new DVD(301, "Oppenheimer", "Christopher Nolan", "PG-13");

        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(book1);
        libraryItems.add(magazine1);
        libraryItems.add(dvd1);

        // Reserve items
        book1.reserveItem("Alice Smith", "555-1234");
        magazine1.reserveItem("Bob Johnson", "555-5678");
        dvd1.reserveItem("Charlie Williams", "555-9012");
        book1.reserveItem("David Lee", "555-2345"); // Try to reserve already reserved book

        // Display item details
        System.out.println("\n--- Library Item Details ---");
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("----------------------");
        }

         // Check availability
        System.out.println("\n--- Check Availability ---");
        System.out.println("Book \"" + book1.getTitle() + "\" is available: " + book1.checkAvailability());
        System.out.println("Magazine \"" + magazine1.getTitle() + "\" is available: " + magazine1.checkAvailability());
        System.out.println("DVD \"" + dvd1.getTitle() + "\" is available: " + dvd1.checkAvailability());
    }
}