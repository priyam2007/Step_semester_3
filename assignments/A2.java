import java.util.Arrays;

public class A2 {
    /**
     * Finds the contiguous subarray with the largest sum using Kadane's algorithm.
     */
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Max Subarray Sum: " + maxSubArray(nums1));

        int[] nums2 = {-3, -1, -2};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Max Subarray Sum: " + maxSubArray(nums2));
    }
}
