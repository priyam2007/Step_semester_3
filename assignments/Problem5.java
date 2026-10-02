import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {

    // Base class representing a streaming subscription plan
    public abstract static class SubscriptionPlan {
        private final String subscriberName;
        private final LocalDate startDate;

        public SubscriptionPlan(String subscriberName, LocalDate startDate) {
            this.subscriberName = subscriberName;
            this.startDate = startDate;
        }

        public String getSubscriberName() {
            return subscriberName;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        // Abstract method returning the validity period in days for the plan
        public abstract int getValidityDays();

        // Calculates renewal date polymorphically
        public LocalDate getRenewalDate() {
            return startDate.plusDays(getValidityDays());
        }
    }

    // Basic plan: valid for 30 days
    public static class BasicPlan extends SubscriptionPlan {
        public BasicPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 30;
        }
    }

    // Standard plan: valid for 90 days
    public static class StandardPlan extends SubscriptionPlan {
        public StandardPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 90;
        }
    }

    // Premium plan: valid for 365 days
    public static class PremiumPlan extends SubscriptionPlan {
        public PremiumPlan(String subscriberName, LocalDate startDate) {
            super(subscriberName, startDate);
        }

        @Override
        public int getValidityDays() {
            return 365;
        }
    }

    // Factory method to instantiate subscription plan based on plan type
    public static SubscriptionPlan createPlan(String planType, String name, LocalDate startDate) {
        switch (planType.trim().toUpperCase()) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            case "PREMIUM":
                return new PremiumPlan(name, startDate);
            default:
                throw new IllegalArgumentException("Unknown plan type: " + planType);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<SubscriptionPlan> subscriptions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            String dateStr = sc.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            subscriptions.add(createPlan(planType, name, startDate));
        }

        // Polymorphic processing: calling getRenewalDate() uniformly
        for (SubscriptionPlan sub : subscriptions) {
            LocalDate renewalDate = sub.getRenewalDate();
            System.out.printf("%s: %s%n", sub.getSubscriberName(), renewalDate);
        }

        sc.close();
    }
}
