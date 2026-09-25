public class Problem2 {
    /**
     * Approach 1: Iterative two-pointer check.
     */
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive substring check.
     */
    public static boolean isPalindromeRecursive(String text) {
        if (text == null || text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Character array reversal check.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void checkAndPrint(String word) {
        boolean it = isPalindromeIterative(word);
        boolean rec = isPalindromeRecursive(word);
        boolean rev = isPalindromeArrayReversal(word);

        System.out.println("\"" + word + "\"");
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                it ? "Palindrome" : "Not Palindrome",
                rec ? "Palindrome" : "Not Palindrome",
                rev ? "Palindrome" : "Not Palindrome");
    }

    public static void main(String[] args) {
        checkAndPrint("madam");
        checkAndPrint("hello");
    }
}
