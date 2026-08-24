class Solution {
    public boolean isAnagram(String s, String t) {
        // Two-pass. Sparse array on ascii, assuming just alpha-numeric, and the other symbols included in ascii. Then just increment the incidents in letters in one of the strings. Then decrement at the second pass.

        // Improvement -> use a map of character, incidents. In first pass you increment on the characters. In second pass, if character not present, then fail. Otherwise, decrement. If count is 0, then remove the element from the map. After second pass, return true iff map is empty.

        // Assume not null. No null check.

        Map<Character, Integer> soup = new HashMap<>(8);

        for (int i = 0, newCount; i < s.length(); i++) {
            newCount = Optional.ofNullable(soup.get(s.charAt(i))).map(count -> count + 1).orElse(1);
            soup.put(s.charAt(i), newCount);
        }

        Integer count;
        for (int i = 0; i < t.length(); i++) {
            count = soup.get(t.charAt(i));

            // required letter is missing
            if (count == null) {
                return false;
            }
            count -= 1;

            if (count == 0) {
                soup.remove(t.charAt(i));
            } else {
                soup.put(t.charAt(i), count);
            }
        }
        return soup.isEmpty();
    }
}
