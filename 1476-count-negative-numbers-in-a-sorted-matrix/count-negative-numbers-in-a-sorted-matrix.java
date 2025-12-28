class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int[] row : grid){
            if(row[n-1]>=0) continue;
            for(int i = n-1 ; i>=0 ; i--){
                if(row[i] < 0) count++;
                else break;
            }
        }
        return count;
    }
}