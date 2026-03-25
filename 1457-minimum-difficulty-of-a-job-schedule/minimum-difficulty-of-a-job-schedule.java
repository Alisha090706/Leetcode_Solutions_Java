class Solution {
    int[][] dp;
    int n;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        dp = new int[n][d + 1];
        for(int[] row: dp) Arrays.fill(row , -1);
        if(n < d) return -1;
        return solve(jobDifficulty,0, d);
    }
    public int solve(int[] job,  int i, int d){
        if(d == 1){
            int max = job[i];
            for(int j = i; j < n; j++){
                max = Math.max(max, job[j]);
            }
            return max;
        }
        if(dp[i][d] != -1) return dp[i][d];
        int maxD=job[i];
        int final_min=Integer.MAX_VALUE;
        for(int j=i;j<=n-d;j++){
            maxD=Math.max(maxD,job[j]);
            int result=maxD+solve(job,j+1,d-1);
            final_min=Math.min(final_min,result);
        }
        return dp[i][d]=final_min;
    }
}