import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

    // Base class representing a library item
    public abstract static class LibraryItem {
        private final String title;
        private static final LocalDate BASE_DATE = LocalDate.of(2023, 10, 26);

        public LibraryItem(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        // Abstract method returning the borrowing period in days
        public abstract int getBorrowingPeriodDays();

        // Calculates due date polymorphically
        public LocalDate calculateDueDate() {
            return BASE_DATE.plusDays(getBorrowingPeriodDays());
        }
    }

    // Book: 14 days
    public static class Book extends LibraryItem {
        public Book(String title) {
            super(title);
        }

        @Override
        public int getBorrowingPeriodDays() {
            return 14;
        }
    }

    // DVD: 7 days
    public static class DVD extends LibraryItem {
        public DVD(String title) {
            super(title);
        }

        @Override
        public int getBorrowingPeriodDays() {
            return 7;
        }
    }

    // Magazine: 3 days
    public static class Magazine extends LibraryItem {
        public Magazine(String title) {
            super(title);
        }

        @Override
        public int getBorrowingPeriodDays() {
            return 3;
        }
    }

    // Factory method for creating library item instances
    public static LibraryItem createLibraryItem(String itemType, String title) {
        switch (itemType.trim().toUpperCase()) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new DVD(title);
            case "MAGAZINE":
                return new Magazine(title);
            default:
                throw new IllegalArgumentException("Unknown item type: " + itemType);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String itemType = sc.next();
            String rawTitle = sc.nextLine().trim();
            // Remove surrounding quotes if present
            if (rawTitle.startsWith("\"") && rawTitle.endsWith("\"") && rawTitle.length() >= 2) {
                rawTitle = rawTitle.substring(1, rawTitle.length() - 1);
            }
            items.add(createLibraryItem(itemType, rawTitle));
        }

        // Polymorphic processing: calling calculateDueDate() uniformly
        for (LibraryItem item : items) {
            System.out.printf("%s: %s%n", item.getTitle(), item.calculateDueDate());
        }

        sc.close();
    }
}
