class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(grid, m-1, n-1);
    }
    public int solve(int[][] grid, int m, int n){
        if(m == 0 && n == 0){
            return grid[0][0];
        }
        if(m < 0 || n < 0) return Integer.MAX_VALUE;
        if(dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = grid[m][n] + Math.min(solve(grid, m-1, n), solve(grid, m, n-1));
    }
}