import java.util.Arrays;

public class L4 {
    /**
     * Merges two sorted integer arrays into a single sorted array.
     * Uses two-pointer technique with a while loop.
     */
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int p1 = 0, p2 = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] <= arr2[p2]) {
                result[k++] = arr1[p1++];
            } else {
                result[k++] = arr2[p2++];
            }
        }

        while (p1 < arr1.length) {
            result[k++] = arr1[p1++];
        }

        while (p2 < arr2.length) {
            result[k++] = arr2[p2++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        System.out.println("Merged: " + Arrays.toString(mergeSortedArrays(arr1, arr2)));

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        System.out.println("Merged: " + Arrays.toString(mergeSortedArrays(arr3, arr4)));
    }
}
