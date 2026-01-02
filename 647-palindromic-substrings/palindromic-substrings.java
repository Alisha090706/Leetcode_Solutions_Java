class Solution {
    int n;
    // Boolean[][] dp;
    public int countSubstrings(String s) {
        n=s.length();
        boolean[][] dp=new boolean[n][n];
        int count=0;
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
                if(dp[i][j]) count++;
            }
        }
        
        return count;
    }

    // Approach 2: Memoization
    // public boolean checkpalindrome(String s,int i,int j){
    //     if(i>j) return true;
    //     if(dp[i][j]!=null) return dp[i][j];
    //     if(s.charAt(i)==s.charAt(j)){
    //         return dp[i][j]=checkpalindrome(s,i+1,j-1);
    //     }
    //     return dp[i][j]=false;
    // }
}