class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        dp=new int[m+1][n+1];
        // Approach 1: Bottom Up
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=i+j;
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    int insert=dp[i][j-1];
                    int delete=dp[i-1][j];
                    int replace=dp[i-1][j-1];
                    dp[i][j]=1+Math.min(insert,Math.min(delete,replace));
                }
            }
        }
        return dp[m][n];

        // for(int i=0;i<=m;i++) Arrays.fill(dp[i],-1);
        // return solve(word1,word2,m,n);
    }

    // Approach 2: Top Down + Recursion
    // public int solve(String s1,String s2,int i,int j){
    //     if(i==0 || j==0) return i+j;
    //     if(s1.charAt(i-1)==s2.charAt(j-1)){
    //         return dp[i][j]=solve(s1,s2,i-1,j-1);
    //     }
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     //insert
    //     int insert=solve(s1,s2,i,j-1);

    //     //delete
    //     int delete=solve(s1,s2,i-1,j);

    //     //replace
    //     int replace=solve(s1,s2,i-1,j-1);

    //     return dp[i][j]=1+Math.min(replace,Math.min(insert,delete));
    // }
}