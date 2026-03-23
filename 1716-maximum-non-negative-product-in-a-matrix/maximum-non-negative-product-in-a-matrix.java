class Solution {
    public int maxProductPath(int[][] grid) {
        int MOD = 1000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        max[0][0] = min[0][0] = grid[0][0];
        for(int i = 1; i < n; i++){
            min[0][i] = grid[0][i] * min[0][i-1];
            max[0][i] = grid[0][i] * max[0][i-1];
        }
        for(int i = 1; i < m; i++){
            min[i][0] = grid[i][0] * min[i - 1][0];
            max[i][0] = grid[i][0] * max[i - 1][0];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                long minleft = min[i][j - 1];
                long maxleft = max[i][j - 1];
                long minup = min[i - 1][j];
                long maxup = max[i - 1][j];

                int curr = grid[i][j];

                long maxcurr = Math.max(Math.max(curr * minleft, curr * minup),
                                        Math.max(curr * maxup, curr * maxleft));
                long mincurr = Math.min(Math.min(curr * minleft, curr * minup),
                                        Math.min(curr * maxup, curr * maxleft));
                
                min[i][j] = mincurr;
                max[i][j] = maxcurr;
            }
        }
        int ans = (int)(max[m - 1][n - 1] % MOD);
        return ans < 0 ? -1 : ans;
    }
}