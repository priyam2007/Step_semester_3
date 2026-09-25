import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3 {
    /**
     * Finds all unique triplets in the array which gives the sum of zero.
     * Uses sorting and two pointers while avoiding duplicate triplets.
     */
    public static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1));
        int[][] res1 = threeSum(nums1);
        System.out.println("Triplets: " + Arrays.deepToString(res1));

        int[] nums2 = {0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums2));
        int[][] res2 = threeSum(nums2);
        System.out.println("Triplets: " + Arrays.deepToString(res2));
    }
}
