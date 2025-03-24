import java.util.Scanner;
public class BankAccount {
   private String accountHolder;
   private int accountNumber;
   private double balance;

   public BankAccount(String accountHolder, int accountNumber, double balance) {
       this.accountHolder = accountHolder;
       this.accountNumber = accountNumber;
       this.balance = balance;
   }
   public void deposit(double depAmount) {
       this.balance += depAmount;
       System.out.println("Deposited amount : " + depAmount);
       System.out.println("balance : " +getBalance());
   }
   public void withdraw(double withAmount) {
       if (withAmount < this.balance) {
           this.balance -= withAmount;
           System.out.println("Withdrawn amount : " + withAmount);
           System.out.println("balance : " + getBalance());
       }else{
           System.out.println("Insufficient balance");
       }
   }
   public double getBalance() {
       return balance;
   }
    public static void main (String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter accountholder name, accountnumber, balance : ");
       BankAccount account = new BankAccount(sc.next(), sc.nextInt(), sc.nextDouble());
       System.out.println("Enter action '1' to deposit, '2' to withdraw, '3' to check balance : ");
       int action = sc.nextInt();
       if(action == 1) {
           System.out.println("enter amount to deposit");
           account.deposit(sc.nextDouble());
       }
       else if(action == 2) {
           System.out.println("enter amount to withdraw");
           account.withdraw(sc.nextDouble());
       }
       else if(action == 3) {
           System.out.println("the balance is " + account.getBalance());
       } else {
           System.out.println("Invalid action");
       }

       sc.close();
    }
}