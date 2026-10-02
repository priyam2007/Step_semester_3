import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem5 {

    // Base class representing a public transport journey
    public abstract static class Transport {
        private final String transportType;
        private final double distance;

        public Transport(String transportType, double distance) {
            this.transportType = transportType;
            this.distance = distance;
        }

        public String getTransportType() {
            return transportType;
        }

        public double getDistance() {
            return distance;
        }

        // Abstract method overridden by subclasses for specific fare calculations
        public abstract double calculateFare();
    }

    // Bus: Base fare $2, plus $0.10 per km. Max fare $10.
    public static class BusTransport extends Transport {
        public BusTransport(double distance) {
            super("BUS", distance);
        }

        @Override
        public double calculateFare() {
            double fare = 2.0 + (0.10 * getDistance());
            return Math.min(10.0, fare);
        }
    }

    // Train: Base fare $3, plus $0.15 per km.
    public static class TrainTransport extends Transport {
        public TrainTransport(double distance) {
            super("TRAIN", distance);
        }

        @Override
        public double calculateFare() {
            return 3.0 + (0.15 * getDistance());
        }
    }

    // Metro: Base fare $1.50, plus $0.20 per km, multiplied by PeakHourFactor.
    public static class MetroTransport extends Transport {
        private final double peakHourFactor;

        public MetroTransport(double distance, double peakHourFactor) {
            super("METRO", distance);
            this.peakHourFactor = peakHourFactor;
        }

        public double getPeakHourFactor() {
            return peakHourFactor;
        }

        @Override
        public double calculateFare() {
            return (1.50 + (0.20 * getDistance())) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            if (type.equalsIgnoreCase("METRO")) {
                double factor = sc.nextDouble();
                journeys.add(new MetroTransport(distance, factor));
            } else if (type.equalsIgnoreCase("BUS")) {
                journeys.add(new BusTransport(distance));
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journeys.add(new TrainTransport(distance));
            } else {
                throw new IllegalArgumentException("Unknown transport type: " + type);
            }
        }

        double grandTotal = 0.0;
        // Polymorphic processing: calling calculateFare() uniformly
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            grandTotal += fare;
            System.out.printf(Locale.US, "%s: %.2f%n", t.getTransportType(), fare);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);

        sc.close();
    }
}
