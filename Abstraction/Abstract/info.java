package Abstraction.Abstract;

abstract class Animal{
    abstract void sample();

    void infor(){
        System.out.println("This is animal class.");
    }
}

class Cat extends Animal{
    @Override
    void sample(){
        System.out.println("This is cat.");
    }

    void random(){
        System.out.println("Cat meow");
    }
}

public class info {
    public static void main(String[] args){
        Animal cat = new Cat();
        cat.sample();
        cat.infor();
    }
}
