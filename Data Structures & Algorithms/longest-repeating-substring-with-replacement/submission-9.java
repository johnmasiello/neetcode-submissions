class Solution {
    // Size of the alphabet - uppercase letters
    private static final int M = 26;
    private static final int HEAD_PTR = 0;
    private static final int PREV_INDEX = 1;
    private static final int RUNNING_COUNT = 2;
    private static final int RUNNING_COST = 3;
    private static final int NEXT_PTR = 0;
    private static final int STREAK = 1;

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

        int[][] pointerArray = new int[s.length()][2]; // [N][next ptr, incremental count]
        int[][] runningCountArray = new int[M][4]; // [M][tail ptr, previous index, running count, running cost]
        int maxLength = 0;

        // Initialize Pointers
        for (int i = 0; i < M; i++) {
            runningCountArray[i][HEAD_PTR] = -1; // Set the head pointer to unitialized
        }

        for (int i = 0; i < s.length(); i++) {
            int[] letterAtts = runningCountArray[s.charAt(i) - 'A'];
            int runningCount = 1;

            if (letterAtts[HEAD_PTR] == -1) {
                letterAtts[HEAD_PTR] = i;
                letterAtts[PREV_INDEX] = i;
                letterAtts[RUNNING_COUNT] = 1;
                pointerArray[letterAtts[PREV_INDEX]][STREAK] = 1;

            } else {
                int previousIndex = letterAtts[PREV_INDEX];
                int previousStreak = pointerArray[previousIndex][STREAK];
                int stepCost = i - previousIndex - previousStreak; // step cost is the gap between the previous index (taken from head) of same letter
                runningCount = letterAtts[RUNNING_COUNT] + 1; // Add 1 for current encountered instance of letter

                if (stepCost > 0) {
                    int headPtr = letterAtts[HEAD_PTR];
                    int runningCost = letterAtts[RUNNING_COST] + stepCost;
                    pointerArray[previousIndex][NEXT_PTR] = i; // link same letter pointers to current index. The linking must happen before head pointer traversal.

                    while (runningCost > k) {
                        int streak = pointerArray[headPtr][STREAK];
                        stepCost = pointerArray[headPtr][NEXT_PTR] - headPtr - streak;
                        runningCost -= stepCost;
                        runningCount -= streak; // take away left-most same letter
                        headPtr = pointerArray[headPtr][NEXT_PTR];
                    }

                    // post-update letter attributes
                    letterAtts[HEAD_PTR] = headPtr;
                    letterAtts[PREV_INDEX] = i; 
                    letterAtts[RUNNING_COUNT] = runningCount;
                    letterAtts[RUNNING_COST] = runningCost;
                    pointerArray[i][STREAK] = 1; // start letter on a new streak. Previous index is not at current index

                } else { // case same letter repeats
                    letterAtts[RUNNING_COUNT] = runningCount;
                    pointerArray[previousIndex][STREAK] = previousStreak + 1;
                }
            }

            if (k + runningCount > maxLength) {
                maxLength = k + runningCount; 
            }
        }

        return Math.min(s.length(), maxLength);
    }  
}
