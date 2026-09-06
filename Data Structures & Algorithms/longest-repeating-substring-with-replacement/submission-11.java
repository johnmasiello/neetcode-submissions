class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. Expand window
            count[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency, count[s.charAt(right) - 'A']);

            // 2. Shrink window if replacements needed exceed k
            // Replacements needed = (window size) - (max frequency in window)
            while ((right - left + 1) - maxFrequency > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}