class Solution {
    int n;
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        n=coins.length;
        dp=new int[n+1][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int ans=solve(coins,n,amount);
        return ans==Integer.MAX_VALUE?-1:ans;
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