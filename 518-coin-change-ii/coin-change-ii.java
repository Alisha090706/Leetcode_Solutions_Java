class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        for(int[] row: dp) Arrays.fill(row , -1);
        return solve(coins, coins.length - 1, amount);
    }
    public int solve(int[] coins, int i, int amount) {
        if(amount < 0 || i < 0) return 0;
        if(amount == 0) return 1;

        if(dp[i][amount] != -1) return dp[i][amount];
        int takeSameCoin = solve(coins, i, amount - coins[i]);
        int moveToNextCoin = solve(coins, i - 1, amount);

        return dp[i][amount] = takeSameCoin + moveToNextCoin;
    }
}