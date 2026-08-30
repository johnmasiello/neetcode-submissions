class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        int[] lastNaturalIndexOfLetter = new int[128];
        int boundary = 0;

        // a b c a
        // 0 1 2 3
        // boundary 0

        // a b c b
        // 0 1 2 3
        // boundary 0

        // a c a c
        // 0 1 2 3
        // boundary 0

        // Invariant: lowest index of substring > boundary
        for (int i = 0; i < s.length(); i++) {
            if (lastNaturalIndexOfLetter[s.charAt(i)] > boundary) {
                if (i - boundary > maxLength) {
                    maxLength = i - boundary;
                }

                boundary = lastNaturalIndexOfLetter[s.charAt(i)];
            }
            lastNaturalIndexOfLetter[s.charAt(i)] = i + 1; // We are projecting index -> (index + 1) to maintain invariant
        }

        // Post update for when there is no repeating character at the end of the array
        if (s.length() - boundary > maxLength) {
            maxLength = s.length() - boundary;
        }

        return maxLength;
    }
}
