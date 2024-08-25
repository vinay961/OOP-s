package Encapsulation;

class Account {
    // Private field - cannot be accessed directly from outside the class
    private double balance;

    // Constructor
    public Account(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance must be greater than zero.");
        }
    }

    // Public method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}

// Testing the encapsulation
public class Main {
    public static void main(String[] args) {
        Account account = new Account(500.0); // Creating an Account object with initial balance
        System.out.println("Initial Balance: " + account.getBalance()); // Accessing balance via getter method

        account.deposit(150.0); // Depositing money
        System.out.println("Balance after deposit: " + account.getBalance());

        account.withdraw(200.0); // Withdrawing money
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Direct access to the balance field is not allowed
        // account.balance = 1000; // This line would cause a compilation error
    }
}
