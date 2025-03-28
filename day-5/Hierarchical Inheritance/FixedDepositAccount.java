class BankAccount {
    String accountNumber;
    double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + String.format("%.2f", balance));
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }

    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of ₹" + String.format("%.2f", interest) + " added. New balance: ₹" + String.format("%.2f", balance));
    }

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 10000.00, 0.05);
        savingsAccount.displayAccountInfo();
        savingsAccount.displayAccountType();
        savingsAccount.calculateInterest();
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }

    public void checkWithdrawalLimit(double amount) {
        if (amount <= withdrawalLimit) {
            System.out.println("Withdrawal amount within limit.");
        } else {
            System.out.println("Withdrawal amount exceeds the limit.");
        }
    }

    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount("CA456", 5000.00, 2000.00);
        checkingAccount.displayAccountInfo();
        checkingAccount.displayAccountType();
        checkingAccount.checkWithdrawalLimit(2500.00);
    }
}

class FixedDepositAccount extends BankAccount {
    int tenureYears;

    public FixedDepositAccount(String accountNumber, double balance, int tenureYears) {
        super(accountNumber, balance);
        this.tenureYears = tenureYears;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }

    public void displayTenure() {
        System.out.println("Tenure: " + tenureYears + " years");
    }

    public static void main(String[] args) {
        FixedDepositAccount fdAccount = new FixedDepositAccount("FD789", 20000.00, 3);
        fdAccount.displayAccountInfo();
        fdAccount.displayAccountType();
        fdAccount.displayTenure();
    }
}