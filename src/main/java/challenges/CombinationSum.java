package challenges;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    /**
     * Finds all unique combinations in the array where the numbers sum up to the
     * target.
     * 
     * @param nums   The input array of integers (candidates).
     * @param target The target sum.
     * @return A list of lists, where each inner list is a combination of numbers
     *         that add up to the target.
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to ensure combinations are generated in order.
        backtrack(list, new ArrayList<>(), nums, target, 0); // Start backtracking from index 0.
        return list;
    }

    /**
     * Helper method to perform backtracking.
     * 
     * @param list     The main list to store all valid combinations.
     * @param tempList A temporary list to store the current combination.
     * @param nums     The input array of integers (candidates).
     * @param remain   The remaining target sum to be achieved.
     * @param start    The starting index for the current recursion.
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) // If the remaining sum is negative, stop exploring this path.
            return;
        else if (remain == 0) // If the remaining sum is zero, a valid combination is found.
            list.add(new ArrayList<>(tempList)); // Add a copy of the current combination to the result list.
        else {
            for (int i = start; i < nums.length; i++) { // Iterate through the candidates starting from 'start'.
                tempList.add(nums[i]); // Add the current number to the temporary list.
                // Recurse with the updated remaining sum and the same index 'i' (allow reuse of
                // the same element).
                backtrack(list, tempList, nums, remain - nums[i], i);
                tempList.remove(tempList.size() - 1); // Remove the last added number to backtrack.
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] nums = { 2, 3, 6, 7 }; // Input array of candidates.
        int target = 7; // Target sum.
        List<List<Integer>> result = cs.combinationSum(nums, target);
        System.out.println(result); // Output: [[2, 2, 3], [7]]
    }
}