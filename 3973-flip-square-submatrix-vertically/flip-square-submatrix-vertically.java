class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for(int col = y; col < y + k; col++){
            reverse(grid, col, x, x + k - 1);
        }
        return grid;
    }
    public void reverse(int[][] grid, int col, int srow, int erow){
        while(srow < erow) {
            int temp = grid[srow][col];
            grid[srow][col] = grid[erow][col];
            grid[erow][col] = temp;
            srow ++;
            erow --;
        }
    }
}