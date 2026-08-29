class Solution {
    public boolean isValid(String s) {
        // "([{}])"
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ("({[".contains("" + c)) {
                stack.push(c);
            } else if (")}]".contains("" + c)) {
                if (stack.isEmpty() || !isClosingBracket(stack.pop(), c)) { // satisifies 1. Every open bracket is closed by the same type of close bracket
                    // ...and 2. Open brackets are closed in the correct order.
                    return false;
                }
            }
        }
        return stack.isEmpty(); // satisfies: 3. Every close bracket has a corresponding open bracket of the same type.
    }
    static boolean isClosingBracket(char openBracket, char closedBracket) {
        return (openBracket == '(' && closedBracket == ')')
          || (openBracket == '{' && closedBracket == '}')
          || (openBracket == '[' && closedBracket == ']');
    }
}
