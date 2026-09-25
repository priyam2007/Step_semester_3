public class Problem4 {
    /**
     * Helper method to compute the average score for a single row.
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        int sum = 0;
        for (int score : row) {
            sum += score;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies each row as Buzzing Zone or Quiet Zone based on the threshold.
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = avg >= threshold ? "Buzzing Zone" : "Quiet Zone";
            if (i > 0) sb.append(" | ");
            sb.append("Row ").append(i).append(": ").append(zone);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] seating = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        int threshold = 60;
        System.out.println(classifyRows(seating, threshold));
    }
}
