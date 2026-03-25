class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long total = 0;
        for (int[] row : grid) {
            for (int val : row) {
                total += val;
            }
        }

        //horizontal cut
        long topsum = 0;
        for(int row = 0; row < m - 1; row ++){
            for(int col = 0; col < n; col++) {
                topsum += grid[row][col];
            }
            if(topsum == total - topsum) return true;
        }

        //vertical cut
        long leftsum = 0;
        for(int col = 0; col < n - 1; col++){
            for(int row = 0; row < m; row++){
                leftsum += grid[row][col];
            }
            if(leftsum == total - leftsum) return true;
        }
        return false;
    }
}