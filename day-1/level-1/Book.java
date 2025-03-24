public class Book {
   private String title;
   private String author;
   private int price;

   public Book(String title, String author, int price) {
       this.title = title;
       this.author = author;
       this.price = price;
   }
   public void displayDetails(){
       System.out.println("Title : " + title);
       System.out.println("Author : " + author);
       System.out.println("Price : " + price);
   }
   public static void main (String [] args){
       Book book1 = new Book("JohnsDay", "John Doe", 500);
       book1.displayDetails();
   }
}