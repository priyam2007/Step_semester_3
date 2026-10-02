import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem1 {

    // Base class representing a payment transaction
    public abstract static class Payment {
        private final String paymentType;
        private final double amount;

        public Payment(String paymentType, double amount) {
            this.paymentType = paymentType;
            this.amount = amount;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public double getAmount() {
            return amount;
        }

        // Abstract method overridden by subclasses for fee calculation
        public abstract double calculateAdjustedAmount();
    }

    // Card payment: 2% processing fee
    public static class CardPayment extends Payment {
        public CardPayment(double amount) {
            super("CARD", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return getAmount() * 1.02;
        }
    }

    // Wallet payment: 1% processing fee
    public static class WalletPayment extends Payment {
        public WalletPayment(double amount) {
            super("WALLET", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return getAmount() * 1.01;
        }
    }

    // Bank transfer payment: no processing fee
    public static class BankTransferPayment extends Payment {
        public BankTransferPayment(double amount) {
            super("BANKTRANSFER", amount);
        }

        @Override
        public double calculateAdjustedAmount() {
            return getAmount();
        }
    }

    // Factory method for creating payment instances
    public static Payment createPayment(String type, double amount) {
        switch (type.trim().toUpperCase()) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            case "BANKTRANSFER":
                return new BankTransferPayment(amount);
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<Payment> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            transactions.add(createPayment(type, amount));
        }

        double grandTotal = 0.0;
        // Polymorphic processing: calling calculateAdjustedAmount() uniformly
        for (Payment p : transactions) {
            double adjustedAmount = p.calculateAdjustedAmount();
            grandTotal += adjustedAmount;
            System.out.printf(Locale.US, "%s: %.2f%n", p.getPaymentType(), adjustedAmount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);

        sc.close();
    }
}
