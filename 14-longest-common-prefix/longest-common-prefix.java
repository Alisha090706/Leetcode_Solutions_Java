class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int minlen = strs[0].length();
        String s = strs[0];
        for(int i = 1; i < n; i++){
            int len = check(s, strs[i]);
            minlen = Math.min(minlen, len);
        }
        return s.substring(0, minlen);
    }
    public int check(String s, String p){
        int m = s.length();
        int n = p.length();
        if(m > n) return check(p, s);
        int len = 0;
        int i = 0;
        while(i < m){
            if(s.charAt(i) == p.charAt(i)){
                len++;
                i++;
            }
            else break;
        }
        return len;
    }
}