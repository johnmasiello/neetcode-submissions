class Solution {
    // Size of the alphabet - uppercase letters
    private static final int M = 26;
    private static final int TAIL_PTR = 0;
    private static final int PREV_INDEX = 1;
    private static final int RUNNING_COUNT = 2;
    private static final int RUNNING_COST = 3;

/*

Trace left, right pointers for input s := BABABAAAAAB, k := 3

    B
    BAB
    BABAB
    BABABAAAAAB... -> [advance the left to satisfy running cost <= k]
        BABAAAAAB  cost 6 > 3
        BAAAAAB  cost 5 > 3
                B  cost 0 <= 3
*/
    public int characterReplacement(String s, int k) {
        // space complexity O(M * N). innermost container is a tuple representation

        int[] pointerArray = new int[s.length()]; // [N]
        int[][] runningCountArray = new int[M][4]; // [M][tail ptr, previous index, running count, running cost]
        int maxLength = 0;

        // Initialize Pointers
        for (int i = 0; i < M; i++) {
            runningCountArray[i][TAIL_PTR] = -1; // Set the tail ptr to unitialized
        }

        for (int i = 0; i < s.length(); i++) {
            int[] letterAtts = runningCountArray[s.charAt(i) - 'A'];
            int runningCount = 1;

            if (letterAtts[TAIL_PTR] == -1) {
                letterAtts[TAIL_PTR] = i;
                letterAtts[PREV_INDEX] = i;
                letterAtts[RUNNING_COUNT] = 1;

            } else {
                int stepCost = i - letterAtts[PREV_INDEX] - 1; // step cost is the gap between the previous index (taken from head) of same letter
                int runningCost = letterAtts[RUNNING_COST] + stepCost;
                int tailPtr = letterAtts[TAIL_PTR];

                runningCount = letterAtts[RUNNING_COUNT] + 1; // Add 1 for current encountered instance of letter
                pointerArray[letterAtts[PREV_INDEX]] = i; // link same letter pointers to current index

                while (runningCost > k) {
                    stepCost = pointerArray[tailPtr] - tailPtr - 1;
                    runningCost -= stepCost;
                    runningCount--; // take away left-most same letter
                    tailPtr = pointerArray[tailPtr];
                }

                // post-update letter attributes
                letterAtts[TAIL_PTR] = tailPtr;
                letterAtts[PREV_INDEX] = i; 
                letterAtts[RUNNING_COUNT] = runningCount;
                letterAtts[RUNNING_COST] = runningCost;
            }

            if (k + runningCount > maxLength) {
                maxLength = k + runningCount; 
            }
        }

        return Math.min(s.length(), maxLength);
    }  
}
