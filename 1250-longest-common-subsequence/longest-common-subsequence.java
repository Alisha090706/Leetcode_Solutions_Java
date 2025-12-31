class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        dp=new int[m+1][n+1];
        // Approach 1 : Bottom Up
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        // Printing LCS
        StringBuilder sb=new StringBuilder();
        int i=m;
        int j=n;
        while(i!=0 && j!=0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]<dp[i][j-1]){
                    j--;
                }
                else{
                    i--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
        return dp[m][n];

        // for(int[] row:dp) Arrays.fill(row,-1);
        // return solve(text1,text2,m-1,n-1);
    }
    // Approach 2 : Memoization
    // public int solve(String s1,String s2,int i,int j){
    //     if(i<0 ||j<0) return 0;
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return dp[i][j]=1+solve(s1,s2,i-1,j-1);
    //     }

    //     if(dp[i][j]!=-1) return dp[i][j];

    //     return dp[i][j]=Math.max(solve(s1,s2,i-1,j),solve(s1,s2,i,j-1));
    // }
}