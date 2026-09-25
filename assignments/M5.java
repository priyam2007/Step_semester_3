public class M5 {
    public static class Employee {
        private String empName;
        private double salary;
        private static String companyName = "Bright Horizon Technologies";
        private static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Alex", 50000);
        new Employee("Bob", 60000);
        new Employee("Charlie", 70000);
        System.out.println("3 Employee objects created");
        Employee.printCompanyInfo();
    }
}
