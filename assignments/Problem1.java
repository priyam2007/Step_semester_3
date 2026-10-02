import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem1 {

    // Base class representing a generic Customer bill
    public abstract static class Customer {
        private final String customerType;
        private final double amount;

        public Customer(String customerType, double amount) {
            this.customerType = customerType;
            this.amount = amount;
        }

        public String getCustomerType() {
            return customerType;
        }

        public double getAmount() {
            return amount;
        }

        // Abstract method overridden by subclasses for specific discount/fee rules
        public abstract double calculateFinalAmount();
    }

    // Student customer: receives a 10% discount
    public static class StudentCustomer extends Customer {
        public StudentCustomer(double amount) {
            super("STUDENT", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return getAmount() * 0.90;
        }
    }

    // Staff customer: receives a 5% discount
    public static class StaffCustomer extends Customer {
        public StaffCustomer(double amount) {
            super("STAFF", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return getAmount() * 0.95;
        }
    }

    // Guest customer: pays full amount plus ₹10 service charge
    public static class GuestCustomer extends Customer {
        public GuestCustomer(double amount) {
            super("GUEST", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return getAmount() + 10.0;
        }
    }

    // Factory method to instantiate the correct customer subtype
    public static Customer createCustomer(String type, double amount) {
        switch (type.trim().toUpperCase()) {
            case "STUDENT":
                return new StudentCustomer(amount);
            case "STAFF":
                return new StaffCustomer(amount);
            case "GUEST":
                return new GuestCustomer(amount);
            default:
                throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            bills.add(createCustomer(type, amount));
        }

        double grandTotal = 0.0;
        // Polymorphic processing: calling calculateFinalAmount() uniformly
        for (Customer bill : bills) {
            double finalAmount = bill.calculateFinalAmount();
            grandTotal += finalAmount;
            System.out.printf(Locale.US, "%s: %.2f%n", bill.getCustomerType(), finalAmount);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);

        sc.close();
    }
}
