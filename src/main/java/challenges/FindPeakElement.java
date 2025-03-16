package challenges;

/**
 * Find Peak Element
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an array, find any peak element and return its index.
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // Handle array of length 1
        if (nums.length == 1) {
            return 0;
        }

        // Handle first element
        if (nums[0] > nums[1]) {
            return 0;
        }

        // Handle last element
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        // Binary search for peak
        int left = 1;
        int right = nums.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // If left neighbor is greater, search left half
            if (nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
            // Otherwise, search right half
            else {
                left = mid + 1;
            }
        }

        return -1; // Should never reach here given problem constraints
    }

    public static void main(String[] args) {
        // Test cases
        test(new int[] { 1, 2, 3, 1 }); // Expected: 2
        test(new int[] { 1, 2, 4, 3, 5, 6, 4 }); // Expected: 1 or 5
        test(new int[] { 1 }); // Expected: 0
        test(new int[] { 1, 2 }); // Expected: 1
        test(new int[] { 2, 1 }); // Expected: 0
    }

    private static void test(int[] nums) {
        System.out.printf("Input: %s%n", java.util.Arrays.toString(nums));
        int result = findPeakElement(nums);
        System.out.printf("Peak index: %d%n%n", result);
    }
}
