import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem3 {

    // Base class representing a delivery request
    public abstract static class Delivery {
        private final String deliveryType;
        private final double weight;
        private final double distance;

        public Delivery(String deliveryType, double weight, double distance) {
            this.deliveryType = deliveryType;
            this.weight = weight;
            this.distance = distance;
        }

        public String getDeliveryType() {
            return deliveryType;
        }

        public double getWeight() {
            return weight;
        }

        public double getDistance() {
            return distance;
        }

        // Abstract method overridden by subclasses for specific fee calculations
        public abstract double calculateFee();
    }

    // Standard Delivery: Base fee $5, plus $0.50 per kg, plus $0.10 per km
    public static class StandardDelivery extends Delivery {
        public StandardDelivery(double weight, double distance) {
            super("STANDARD", weight, distance);
        }

        @Override
        public double calculateFee() {
            return 5.0 + (0.50 * getWeight()) + (0.10 * getDistance());
        }
    }

    // Express Delivery: Base fee $20 ($5 standard + $15 express surcharge), plus $1.00 per kg, plus $0.20 per km
    public static class ExpressDelivery extends Delivery {
        public ExpressDelivery(double weight, double distance) {
            super("EXPRESS", weight, distance);
        }

        @Override
        public double calculateFee() {
            return 20.0 + (1.00 * getWeight()) + (0.20 * getDistance());
        }
    }

    // International Delivery: Base fee $35 ($20 express tier + $15 international surcharge), plus $2.00 per kg, plus $0.50 per km, plus CustomsFee
    public static class InternationalDelivery extends Delivery {
        private final double customsFee;

        public InternationalDelivery(double weight, double distance, double customsFee) {
            super("INTERNATIONAL", weight, distance);
            this.customsFee = customsFee;
        }

        public double getCustomsFee() {
            return customsFee;
        }

        @Override
        public double calculateFee() {
            return 35.0 + (2.00 * getWeight()) + (0.50 * getDistance()) + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            if (type.equalsIgnoreCase("INTERNATIONAL")) {
                double customsFee = sc.nextDouble();
                deliveries.add(new InternationalDelivery(weight, distance, customsFee));
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, distance));
            } else if (type.equalsIgnoreCase("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, distance));
            } else {
                throw new IllegalArgumentException("Unknown delivery type: " + type);
            }
        }

        double grandTotal = 0.0;
        // Polymorphic processing: calling calculateFee() uniformly
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            grandTotal += fee;
            System.out.printf(Locale.US, "%s: %.2f%n", d.getDeliveryType(), fee);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);

        sc.close();
    }
}
