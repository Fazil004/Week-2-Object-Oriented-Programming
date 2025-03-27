import java.util.ArrayList;
import java.util.List;

public class BankApp {

    static class Customer {
        private String name;
        private double balance;
        private Bank bank;

        public Customer(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        public void setBank(Bank bank) {
            this.bank = bank;
        }

        public String getName() {
            return name;
        }

        public double getBalance() {
            return balance;
        }

        public void viewBalance() {
            System.out.println(name + " has ₹" + balance + " in " + bank.getBankName());
        }
    }

    static class Bank {
        private String bankName;
        private List<Customer> customers;

        public Bank(String bankName) {
            this.bankName = bankName;
            this.customers = new ArrayList<>();
        }

        public void openAccount(Customer customer) {
            customers.add(customer);
            System.out.println(customer.getName() + " opened an account at " + bankName);
        }

        public String getBankName() {
            return bankName;
        }

        public void listCustomers() {
            System.out.println("\nCustomers of " + bankName + ":");
            for (Customer c : customers) {
                System.out.println("- " + c.getName());
            }
        }
    }

    public static void main(String[] args) {
        Bank hdfc = new Bank("HDFC Bank");
        Customer fz = new Customer("fz", 25000);
        Customer yz = new Customer("yz", 15000);

        fz.setBank(hdfc);
        yz.setBank(hdfc);

        hdfc.openAccount(fz);
        hdfc.openAccount(yz);

        fz.viewBalance();
        yz.viewBalance();

        hdfc.listCustomers();
    }
}
