public class M2 {
    public static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println("Warning: Basic salary cannot be negative. Setting to 0.");
                this.basicSalary = 0.0;
            } else {
                this.basicSalary = basicSalary;
            }
            this.bonus = 0.0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus credit rejected: amount must be positive.");
            } else {
                this.bonus += amount;
                System.out.println("Bonus credited: Rs " + bonus);
            }
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax deduction rejected: invalid percentage.");
            } else {
                this.basicSalary -= (this.basicSalary * percent / 100.0);
                System.out.println("Tax deducted: " + (int) percent + "%");
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {
        PayrollAccount acc = new PayrollAccount(50000);
        acc.creditBonus(5000);
        acc.deductTax(10);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
    }
}
