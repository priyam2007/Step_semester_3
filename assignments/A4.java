import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A4 {
    /**
     * Finds the total number of continuous subarrays whose sum equals k.
     * Uses prefix sums and a hash map for frequency tracking in O(n) time.
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            if (prefixMap.containsKey(currentSum - k)) {
                count += prefixMap.get(currentSum - k);
            }
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Subarray count: " + subarraySum(nums1, k1));

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Subarray count: " + subarraySum(nums2, k2));
    }
}
