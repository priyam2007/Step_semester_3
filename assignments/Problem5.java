public class Problem5 {
    /**
     * Classifies words in a review by length: Short (1-4), Medium (5-8), Long (9+).
     */
    public static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            // Strip any non-alphabetic characters like punctuation from word
            String cleaned = word.replaceAll("[^a-zA-Z]", "");
            int len = cleaned.length();
            if (len == 0) continue;

            if (len <= 4) {
                shortCount++;
            } else if (len <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        String review = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(review);
    }
}
