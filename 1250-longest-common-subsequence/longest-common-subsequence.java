class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        dp=new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(text1,text2,m-1,n-1);
    }
    public int solve(String s1,String s2,int i,int j){
        if(i<0 ||j<0) return 0;
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=1+solve(s1,s2,i-1,j-1);
        }

        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j]=Math.max(solve(s1,s2,i-1,j),solve(s1,s2,i,j-1));
    }
}