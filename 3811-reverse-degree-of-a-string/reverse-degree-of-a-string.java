class Solution {
    public int reverseDegree(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count += (i + 1) * (26 - (c - 'a'));
        }
        return count;
    }
}