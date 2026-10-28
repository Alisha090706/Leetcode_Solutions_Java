class Solution {
    int m, n;
    int[][][] dp;

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int maxXor = 0;
        for (int[] row : grid) {
            for (int val : row) {
                maxXor |= val;
            }
        }

        int limit = maxXor + 1;
        dp = new int[m][n][limit];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, m - 1, n - 1, 0);
    }

    public int solve(int[][] grid, int i, int j, int xor) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        xor ^= grid[i][j];

        if (i == 0 && j == 0) {
            return xor;
        }

        if (dp[i][j][xor] != -1) {
            return dp[i][j][xor];
        }

        return dp[i][j][xor] = Math.min(
            solve(grid, i - 1, j, xor),
            solve(grid, i, j - 1, xor)
        );
    }
}