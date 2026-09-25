import java.util.Locale;

public class Problem3 {
    /**
     * Classifies health status based on BMI value.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    /**
     * Computes BMI and displays wellness report for a team.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf(Locale.US, "%-10s | %-12.2f | %-12.2f | %-8.2f | %-12s%n",
                    "Person " + (i + 1), h, w, bmi, status);
        }
    }

    public static void main(String[] args) {
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70};
        double[] weights = {70.0, 90.0, 75.0, 50.0, 80.0};
        printWellnessReport(heights, weights);
    }
}
