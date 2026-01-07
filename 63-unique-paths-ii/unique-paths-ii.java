class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return solve(obstacleGrid,m-1,n-1);
    }
    public int solve(int[][] grid, int m, int n){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0 || grid[m][n] == 1) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = solve(grid, m-1, n) + solve(grid, m, n-1);
    }
}