package animals;

public class Animals {
    public String name;      
    protected String species; 
    private int age;        
    
    public Animals(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public static void main(String[] args) {
        Animals animal = new Animals("Cat", "mammal", 23);
        Random random = new Random();
        random.check(animal);
    }
}

class Random{
    public void check(Animals animal){
        System.out.println(animal.species);
    }
}
