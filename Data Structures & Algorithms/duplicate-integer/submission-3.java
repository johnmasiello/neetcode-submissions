class Solution {
    public boolean hasDuplicate(int[] nums) {
        // The hashing into buckets, using hash set, will take the big O cost to O(n^0)
        Set<Integer> dictionary = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (dictionary.contains(nums[i])) {
                return true;
            }
            dictionary.add(nums[i]);
        }
        return false;
    }
}