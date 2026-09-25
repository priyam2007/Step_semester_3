public class Problem1 {
    /**
     * Scans seat numbers and reports duplicates using plain nested loops.
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        // Track already reported duplicates to avoid duplicate logs
        boolean[] reported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (reported[i]) continue;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    reported[j] = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] hall1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(hall1);

        int[] hall2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(hall2);
    }
}
