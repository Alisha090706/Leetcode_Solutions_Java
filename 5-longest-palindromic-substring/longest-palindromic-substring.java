class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int max=1;
        int idx=0;
        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;
                if(i==j){
                    dp[i][j]=true;
                }
                else if(i+1==j){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }
                else{
                    dp[i][j]=(s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
                }
                if(dp[i][j] && j-i+1>max){
                    max=j-i+1;
                    idx=i;
                }
            }
        }
        return s.substring(idx,idx+max);
    }
}