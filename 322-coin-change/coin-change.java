class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        //Approach 1 : Bottom Up
        n=coins.length;
        int INF = amount + 1;
        dp=new int[n+1][amount+1];
        for (int j = 1; j <= amount; j++)
            dp[0][j] = INF;

        for (int i = 1; i <= n; i++)
            dp[i][0] = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1]<=j && dp[i][j-coins[i-1]]!=INF){
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount]==INF?-1:dp[n][amount];

        //Approach 2: Top Down
        // for(int[] row:dp) Arrays.fill(row,-1);
        // int ans=solve(coins,n,amount);
        // return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int solve(int[] coins,int i,int amount){
        if(i==0) return Integer.MAX_VALUE;
        if(amount==0) return 0;

        if(dp[i][amount]!=-1) return dp[i][amount];

        //take the current coin
        int take=Integer.MAX_VALUE;
        if(coins[i-1]<=amount){
            //overflow condition, hence take care of it
            int next=solve(coins,i,amount-coins[i-1]);
            if(next!=Integer.MAX_VALUE){
                take=1+next;
            }
        }

        //skip
        int skip=solve(coins,i-1,amount);

        return dp[i][amount]=Math.min(take,skip);
    }
}