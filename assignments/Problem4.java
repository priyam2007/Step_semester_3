public class Problem4 {
    /**
     * Helper method to calculate the average score of a row/match.
     */
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        return (double) sum / row.length;
    }

    /**
     * Classifies matches as Power Surge or Normal based on average runs per over.
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = avg >= threshold ? "Power Surge" : "Normal";
            if (i > 0) sb.append(" | ");
            sb.append("Match ").append(i).append(": ").append(status);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] runs = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;
        System.out.println(classifyMatches(runs, threshold));
    }
}
