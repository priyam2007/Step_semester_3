import java.util.Arrays;

public class Problem1 {
    /**
     * Curves hackathon scores by adding bonus in-place to caller's original array.
     */
    public static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        System.out.println("Original scores: " + Arrays.toString(scores));
        curveScores(scores, 10);
        System.out.println("Curved scores: " + Arrays.toString(scores));
    }
}
