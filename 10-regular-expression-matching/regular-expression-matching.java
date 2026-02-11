class Solution {
    int m;
    int n;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        return solve(s, p, 0, 0);
    }
    public boolean solve(String s, String p, int i, int j){
        if(j == n) return i == m;
        
        //check if current matches
        boolean firstmatch = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        //check if next is "*"
        char next = (j + 1 < n) ? p.charAt(j+1):'$';
        if(next == '*'){
            //two choices
            //skip
            //use

            boolean skip = solve(s, p, i, j + 2);
            boolean use = firstmatch && solve(s, p, i+1, j);
            return skip || use;
        }
        return firstmatch && solve(s, p, i+1, j+1);
    }
}