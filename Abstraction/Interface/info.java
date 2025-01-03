package Abstraction.Interface;

// Interface defining the contract
interface PaymentGateway {
    void authenticate(String credentials);  // Authentication logic
    boolean makePayment(double amount);     // Payment process
    String getTransactionStatus(String id); // Fetch transaction status
}

class PayPalGateway implements PaymentGateway {
    @Override
    public void authenticate(String credentials) {
        System.out.println("Authenticating with PayPal...");
        // Internal API call to PayPal (hidden from the system)
    }

    @Override
    public boolean makePayment(double amount) {
        System.out.println("Processing payment through PayPal...");
        // Internal logic specific to PayPal
        return true;  // Payment successful
    }

    @Override
    public String getTransactionStatus(String id) {
        return "PayPal transaction status for ID: " + id;  // Hidden logic
    }
}

class StripeGateway implements PaymentGateway {
    @Override
    public void authenticate(String credentials) {
        System.out.println("Authenticating with Stripe...");
        // Internal API call to Stripe (hidden from the system)
    }

    @Override
    public boolean makePayment(double amount) {
        System.out.println("Processing payment through Stripe...");
        // Internal logic specific to Stripe
        return true;  // Payment successful
    }

    @Override
    public String getTransactionStatus(String id) {
        return "Stripe transaction status for ID: " + id;  // Hidden logic
    }
}

class PaymentProcessor {
    private PaymentGateway gateway;

    public PaymentProcessor(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public void processOrder(String credentials, double amount) {
        gateway.authenticate(credentials);  // Hidden logic
        if (gateway.makePayment(amount)) { // Hidden logic
            System.out.println("Payment successful!");
        } else {
            System.out.println("Payment failed!");
        }
    }

    public void checkStatus(String transactionId) {
        System.out.println(gateway.getTransactionStatus(transactionId));  // Hidden logic
    }
}

// Usage
class Main {
    public static void main(String[] args) {
        PaymentGateway paypal = new PayPalGateway();
        PaymentProcessor processor = new PaymentProcessor(paypal);

        processor.processOrder("paypal-credentials", 100.50);
        processor.checkStatus("TXN123456");

        PaymentGateway stripe = new StripeGateway();
        processor = new PaymentProcessor(stripe);

        processor.processOrder("stripe-credentials", 200.75);
        processor.checkStatus("TXN789101");
    }
}
