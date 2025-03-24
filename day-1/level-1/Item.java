import java.util.Scanner;
public class Item {
   private int itemcode;
   private String itemname;
   private int itemprice;

   public Item(int itemcode, String itemname, int itemprice) {
       this.itemcode = itemcode;
       this.itemname = itemname;
       this.itemprice = itemprice;
   }
   public void displayDetails(){
       System.out.println("Itemcode : " + itemcode);
       System.out.println("Itemname : " + itemname);
       System.out.println("Item Price : " + itemprice);
   }
   public int totalCost (int quantity){
       return quantity * itemprice;
   }
   public static void main (String [] args){
       Scanner sc = new Scanner(System.in);
       int quantity = sc.nextInt();
       Item item = new Item(1, "Item1", 100);
       item.displayDetails();
       System.out.println("Total price of " +quantity+" items : "+item.totalCost(quantity));
   }
}