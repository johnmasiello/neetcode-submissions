class Solution {
    private static final String DELIMETER = "#";
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int wordLength = str.length();
            sb.append(wordLength).append(DELIMETER).append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) throws Exception {
        List<String> arr = new ArrayList<>();
        for (int i = 0, start, end; i < str.length();) {
            start = str.indexOf(DELIMETER, i) + 1;
            String sWordLength = str.substring(i, start - 1);
            int wordLength = Integer.parseInt(sWordLength);
            end = start + wordLength;
            arr.add(str.substring(start, end));
            i = end;
        }
        return arr;
    }
}
