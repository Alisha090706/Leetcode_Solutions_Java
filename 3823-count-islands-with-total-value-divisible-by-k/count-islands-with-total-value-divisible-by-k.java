class Solution {
    int m;
    int n;
    long sum;
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum = 0L;
                if(grid[i][j] != 0 && !visited[i][j]) {
                    solve(grid, i, j, visited);
                    if(sum % k == 0) count++;
                }
            }
        }
        return count;
    }
    public void solve(int[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0) return;

        sum += grid[i][j];
        visited[i][j] = true;

        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, 1, -1};

        for(int k = 0; k < 4; k++) {
            solve(grid, i + row[k], j + col[k], visited);
        }
    }
}