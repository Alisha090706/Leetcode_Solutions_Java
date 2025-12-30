class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        int INF=amount+1;
        for(int i=1;i<=amount;i++) dp[0][i]=INF;

        for(int i=1;i<=n;i++){
            for(int sum=1;sum<=amount;sum++){
                if(sum>=coins[i-1] && dp[i][sum-coins[i-1]]!=INF){
                    dp[i][sum]=Math.min(dp[i-1][sum],1+dp[i][sum-coins[i-1]]);
                }
                else{
                    dp[i][sum]=dp[i-1][sum];
                }
            }
        }
        return dp[n][amount]==INF?-1:dp[n][amount];
        
    }
}