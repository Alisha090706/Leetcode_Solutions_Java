class Solution {
    int MOD = 1000000007;
    Long[][][] dp;
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        max[0][0] = min[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            max[i][0] = min[i][0] = max[i-1][0] * grid[i][0];
        }
        for(int j = 1; j < n; j++){
            max[0][j] = min[0][j] = max[0][j-1] * grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1;j < n; j++){
                long a = max[i-1][j] * grid[i][j];
                long b = min[i-1][j] * grid[i][j];
                long c = max[i][j-1] * grid[i][j];
                long d = min[i][j-1] * grid[i][j];
                max[i][j] = Math.max(Math.max(a,b),Math.max(c,d));
                min[i][j] = Math.min(Math.min(a,b),Math.min(c,d));
            }
        }
        if(max[m-1][n-1] < 0) return -1;
        return (int)(max[m-1][n-1] % MOD);
        
        // dp = new Long[m][n][2];
        // long result = solve(grid,m-1,n-1)[0];
        // if(result < 0) return -1;
        // return (int)(result % MOD);
    }
    public long[] solve(int[][] grid, int m ,int n){
        if(m == 0 && n==0){
            return new long[]{grid[0][0],grid[0][0]};
        }
        if(m<0 || n<0){
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        if(dp[m][n][0] != null) return new long[]{dp[m][n][0],dp[m][n][1]};

        long[] up = solve(grid,m-1,n);
        long[] left= solve(grid,m,n-1);


        long val = grid[m][n];

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        // from up
        if (up[0] != Long.MIN_VALUE) {
            max = Math.max(max, up[0] * val);
            min = Math.min(min, up[0] * val);
        }
        if (up[1] != Long.MAX_VALUE) {
            max = Math.max(max, up[1] * val);
            min = Math.min(min, up[1] * val);
        }

        // from left
        if (left[0] != Long.MIN_VALUE) {
            max = Math.max(max, left[0] * val);
            min = Math.min(min, left[0] * val);
        }
        if (left[1] != Long.MAX_VALUE) {
            max = Math.max(max, left[1] * val);
            min = Math.min(min, left[1] * val);
        }

        return new long[]{max,min};
    }
}