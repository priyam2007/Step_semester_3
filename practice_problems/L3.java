import java.util.Arrays;

public class L3 {
    /**
     * Checks if any value appears at least twice in the array.
     * Uses nested loops for pairwise comparison.
     */
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Contains Duplicate: " + containsDuplicate(nums2));
    }
}
