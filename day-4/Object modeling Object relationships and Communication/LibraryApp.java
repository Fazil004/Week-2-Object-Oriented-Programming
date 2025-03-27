import java.util.ArrayList;
import java.util.List;

public class LibraryApp {

    static class Book {
        String title;
        String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public void displayBookInfo() {
            System.out.println("Book: " + title + " by " + author);
        }
    }

    static class Library {
        String name;
        List<Book> books;

        public Library(String name) {
            this.name = name;
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void showLibraryBooks() {
            System.out.println("\nLibrary: " + name);
            for (Book b : books) {
                b.displayBookInfo();
            }
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Clean Code", "Robert C. Martin");

        Library cityLibrary = new Library("City Central Library");
        Library collegeLibrary = new Library("Engineering College Library");

        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);

        collegeLibrary.addBook(b2);
        collegeLibrary.addBook(b3);

        cityLibrary.showLibraryBooks();
        collegeLibrary.showLibraryBooks();
    }
}
