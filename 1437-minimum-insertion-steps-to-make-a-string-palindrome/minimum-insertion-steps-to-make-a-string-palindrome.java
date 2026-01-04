class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        int n = s.length();
        if(n == 1) return 0;
        dp = new int[n][n];
        for(int L = 2; L <= n; L++){
            for(int i = 0; i + L -1 < n; i++){
                int j = i+L-1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];

        // for(int[] row : dp) Arrays.fill(row,-1);
        // return solve(s,0,n-1);
    }

    // Approach 2: Memoization
    // public int solve(String s, int i, int j){
    //     if(i > j) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(s.charAt(i) == s.charAt(j)){
    //         return dp[i][j] = solve(s, i+1, j-1);
    //     }

    //     return dp[i][j] =1 + Math.min(solve(s, i+1, j), solve(s, i, j-1));
    // }
}