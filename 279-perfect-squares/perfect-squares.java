class Solution {
    int[][] dp;
    public int numSquares(int n) {
        dp = new int[n + 1][(int) Math.sqrt(n) + 1];
        for(int[] row: dp) Arrays.fill(row , -1);
        return solve(n, 1);
    }
    public int solve(int n, int i) {
        if(n == 0) return 0;
        if(n < 0 || i * i > n) return 100000;
        if(dp[n][i] != -1) return dp[n][i];
        //not take 
        int nottake = solve(n, i + 1);

        //int take
        int takeAgain = 1 + solve(n - (i * i), i);
        int takeOnce = 1 + solve(n - (i * i), i + 1);

        return dp[n][i] = Math.min(nottake, Math.min(takeAgain, takeOnce));
    }
}