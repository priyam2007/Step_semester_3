import java.util.Locale;

public class Problem2 {
    /**
     * Checks accuracy of typed text against original passage.
     */
    public static void checkTypingAccuracy(String original, String typed) {
        int n = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < n; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-indexed position
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matched / original.length()) * 100.0;

        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | ", matched, original.length(), accuracy));

        if (firstMismatchPos != -1) {
            sb.append(String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origChar, typedChar));
        } else if (original.length() != typed.length()) {
            sb.append(String.format("First Mismatch at position %d (length mismatch)", n + 1));
        } else {
            sb.append("No Mismatches");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
