class Solution {
    private static final int[] CLOSING_MAP;
    private static final boolean[] IS_OPEN_BRACKET;
    private static final boolean[] IS_CLOSED_BRACKET;

    static {
        CLOSING_MAP = new int[128];
        CLOSING_MAP['('] = ')';
        CLOSING_MAP['{'] = '}';
        CLOSING_MAP['['] = ']';

        IS_OPEN_BRACKET = new boolean[128];
        IS_OPEN_BRACKET['('] = true;
        IS_OPEN_BRACKET['{'] = true;
        IS_OPEN_BRACKET['['] = true;

        IS_CLOSED_BRACKET = new boolean[128];
        IS_CLOSED_BRACKET[')'] = true;
        IS_CLOSED_BRACKET['}'] = true;
        IS_CLOSED_BRACKET[']'] = true;
    }

    public boolean isValid(String s) {
        // "([{}])"
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (IS_OPEN_BRACKET[c]) {
                stack.push(c);
            } else if (IS_CLOSED_BRACKET[c]) {
                if (stack.isEmpty() || !isClosingBracket(stack.pop(), c)) { // satisifies 1. Every open bracket is closed by the same type of close bracket
                    // ...and 2. Open brackets are closed in the correct order.
                    return false;
                }
            }
        }
        return stack.isEmpty(); // satisfies: 3. Every close bracket has a corresponding open bracket of the same type.
    }
    static boolean isClosingBracket(char openBracket, char closedBracket) {
        return CLOSING_MAP[openBracket] == closedBracket;
    }
}
