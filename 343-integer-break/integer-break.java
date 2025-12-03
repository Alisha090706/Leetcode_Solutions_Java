// Approach 1 : Bottom Up
class Solution {
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],j*Math.max(i-j,dp[i-j]));
            }
        }
        return dp[n];
    }
}

//Approach 2 : Memoization
class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    public int solve(int n){
        //if n==1 then there is no other way to break it.
        if(n==1) return 1;

        //if the answer is already in dp, then return it there only
        if(dp[n]!=-1) return dp[n];
        
        //splitting the number further. Either we will get the max at i*(n-i) or at i*solve(n-i)
        int result=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            int prod=i*Math.max(n-i,solve(n-i));
            result=Math.max(prod,result);
        }

        //storing the result in dp
        return dp[n]=result;
    }
}
