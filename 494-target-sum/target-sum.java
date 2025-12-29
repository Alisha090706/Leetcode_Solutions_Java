class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int total=0;
        for(int num:nums)total+=num;
        if((total+target)%2!=0 || total<Math.abs(target))return 0;
        int sum=(total+target)/2;
        int[][] dp=new int[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int s=0;s<=sum;s++){
                if(s>=nums[i-1]){
                    dp[i][s]=dp[i-1][s-nums[i-1]]+dp[i-1][s];
                }
                else{
                    dp[i][s]=dp[i-1][s];
                }
            }
        }
        return dp[n][sum];
    }
}