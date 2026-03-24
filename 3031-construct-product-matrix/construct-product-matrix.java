class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = 12345;
        int[][] p = new int[n][m];
        int prefix = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                p[i][j] = prefix;
                prefix = (int)((1L * prefix * grid[i][j]) % MOD);
            }
        }
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j --){
                
                p[i][j] = (p[i][j] * suffix) % MOD;
                suffix = (int)((1L * suffix * grid[i][j]) % MOD);
            }
        }
        return p;
        
    }
}