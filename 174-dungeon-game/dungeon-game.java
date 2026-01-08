class Solution {
    int m;
    int n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m][n];
        for(int[] row: dp) Arrays.fill(row , -1);
        return solve(dungeon, 0, 0);
    }
    public int solve(int[][] grid, int i, int j){
        if(i==m-1 && j == n-1){
            if(grid[i][j] <=0){
                return Math.abs(grid[i][j]) + 1;
            }
            else return 1;
        }
        if(i >= m || j >= n) return 1000000000;
        if(dp[i][j] != -1) return dp[i][j];
        int down =  solve(grid, i+1, j);
        int right = solve(grid, i, j+1);
        int curr = grid[i][j];
        int result = Math.min(down, right) - curr;
        return dp[i][j] = (result)<=0? 1 : result;
    }
    
}