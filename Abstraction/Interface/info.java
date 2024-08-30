package Abstraction.Interface;

interface Car{
    void speed();
    void sample();
}

class bmw implements Car{
    @Override
    public void speed(){
        System.out.println("BMW provide 300km/hr speed.");
    }
    @Override
    public void sample(){
        System.out.println("Hello! I am Vinay from BMW.");
    }
}

class rr implements Car{
    @Override
    public void speed(){
        System.out.println("RR provide 220km/hr of speed.");
    }
    public void sample(){
        System.out.println("Hello! I am Vinay from RR.");
    }
}

public class info {
    public static void main(String[] args){
        Car bmw = new bmw();
        Car rr = new rr();
        bmw.speed();
        rr.speed();
        bmw.sample();
        rr.sample();
    }
}
