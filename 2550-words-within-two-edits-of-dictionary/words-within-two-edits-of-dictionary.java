class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for(String q : queries) {
            for(String d: dictionary) {
                if(edits(q, d) <= 2) {
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }
    public int edits(String s1, String s2) {
        int edit = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) edit++;
        }
        return edit;
    }
}