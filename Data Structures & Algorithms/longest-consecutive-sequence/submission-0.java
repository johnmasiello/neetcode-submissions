class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxChainLength = 0;

        for (int num : set) {
            int chain = 1;

            // Check if it's a true head in the sequence
            if (!set.contains(num - 1)) {
                while (set.contains(num + chain)) {
                    chain++;
                }
            }
            if (chain > maxChainLength) {
                maxChainLength = chain;
            }
        }
        return maxChainLength;
    }
}
