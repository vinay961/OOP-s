package Abstraction;

abstract class Payment{
    protected double amount;

    public Payment(double amount){
        this.amount = amount;
    }

    public abstract void processPayment();
}

class CreditCardPayment extends Payment{

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of " + amount);
    }
}

class PayPalPayment extends Payment{
    public PayPalPayment(double amount){
        super(amount);
    }

    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment of " + amount);
    }
}

public class payment {
    public static void main(String[] args) {
        Payment payment1 = new CreditCardPayment(500);
        Payment payment2 = new PayPalPayment(750);

        payment1.processPayment();
        payment2.processPayment();
    }
}
