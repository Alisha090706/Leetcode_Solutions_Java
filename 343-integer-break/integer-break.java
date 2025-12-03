class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    public int solve(int n){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int result=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            int prod=i*Math.max(n-i,solve(n-i));
            result=Math.max(prod,result);
        }
        return dp[n]=result;
    }
}