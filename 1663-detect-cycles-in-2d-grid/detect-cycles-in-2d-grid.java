class Solution {
    int m;
    int n;
    int[][] dir = {{0,1}, {1,0}, {-1,0}, {0, -1}};
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && bfs(grid,visited,i,j)) return true;
            }
        }
        return false;
    }
    public boolean bfs(char[][] grid, boolean[][] visited, int i,int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, -1, -1}); // x, y, parentX, parentY
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            int px = curr[2], py = curr[3];

            for(int[] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(grid[nx][ny] != grid[x][y]) continue;

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, x, y});
                } else if(nx != px || ny != py) {
                    return true; // cycle found
                }
            }
        }
        return false;
    }
}