class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char c1, c2;

        while (left <= right) {
            c1 = Character.toUpperCase(s.charAt(left));

            if (!isAlphaNumeric(c1)) {
                left++;
                continue;
            }

            c2 = Character.toUpperCase(s.charAt(right));

            if (!isAlphaNumeric(c2)) {
                right--;
                continue;
            }

            if (c1 != c2) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isAlphaNumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
