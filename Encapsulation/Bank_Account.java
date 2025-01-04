package Encapsulation;
import java.util.Scanner;

class BankAccount{
    private double balance;
    private int accountNumber;
    String accountHolderName;

    public BankAccount(int balance,int accountNumber, String accountHolderName){
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    public void deposite(double amount){
        balance += amount;
        System.out.println("Deposited");
    }
    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
        }
        else{
            System.out.println("Insufficient balance!");
        }
    }
    public double getBalance(){
        return balance;
    }
    public void getAccountInformation(){
        System.out.println(".........Account Details...........");
        System.out.println(".... Name: " + accountHolderName);
        System.out.println(".... Account Number: " + accountNumber);
        System.out.println(".... Current Balance: " + balance);

    }
}

public class Bank_Account{
    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in)) {
            System.out.println("Enter Your Name:");
            String name = myObj.nextLine();
            System.out.println("Enter you bank account:");
            int bankAccount = myObj.nextInt();
            System.out.println("Enter Your Balance:");
            int balance = myObj.nextInt();

            
            BankAccount obj = new BankAccount(balance, bankAccount, name);
            obj.getAccountInformation();
            obj.deposite(2000);
            System.out.println(obj.getBalance());
        }

        // BankAccount obj = new BankAccount(balance, bankAccount, name)
    }
}