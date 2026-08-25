class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // string[] -> string[] transform isomorphic representations

        // map<iso, list<string>> -> map.values()

        // Map<string, string> 

        // first pass -> str -> iso; if map containskey iso, then add to list := map.get(iso); list.add(str); otherwise, map.put(iso, new list having str)

        Map<Object, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            Object anagram = anagramNormed(str);
            anagramMap.put(anagram, update(anagramMap.getOrDefault(anagram, new ArrayList<>()), str));
        }
        return new ArrayList<>(anagramMap.values());
    }

    List<Integer> anagramNormed(String str) {
        List<Integer> anagram = new ArrayList<>(Collections.nCopies(26, 0));

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            anagram.set(index, anagram.get(index) + 1);
        }
        return anagram;
    }

    List<String> update(List<String> list, String str) {
        list.add(str);
        return list;
    }
}
