package Inheritance;

class Employee{
    protected String name;
    protected double baseSalary;

    public Employee(String name,double baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public void getBaseSalary(){
        System.out.println("Base Salary for " + name + "is " + baseSalary);
    }
}

class Developer extends Employee{

    protected double overTimePay;
    public Developer(String name, double baseSalary, double overTimePay) {
        super(name, baseSalary);
        this.overTimePay = overTimePay;
    }

    @Override
    public void getBaseSalary(){
        System.out.println("Base Salary for " + name + " is " + (baseSalary+overTimePay));
    }   
}

class Manager extends Employee{
    protected double bonus;

    public Manager(String name, double baseSalary,double bonus){
        super(name,baseSalary);
        this.bonus = bonus;
    }

    @Override
    public void getBaseSalary(){
        System.out.println("Base Salary for " + name + " is " + (baseSalary+bonus));
    }
}

public class Salary {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 50000, 10000);
        Employee developer = new Developer("Bob", 40000, 5000);

        manager.getBaseSalary();
        developer.getBaseSalary();
    }
}
