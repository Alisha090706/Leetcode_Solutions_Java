class Solution {
    int n;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n][n];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        return solve(nums, 0, -1);
    }
    public int solve(int[] nums, int i, int prev) {
        if(i == n) return 0;
        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];
        //take
        int take = 0;
        if(prev == -1 || nums[prev] < nums[i]) {
            take = 1 + solve(nums, i + 1, i);
        }
        //skip
        int skip = solve(nums, i + 1, prev);
        if(prev != -1) dp[i][prev] = Math.max(skip, take);
        return Math.max(take, skip);
    }
}