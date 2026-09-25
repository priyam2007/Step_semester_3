import java.util.Arrays;

public class L5 {
    /**
     * Rotates an array to the right by k steps.
     * Uses modulo arithmetic to place elements in calculated positions.
     */
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        k = k % n;
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Rotated: " + Arrays.toString(rotateArray(nums1, k1)));

        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Rotated: " + Arrays.toString(rotateArray(nums2, k2)));
    }
}
