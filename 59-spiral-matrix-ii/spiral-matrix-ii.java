class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = n - 1;
        int number = 1;
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){
                matrix[top][i] = number;
                number++;
            }
            top++;

            for(int i = top; i <= bottom; i++){
                matrix[i][right] = number;
                number++;
            }
            right--;

            if(left <= right){
                for(int i = right; i >= left; i--){
                    matrix[bottom][i] = number;
                    number++;
                }
                bottom--;
            }
            if(top <= bottom){
                for(int i = bottom; i >= top; i--){
                    matrix[i][left] = number;
                    number++;
                }
                left++;
            }
        }
        return matrix;
    }
}