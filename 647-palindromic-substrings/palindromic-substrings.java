class Solution {
    int n;
    Boolean[][] dp;
    public int countSubstrings(String s) {
        n=s.length();
        dp=new Boolean[n][n];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(checkpalindrome(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean checkpalindrome(String s,int i,int j){
        if(i>j) return true;
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=checkpalindrome(s,i+1,j-1);
        }
        if(dp[i][j]!=null) return dp[i][j];
        return dp[i][j]=false;
    }
}