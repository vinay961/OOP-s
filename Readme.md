# Object-Oriented Programming in Java

## Overview
Object-Oriented Programming(OOP) is a programming paradigm that centered around objects rather than actions. It is mainly used to make the code more moduler, reusable, and scalable.

- **Class:** A blueprint for creating the objects, It defines properties(fields) and behaviours(methods) that object created from class will have.
- **Object:** An instance of a class, It represent the real-world entity with state and behaviours.

### Example:
 ```bash
      class Car{
        // Fields or state
        String name;
        String model;

        // Constructor
        Car(String name,String model){
            this.name = name;
            this.model = model;
        }

        //Methods or behaviors
        void displayInfo(){
            System.out.println("Car Name: " + name + ",Model: " + model);
        }
      }

      public class Main{
        public static void main(String[] args){
            Car car1 = new Car("BMW","M4");
            car1.displayInfo();
        }
      }
  ```

## Encapsulation
Encapsulation is about how you control the access to the data within class.
In Java, Encapsulation is achieved by using Access Modifier.
There are four main access modifiers.
- **Public:** member is accessible from any other class.
- **Private:** member is accessible within the class itself.
- **Protected:** member is accessible within the package and by subclasses.
- **Default(No modifier):** member is accessible only within the package.

### Example:
  ```bash
        class Account{
          private double balance;

          public Account(double balance){
            if(balance > 0){
              this.balance = balance;
            }
            else{
              System.out.println("Initial balance must be greater than zero".)
            }
          }

          public double getBalance(){
            return balance;
          }

          public void deposite(double amount){
            if(amount > 0){
              balance += amount;
              System.out.println("Deposited: " + amount);
            }
            else{
              System.out.println("Amount should be greater than zero.")
            }
          }

          public void withdraw(double amount){
            if(amount > 0){
              balance -= amount;
              System.out.println("Withdrew: " + amount);
            }
            else{
              System.out.println("Amount should be greater then zero.")
            }
          }
        }

        public class Main{
          public static void main(String[] args){
            Account account = new Account(1000);

            System.out.println("Initial amount in the bank account is: " + account.getBalance());

            account.deposite(300.0);
            System.out.println("Account balance after deposite: " + account.getBalance());

            account.withdraw(700.0);
            System.out.println("Account balance after withdrew: " + account.getBalance());
          }
        }
