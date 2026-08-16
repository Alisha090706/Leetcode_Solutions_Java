class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String sorted = new String(letters);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for(String s : map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }
}