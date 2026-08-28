class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // keeping index at 0 reserved, so we can use the value 0 as sentinel
        int[] dedup = new int[nums.length + 1];
        int[] ptrs = new int[nums.length + 1];

        for (int i = 0, num; i < nums.length;) {
            num = nums[i];
            i++;
            map.put(num, i);
            dedup[i] = num;
        }

        // traversal with eager linking leveraging ptrs for compression of sequences
        // We cannot check for maxchain here, since our sequencing allows us to start from the middle. It will have to be deferred

        // We can actually checks for is head to dynimcally compute max chain

        int maxChainLength = 0;

        for (int num : map.keySet()) {
            int headIndex = map.get(num);

            if (ptrs[headIndex] != 0) { // case this node was already processed in a sequence
                continue;
            }
            ptrs[headIndex] = headIndex; // initially just marking the index of num as 'encountered'

            int nextNum = num + 1;
            Integer tailIndex = map.get(nextNum);

            while (tailIndex != null) {
                int tailPtrIndex = ptrs[tailIndex];

                if (tailPtrIndex != 0) { // case tail is already probed
                    ptrs[headIndex] = tailPtrIndex; // Flattening the ptrs ds
                    break;
                } else {
                    ptrs[headIndex] = tailIndex;
                    ptrs[tailIndex] = tailIndex; // marking index as encountered, so it will be skipped by the outer loop
                }
                // continuing the traversal over tail
                nextNum++;
                tailIndex = map.get(nextNum);
            }

            // Check is is true head node. If so then compute max chain length
            if (map.get(num - 1) == null) {
                int endNum = dedup[ptrs[headIndex]];
                int chainLength = endNum - num + 1;

                if (chainLength > maxChainLength) {
                    maxChainLength = chainLength;
                }
            }
        }
        return maxChainLength;
    }
}
