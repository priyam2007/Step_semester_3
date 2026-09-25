import java.util.*;

public class Problem5 {
    private static final Set<String> STOP_WORDS = new HashSet<>(
        Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    /**
     * Filters stop words and prints word frequencies sorted descending by count.
     */
    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.trim().split("\\s+");

        Map<String, Integer> freqMap = new LinkedHashMap<>();
        for (String w : words) {
            if (w.isEmpty() || STOP_WORDS.contains(w)) continue;
            freqMap.put(w, freqMap.getOrDefault(w, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}
