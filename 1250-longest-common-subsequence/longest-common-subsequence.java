class Solution {
    int m;
    int n;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return solve(text1, text2, m - 1, n - 1);
    }
    public int solve(String s, String p, int i, int j) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == p.charAt(j)) {
            return dp[i][j] =  1 + solve(s, p, i - 1, j - 1);
        }

        return dp[i][j] = Math.max(solve(s, p, i - 1, j), solve(s, p, i, j - 1));
    }
}