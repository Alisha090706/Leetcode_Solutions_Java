class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }
        }
        int max = 0;
        for(int row = 0; row < m; row ++){
            int[] curr = matrix[row].clone();
            Arrays.sort(curr);
            for (int i = n - 1; i >= 0; i--) {
                int height = curr[i];
                int width = n - i;
                max = Math.max(max, height * width);
            }
        }
        return max;
    }
}