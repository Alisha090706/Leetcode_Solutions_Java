class Solution {
    int m;
    int n;
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();
        return bfs(grid, health);
    }
    public boolean bfs(List<List<Integer>> grid, int health) {
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        q.add(new int[]{0, 0, health - grid.get(0).get(0)});
        int[][] best = new int[m][n];
        for (int[] row : best)
            Arrays.fill(row, -1);

        best[0][0] = health - grid.get(0).get(0);
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];
            int h = curr[2];

            if(i == m - 1 && j == n - 1) return true;

            for(int[] d: directions) {
                int i_ = i + d[0];
                int j_ = j + d[1];

                if(i_ < 0 || i_ >= m || j_ < 0 || j_ >= n || h - grid.get(i_).get(j_) <= 0 ) continue;
                int newHealth = h - grid.get(i_).get(j_);
                if(newHealth <= 0) continue;

                if(newHealth <= best[i_][j_]) {
                    continue;
                }
                best[i_][j_] = newHealth;
                q.add(new int[]{i_, j_, newHealth});

            }
        }
        return false;
    }
}