class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // First Pass - initialize index Map
        // Short circuit if the complement in target already exists in map.
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);

            if (j != null && i != j) {
                return new int[] {i, j};
            }
        }
        return null;
    }

    // returns the wrong indexes, since a sort occurred.
    public int[] twoSumzz(int[] nums, int target) {
        // I am allowed to mutate nums, by assumption
        Arrays.sort(nums);

        for (int i = 0, j, newTarget; i < nums.length; i++) {
            newTarget = target - nums[i];
            j = Arrays.binarySearch(nums, newTarget);

            if (j > i) {
                return new int[]{i, j};
            } else if (j == i 
                && i + 1 < nums.length
                && nums[i + 1] == nums[i]) {
                return new int[]{i, i + 1};
            }
        }
        return null;
    }

    public int[] twoSumz(int[] nums, int target) {
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

        // Given my complexity is O(N^2), I thinking I need to pursue the sorted array as the solution.
    }
}
