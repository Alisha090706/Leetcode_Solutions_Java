class Solution {
    int m;
    int n;
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
    
        dp = new Boolean[m][n][m + n];
        if(grid[0][0] == ')' || grid[m - 1][n - 1] == '(' ) return false;
        return solve(grid, 0, 0, 0);
    }
    public boolean solve(char[][] grid, int i, int j, int balance) {
        if(i >= m || j >= n) return false;
        
        char bracket = grid[i][j];
        if(bracket == '(') balance++;
        else balance --;

        if(i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if(balance < 0) return false;
        
        if(dp[i][j][balance] != null) return dp[i][j][balance];

    
        boolean right = solve(grid, i, j + 1, balance);
        boolean down = solve(grid, i + 1, j, balance);
        return dp[i][j][balance] = right || down;

    }
}