class Solution {
    int n;
    int m;
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        n = s.length();
        m = p.length();
        dp = new Boolean[n][m];
        return solve(s, p, 0, 0);
    }
    public boolean solve(String s, String p, int i, int j){
        if(j == m){
            return i == n;
        }
        if(i == n){
            for(int k = j; k < m; k++){
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) return dp[i][j] = solve(s, p, i+1, j+1);
        
        if(p.charAt(j) == '*'){
            boolean take = solve(s, p, i + 1, j);
            boolean skip = solve(s, p, i, j + 1);
            return dp[i][j] = take || skip;
        }
        return dp[i][j] = false;
    }
}