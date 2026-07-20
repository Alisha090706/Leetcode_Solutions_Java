class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int len = m * n;
        int[] list = new int[len];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int curridx = i * n + j;
                int newidx = (curridx + k) % len;
                list[newidx] = grid[i][j];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            result.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int num = list[i * n + j];
                result.get(i).add(num);
            }
        }
        return result;
    }
}