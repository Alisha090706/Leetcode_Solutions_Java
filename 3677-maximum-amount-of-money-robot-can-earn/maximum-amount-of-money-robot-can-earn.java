class Solution {
    int m;
    int n;
    int[][][] dp;
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new int[m][n][3];
        for(int[][] matrix: dp) {
            for(int[] row: matrix) Arrays.fill(row, Integer.MIN_VALUE);
        }
        return solve(coins, 0, 0, 0);
    }
    public int solve(int[][] coins, int row, int col, int neutralCount) {
        if(row >= m || col >= n || neutralCount > 2) return Integer.MIN_VALUE;
        if(row == m - 1 && col == n - 1) {
            if(coins[row][col] >= 0 || neutralCount == 2) return coins[row][col];
            else return 0;
        }
        if(dp[row][col][neutralCount] != Integer.MIN_VALUE) return dp[row][col][neutralCount];
        int curr = coins[row][col];
        if(curr > 0) {
            int right1 = solve(coins, row, col + 1, neutralCount);
            int down1 = solve(coins, row + 1, col, neutralCount);
            return dp[row][col][neutralCount] = curr + Math.max(right1, down1);
        }
        else{
            //case 1: dont neutralize it;
            int right2 = solve(coins, row, col + 1, neutralCount);
            int down2 = solve(coins, row + 1, col, neutralCount);
            int ans1 = curr + Math.max(right2,down2);

            //case 2: neutralize it
            int right3 = solve(coins, row, col + 1, neutralCount + 1);
            int down3 = solve(coins, row + 1, col, neutralCount + 1);
            int ans2 = Math.max(right3,down3);

            return dp[row][col][neutralCount] = Math.max(ans1, ans2);
        }
    }
}