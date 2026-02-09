class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int row = 0; row < m-1; row++){
            for(int i = 0; i < n-1; i++){
                int curr = matrix[row][i];
                int col = i;
                for(int j = row; j < m; j++){
                    if(col == n) break;
                    if(matrix[j][col] != curr)return false;
                    col++;
                }
            }
        }
        return true;
    }
}