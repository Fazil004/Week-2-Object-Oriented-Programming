class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to access balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify balance (deposit)
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit of ₹" + amount + " successful. New balance: ₹" + this.balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Public method to modify balance (withdraw)
    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawal of ₹" + amount + " successful. New balance: ₹" + this.balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number (Public): " + accountNumber);
        System.out.println("Account Holder (Protected): " + accountHolder);
        System.out.println("Balance (Private - Accessible via public method): ₹" + getBalance());
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsAccountInfo() {
        System.out.println("--- Savings Account Info ---");
        System.out.println("Account Number (Public - Accessible in subclass): " + accountNumber);
        System.out.println("Account Holder (Protected - Accessible in subclass): " + accountHolder);
        System.out.println("Balance (Private - Accessible via superclass method): ₹" + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest); // Using the public deposit method to update balance
        System.out.println("Interest of ₹" + String.format("%.2f", interest) + " applied.");
    }

    // Example of accessing protected member
    public String getHolderName() {
        return this.accountHolder; // Accessing the protected 'accountHolder' member
    }

    // Example of modifying private member using public methods (deposit/withdraw)
    public void addFunds(double amount) {
        deposit(amount); // Using the public deposit method
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        BankAccount basicAccount = new BankAccount("123456789", "John Doe", 1000.00);
        System.out.println("--- Basic Account Info ---");
        System.out.println("Account Number (Public): " + basicAccount.accountNumber);
        System.out.println("Account Holder (Protected - Not directly accessible here): " + basicAccount.accountHolder);
        System.out.println("Balance (Private - Accessible via public method): ₹" + basicAccount.getBalance());

        // Accessing and modifying balance using public methods
        basicAccount.deposit(500.00);
        basicAccount.withdraw(200.00);
        System.out.println("Current Balance: ₹" + basicAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Jane Smith", 5000.00, 2.5);
        savingsAccount.displaySavingsAccountInfo();

        // Accessing public and protected members from subclass
        System.out.println("Savings Account Number (via subclass): " + savingsAccount.accountNumber);
        System.out.println("Savings Account Holder (via subclass method): " + savingsAccount.getHolderName());

        // Modifying private balance from subclass using public methods
        savingsAccount.addFunds(1000.00);
        savingsAccount.applyInterest();
        System.out.println("Current Savings Account Balance: ₹" + savingsAccount.getBalance());
    }
}