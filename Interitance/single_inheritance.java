package Interitance;

class Employee{
    String name;
    int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
    void DisplayDetails(){
        System.out.print("Employee Name: " + name + " , ID: " + id);
    }
}

class Developer extends Employee{
    String programming_language;

    Developer(String name, int id, String programming_language){
        super(name, id);
        this.programming_language = programming_language;
    }

    void writeCode() {
        System.out.println(name + " writes code in " + programming_language);
    }
}

public class single_inheritance {
    public static void main(String[] args) {
        Developer dev = new Developer("Alice", 101, "Java");
        dev.DisplayDetails();
        dev.writeCode();
    }
}
