class Solution {
    int m;
    int n;
    long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        m = robot.size();
        Collections.sort(robot);
        Arrays.sort(factory, (a,b) -> a[0] - b[0]);
        List<Integer> fac = new ArrayList<>();
        for(int[] f: factory) {
            for(int i = 0; i < f[1]; i++) {
                fac.add(f[0]);
            }
        }
        n = fac.size();
        dp = new long[m][n];
        for(long[] row: dp) Arrays.fill(row, -1);
        return solve(robot, 0, fac, 0);
    }
    public long solve(List<Integer> robot, int i, List<Integer> fac, int j) {
        if(i >= m) return 0;
        if(j >= n) return Long.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];
        //take 
        long next = solve(robot, i + 1, fac, j + 1);
        long take = next == Long.MAX_VALUE ? Long.MAX_VALUE 
           : Math.abs(robot.get(i) - fac.get(j)) + next;
        //skip
        long skip = solve(robot, i, fac, j + 1);

        return dp[i][j] = Math.min(take, skip); 
    }
}