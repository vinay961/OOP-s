package Polymorphism;

abstract class Items{
    protected String name;
    protected int price;

    public Items(String name, int price){
        this.name = name;
        this.price = price;
    }

    abstract void calculatePrice();
}

class GroceryItem extends Items{
    private double discount;

    public GroceryItem(String name,int price,double discount){
        super(name, price);
        this.discount = discount;
    }

    @Override
    void calculatePrice(){
        System.out.println("Price of " + name + " is " + (price-discount));
    }
}

class ElectronicsItem extends Items{
    private double warrantyCost;

    public ElectronicsItem(String name,int price,double warrantyCost){
        super(name, price);
        this.warrantyCost = warrantyCost;
    }

    @Override
    public void calculatePrice(){
        System.out.println("Price of " + name + " is " + (price+warrantyCost));
    }
}


public class Item {
    public static void main(String[] args) {
        Items obj1 = new GroceryItem("Rice", 120, 10);
        Items obj2 = new ElectronicsItem("Earphone", 250, 35);

        obj1.calculatePrice();
        obj2.calculatePrice();
    }
}
