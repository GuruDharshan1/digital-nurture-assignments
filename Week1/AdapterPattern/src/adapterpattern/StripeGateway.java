package adapterpattern;

public class StripeGateway {
    public void executeTransaction(double amount) {
        System.out.println("Paid ₹" + amount + " using Stripe.");
    }
}
