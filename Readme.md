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
          private String name;
          private double id;

          public Account(double balance,String name, double id){
            this.balance = balance>0 ? balance:0;
            this.name = name;
            this.id = is;
          }

          public double getBalance(){
            return balance;
          }

          public double accountHolder(){
            return name;
          }

          public void setAccountHolderName(String name){
            if(name != null && !name.trim().isEmpty()){
              this.name = name;
            }
            else {
              System.out.println("Invalid accountHolder name.")
            }
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
            if(amount > 0 && this.balance > amount){
              balance -= amount;
              System.out.println("Withdrew: " + amount);
            }
            else if (amount > this.balance){
              System.out.println("Insufficient Balance")
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
  ```

## Inheritance
The mechanism by which one class (child or subclass) can inherit the properties of other class (parent or superclass). It helps in code reusability and method overriding.

To acheive this `extends` keyword is used.

### Example:
   ```bash
        class Animal{
          void eat(){
            System.out.println("This animal eat foods.");
          }
        }

        class Dog extends Animal{
          void bark(){
            System.out.println("The dog barks.");
          }
        }

        public class Main{
          public static void main(String[] args){
            Dog dog = new Dog();
            dog.eat(); // Access the parent class method
            dot.bark();
          }
        }
  ```


  ## Polymorphism
  The ability of single function to work in different ways depending on the context.
  
  It is of two types:
  - **Compile-time Polymorphism** Multiple methods with same name but different parameters. Also know as `Method Overloading`.

  - **Runtime Polymorphism** A subclass provides specific implementation of a method already defined in its superclass. Also know as `Method Overriding`.

  ### Example:
   ```bash
   ## Method overloading

   class Add{
    int addFun(int a,int b){
      return a+b;
    }

    double addFun(double a,double b){
      return a+b;
    }
   }

   public class Main{
    public static void main(String[] args){
      Add add new Add();
      add.addFun(2,3);
      add.addFun(3.2,4.1);
    }
   }
  ```

  ### Example:
   ```bash
      ## Method overriding

      class Parent{
        void display(){
          System.out.println("This is Parent class.");
        }
      }
      class Child extends Parent{
        void display(){
          System.out.println("This is Child class.");
        }
        void sample(){
          System.out.println("This is another method in child class.");
        }
      }

      public class Main{
        public static void main(String[] args){
          Parent obj = new Child(); // Upcasting
          obj.display(); // output: This is child class.

          ## upcasting??..
          obj.sample(); // Error
        }
      }
  ```

`Upcasting` --> In the upcasting, we give reference of parent class to the child class, like in above code when we write `Parent obj = new Child()`, then we create object of child class but give the reference of parent class, so when child method is present in parent class, then only it get executed.That is why we got error when trying to execute the sample method.


