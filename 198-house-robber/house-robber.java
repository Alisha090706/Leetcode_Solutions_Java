class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(nums,n-1);
    }
    public int solve(int[] nums,int n){
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int take = nums[n] + solve(nums,n-2);

        int skip = solve(nums,n-1);

        return dp[n] = Math.max(take,skip);
    }
}