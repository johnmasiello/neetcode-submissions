class Solution {
    static class Helper {
        int[] targetFrequency = new int[128];
        int[] sparseArray = new int[128];
        int sparseCount = 0;

        Helper(String acceptWord) {
            // initialize the frequencies
            for (int i = 0; i < acceptWord.length(); i++) {
                int index = acceptWord.charAt(i);
                targetFrequency[acceptWord.charAt(i)]++;
            }

            // initialize the sparse array
            for (int i = 0; i < targetFrequency.length; i++) {
                if (targetFrequency[i] > 0) {
                    sparseArray[sparseCount++] = i;
                }
            }
        }

        public boolean isValidWord(int[] currentFrequency) {
            for (int i = 0; i < sparseCount; i++) {
                int idx = sparseArray[i];
                if (currentFrequency[idx] < targetFrequency[idx]) {
                    return false;
                }
            }
            return true;
        }
    }

    public String minWindow(String s, String t) {
        Helper helper = new Helper(t);
        int[] frequencyArray = new int[128];
        int substringStart = 0;
        int substringEnd = 0;
        int minLength = Integer.MAX_VALUE;
        
        for (int right = 0, left = 0; right < s.length(); right++) {
            frequencyArray[s.charAt(right)]++;

            while (helper.isValidWord(frequencyArray) && left <= right) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    substringStart = left;
                    substringEnd = right + 1; // exclusive
                }
                frequencyArray[s.charAt(left)]--;
                left++;
            }
        }

        return s.substring(substringStart, substringEnd);
    }
}
