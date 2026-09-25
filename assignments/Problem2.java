public class Problem2 {
    /**
     * Reverses each word in a sentence while keeping word order the same.
     */
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            if (i > 0) result.append(" ");
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}
