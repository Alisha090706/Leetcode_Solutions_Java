class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] mat = new int[m][n];
        int[][] x = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 'X') {
                    mat[i][j] = 1;
                    x[i][j] = 1;
                }
                else if(grid[i][j] == 'Y') mat[i][j] = -1;
                else grid[i][j] = 0;
            }
        }
        for(int i = 1; i < m; i++){
            mat[i][0] += mat[i - 1][0];
            x[i][0] += x[i - 1][0];
        }
        for(int i = 1; i < n; i++){
            mat[0][i] += mat[0][i - 1];
            x[0][i] += x[0][i - 1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                mat[i][j] = mat[i][j] + mat[i - 1][j] + mat[i][j - 1] - mat[i- 1][j - 1];
                x[i][j] = x[i][j] + x[i - 1][j] + x[i][j - 1] - x[i - 1][j - 1];
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                
                if(mat[i][j] == 0 && x[i][j] > 0) count++;
            }
        }
        return count;
    }
}