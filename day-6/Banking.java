import java.util.ArrayList;
import java.util.List;

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete methods for deposit and withdraw
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit of ₹" + String.format("%.2f", amount) + " successful. New balance: ₹" + String.format("%.2f", balance));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawal of ₹" + String.format("%.2f", amount) + " successful. New balance: ₹" + String.format("%.2f", balance));
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Abstract method to calculate interest
    public abstract double calculateInterest();

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + String.format("%.2f", balance));
    }
}

// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Subclass SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // per year

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

     @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of ₹" + String.format("%.2f", amount) + " approved for Savings Account " + getAccountNumber());
        } else {
            System.out.println("Loan application of ₹" + String.format("%.2f", amount) + " denied for Savings Account " + getAccountNumber());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 10000; // Example: Balance greater than 10000 is eligible
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate * 100 + "% per year");
    }
}

// Subclass CurrentAccount
class CurrentAccount extends BankAccount implements Loanable{
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0; // Current accounts typically don't earn interest
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            super.withdraw(amount); // Use the superclass's withdraw method
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        }
         else {
            System.out.println("Insufficient balance and overdraft limit.");
        }
    }

     @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan of ₹" + String.format("%.2f", amount) + " approved for Current Account " + getAccountNumber());
        } else {
            System.out.println("Loan application of ₹" + String.format("%.2f", amount) + " denied for Current Account " + getAccountNumber());
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 5000; // Example: Balance greater than 5000 is eligible
    }

    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Overdraft Limit: ₹" + String.format("%.2f", overdraftLimit));
    }
}

// Main class
public class Banking {
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount savingsAccount = new SavingsAccount("SA123", "Alice", 15000.00, 0.04);
        CurrentAccount currentAccount = new CurrentAccount("CA456", "Bob", 8000.00, 20000.00);

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(savingsAccount);
        accounts.add(currentAccount);

        // Deposit and withdraw
        savingsAccount.deposit(2000.00);
        currentAccount.withdraw(10000.00);

        // Apply for loans
        savingsAccount.applyForLoan(20000);
        currentAccount.applyForLoan(30000);


        // Display account information and calculate interest
        System.out.println("\n--- Account Information ---");
        for (BankAccount account : accounts) {
            account.displayAccountInfo();
            double interest = account.calculateInterest();
            System.out.println("Interest: ₹" + String.format("%.2f", interest));
            System.out.println("----------------------");
        }
    }
}