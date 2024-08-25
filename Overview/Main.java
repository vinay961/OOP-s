package Overview;

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
