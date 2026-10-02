import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem2 {

    // Base class representing a parked vehicle
    public abstract static class Vehicle {
        private final String vehicleType;
        private final int hours;

        public Vehicle(String vehicleType, int hours) {
            this.vehicleType = vehicleType;
            this.hours = hours;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public int getHours() {
            return hours;
        }

        // Abstract method overridden by subclasses for specific parking rate calculations
        public abstract double calculateCharge();
    }

    // Bike: ₹10 per hour
    public static class Bike extends Vehicle {
        public Bike(int hours) {
            super("BIKE", hours);
        }

        @Override
        public double calculateCharge() {
            return getHours() * 10.0;
        }
    }

    // Car: ₹30 for the first hour, plus ₹20 for each additional hour
    public static class Car extends Vehicle {
        public Car(int hours) {
            super("CAR", hours);
        }

        @Override
        public double calculateCharge() {
            if (getHours() <= 1) {
                return 30.0;
            }
            return 30.0 + (getHours() - 1) * 20.0;
        }
    }

    // Truck: ₹50 per hour, with a minimum charge of ₹100
    public static class Truck extends Vehicle {
        public Truck(int hours) {
            super("TRUCK", hours);
        }

        @Override
        public double calculateCharge() {
            return Math.max(100.0, getHours() * 50.0);
        }
    }

    // Factory method to instantiate vehicle based on type
    public static Vehicle createVehicle(String type, int hours) {
        switch (type.trim().toUpperCase()) {
            case "BIKE":
                return new Bike(hours);
            case "CAR":
                return new Car(hours);
            case "TRUCK":
                return new Truck(hours);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            vehicles.add(createVehicle(type, hours));
        }

        double grandTotal = 0.0;
        // Polymorphic processing: calling calculateCharge() uniformly
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            grandTotal += charge;
            System.out.printf(Locale.US, "%s: %.2f%n", v.getVehicleType(), charge);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);

        sc.close();
    }
}
