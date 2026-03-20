class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        for(int i = 0; i <= m - k; i++){
            for(int j = 0; j <= n - k; j++){
                ArrayList<Integer> arr = new ArrayList<>();
                for(int row = i; row < i + k; row ++){
                    for(int col = j; col < j + k; col++){
                        if(arr.contains(grid[row][col])) continue;
                        arr.add(grid[row][col]);
                    }
                }
                Collections.sort(arr);
                int minDiff = Integer.MAX_VALUE;
                
                for(int a = 1; a < arr.size(); a++){
                    minDiff = Math.min(minDiff, arr.get(a) - arr.get(a - 1));
                }
                
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }
        return ans;
    }
}