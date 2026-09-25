public class Problem5 {
    /**
     * Reverses the given customer name while leaving original untouched.
     */
    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        StringBuilder sb = new StringBuilder(chars.length);
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String name = "Sunil";
        String reversed = reverseCustomerName(name);
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }
}
