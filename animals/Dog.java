package animals;

public class Dog extends Animals {
    public Dog(String name, String species, int age) {
        super(name, species, age);
    }
    public void printDetails() {
        System.out.println("Name: " + name);   
        
        System.out.println("Species: " + species); 
        
        // System.out.println("Age: " + age); 
    }

    // public static void main(String[] args) {
    //     Dog dog = new Dog("Bull", "mammal", 21);
    //     dog.printDetails();
    // }
}
