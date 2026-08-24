class Solution {
    public int[] twoSum(int[] nums, int target) {
        // naive approach. Let's not first sort or do anything.
        for (int i = 0, newTarget; i < nums.length; i++) {
            newTarget = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == newTarget) {
                    return new int[]{i, j};
                }
            }
        }
        return null;

        // Alternatively, a set approach almost works well too, but you have to know that a given number has a duplicate, for that edge case integral solution is duplicate and target is even. 

        // Other approach is to sort the array O(N * Log N). Then you binary search, but still have to know whether is duplicate. For that in a sorted array, just check if the neighbor is the same value.

        // Given my complexity is O(N^2), I thinking I need to persue the sorted array as the solution.
    }
}
