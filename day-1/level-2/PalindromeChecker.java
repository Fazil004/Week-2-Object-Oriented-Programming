import java.util.Scanner;
public class PalindromeChecker {
   private String text;

   public PalindromeChecker(String text) {
       this.text = text;
   }
   public boolean isPalindrome() {
       String reversestr= "";
       for (int i = (text.length()) - 1; i >= 0; i--) {
           reversestr = reversestr + text.charAt(i);
       }
       return text.toLowerCase().equals(reversestr.toLowerCase());
   }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter text : ");
       String text = sc.nextLine();
       PalindromeChecker checker = new PalindromeChecker(text);
       System.out.println(checker.isPalindrome());
       sc.close();
   }
}