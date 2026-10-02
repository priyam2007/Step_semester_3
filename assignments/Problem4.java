import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Problem4 {

    // Base class representing an employee
    public abstract static class Employee {
        private final String name;
        private final double monthlySalary;

        public Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        public String getName() {
            return name;
        }

        public double getMonthlySalary() {
            return monthlySalary;
        }

        // Abstract method overridden by subclasses to calculate festival bonus
        public abstract double calculateBonus();
    }

    // Full-time employee: 10% of monthly salary
    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return getMonthlySalary() * 0.10;
        }
    }

    // Part-time employee: 5% of monthly salary
    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return getMonthlySalary() * 0.05;
        }
    }

    // Intern: fixed bonus of ₹2,000
    public static class InternEmployee extends Employee {
        public InternEmployee(String name, double monthlySalary) {
            super(name, monthlySalary);
        }

        @Override
        public double calculateBonus() {
            return 2000.0;
        }
    }

    // Factory method to instantiate the correct Employee subtype
    public static Employee createEmployee(String type, String name, double salary) {
        switch (type.trim().toUpperCase()) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            case "INTERN":
                return new InternEmployee(name, salary);
            default:
                throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            return;
        }
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            employees.add(createEmployee(type, name, salary));
        }

        double totalBonus = 0.0;
        // Polymorphic processing: calling calculateBonus() uniformly
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            totalBonus += bonus;
            System.out.printf(Locale.US, "%s: %.2f%n", emp.getName(), bonus);
        }
        System.out.printf(Locale.US, "Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}
