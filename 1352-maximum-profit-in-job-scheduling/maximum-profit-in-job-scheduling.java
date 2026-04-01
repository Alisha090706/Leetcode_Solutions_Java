class Solution {
    int n;
    int[] dp;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;

        int[][] job = new int[n][3];
        for(int i = 0; i < n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
            
        }
        Arrays.sort(job, (a,b) -> a[0] - b[0]);
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(job, 0);
    }
    public int solve(int[][] job, int i) {
        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];
        int nottake = solve(job, i + 1);

        int next = find(job, job[i][1]);
        int take = job[i][2] + solve(job,next);


        return dp[i] = Math.max(take, nottake);
    }
    public int find(int[][] job, int end) {
        int i = 0; 
        int j = n - 1;
        int ans = n;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(job[mid][0] >= end) {
                ans = mid;
                j = mid - 1;
            }
            else i = mid + 1;
        }
        return ans;
    }
}