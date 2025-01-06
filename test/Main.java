package test;
import animals.*;

public class Main {
    public static void main(String[] args) {
        Animals animal = new Animals("Cat", "mammal", 21);
        System.out.println(animal.name);
        // System.out.println(animal.species);  protected member is not visible here

        Dog dog = new Dog("Bull", "mammal", 12);
        dog.printDetails();
    }
}
