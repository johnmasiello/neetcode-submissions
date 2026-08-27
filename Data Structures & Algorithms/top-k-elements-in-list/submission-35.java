class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // sorted map -> treemap

        /* revised - Problem requirements
        * 1. frequency update by lookup on num
        *
        * 2.sort based on frequency incrementally
        * 
        * Solution: ignore incrementally. Seems like fast lookup needs to take place on number. Sorting will take place on the frequencies in data structure. So I get an O(N Log N) amoritized cost.
        */
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, (frequencyMap.computeIfAbsent(num, any -> 0) + 1));
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue()));

        for (Map.Entry<Integer, Integer> e : frequencyMap.entrySet()) {
            minHeap.add(e);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k && !minHeap.isEmpty(); i++) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
