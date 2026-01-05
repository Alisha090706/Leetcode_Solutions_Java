class Solution {
    int n;
    // int[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        // Aprroach : Bottom Up
        int len = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    len = Math.max(len, dp[i]);
                }
            }
        }
        return len;
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return solve(nums,0,-1);
    }

    // Approach : Memoization
    // public int solve(int[] nums,int i,int prev){
    //     if(i == n){
    //         return 0;
    //     }
    //     if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];
    //     int take = 0;
    //     if(prev==-1 || nums[prev]<nums[i]){
    //         take =1 + solve(nums,i+1,i);
    //     }
    //     int skip = solve(nums,i+1,prev);
        
    //     if(prev != -1){
    //         dp[i][prev] = Math.max(take,skip);
    //     }
    //     return Math.max(take,skip);
    // }
}