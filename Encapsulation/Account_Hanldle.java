package Encapsulation;

import java.util.ArrayList;
import java.util.List;


class Account{
    private String accountNumber;
    private String accountType;
    private double balance;
    private List<String> transactions;

    public Account(String accountNumber, String accountType, double initialBalance){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance!");
        }
        else{
            balance -= amount;
            transactions.add("Withdrew: " + amount);
        }
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(Account targetAccount, double amount){
        if(amount > balance){
            System.out.println("Insufficient Balance");
        }
        else{
            withdraw(amount);
            targetAccount.deposit(amount);
            transactions.add("Transferred: " + amount + " to " + targetAccount.getAccountNumber());
        }
    }

    public void printMiniStatement(){
        System.out.println("Mini Statement for Account: " + accountNumber);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class Account_Hanldle {
    public static void main(String[] args) {
        Account account1 = new Account("12345", "Savings", 1000);
        Account account2 = new Account("67890", "Current", 500);

        account1.deposit(500);
        account1.withdraw(300);

        account1.transfer(account2, 200.00);
        account1.printMiniStatement();
    }
}
