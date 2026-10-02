import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem3 {

    // Base class representing a room's electricity bill
    public abstract static class Room {
        private final String roomType;
        private final int units;

        public Room(String roomType, int units) {
            this.roomType = roomType;
            this.units = units;
        }

        public String getRoomType() {
            return roomType;
        }

        public int getUnits() {
            return units;
        }

        // Abstract method overridden by subclasses to calculate bill per occupant/room
        public abstract double calculateBill();
    }

    // Single room: ₹8 per unit
    public static class SingleRoom extends Room {
        public SingleRoom(int units) {
            super("SINGLE", units);
        }

        @Override
        public double calculateBill() {
            return getUnits() * 8.0;
        }
    }

    // Shared room: ₹6 per unit, divided equally by number of occupants
    public static class SharedRoom extends Room {
        private final int occupants;

        public SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = occupants;
        }

        public int getOccupants() {
            return occupants;
        }

        @Override
        public double calculateBill() {
            return (getUnits() * 6.0) / occupants;
        }
    }

    // AC room: ₹10 per unit, plus fixed ₹200 charge
    public static class AcRoom extends Room {
        public AcRoom(int units) {
            super("AC", units);
        }

        @Override
        public double calculateBill() {
            return (getUnits() * 10.0) + 200.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String roomType = sc.next();
            int units = sc.nextInt();
            if (roomType.equalsIgnoreCase("SHARED")) {
                int occupants = sc.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (roomType.equalsIgnoreCase("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (roomType.equalsIgnoreCase("AC")) {
                rooms.add(new AcRoom(units));
            } else {
                throw new IllegalArgumentException("Unknown room type: " + roomType);
            }
        }

        double grandTotal = 0.0;
        // Polymorphic processing: calling calculateBill() uniformly
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf(Locale.US, "%s: %.2f%n", r.getRoomType(), bill);
        }
        System.out.printf(Locale.US, "Total: %.2f%n", grandTotal);

        sc.close();
    }
}
