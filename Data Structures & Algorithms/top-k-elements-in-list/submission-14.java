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
        Map<Integer, Short> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, (short) (frequencyMap.computeIfAbsent(num, any -> (short) 0) + 1));
        }
        List<Map.Entry<Integer, Short>> entries = new ArrayList<>(frequencyMap.entrySet());
        // Assume it's not immutable list
        entries.sort(Map.Entry.<Integer, Short>comparingByValue().reversed());

        int[] result = new int[k];
        for (int i = 0; i < k && i < entries.size(); i++) {
            result[i] = entries.get(i).getKey();
        }
        return result;
    }
}
