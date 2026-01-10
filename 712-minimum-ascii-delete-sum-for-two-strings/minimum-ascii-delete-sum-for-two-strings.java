class Solution {
    int[][] dp;
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            dp[i][0] = (int)s1.charAt(i-1) + dp[i-1][0];
        }
        for(int i = 1; i <= n; i++){
            dp[0][i] = (int)s2.charAt(i-1) + dp[0][i-1];
        }

        for(int i = 1;i<=m; i++){
            for(int j= 1; j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int take_one = s1.charAt(i-1) + dp[i-1][j];
                    int take_two = s2.charAt(j-1) + dp[i][j-1];
                    dp[i][j]= Math.min(take_one,take_two);
                }
            }
        }
        return dp[m][n];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return solve(s1,s2,m,n);
    }
    public int solve(String s1,String s2,int i,int j){
        if(i == 0){
            int result = 0;
            for(int k = j;k>0;k--){
                result += s2.charAt(k-1);
            }
            return result;
        }
        if(j == 0){
            int result = 0;
            for(int k = i;k>0;k--){
                result += s1.charAt(k-1);
            }
            return result;
        }
        if(dp[i][j] !=-1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = solve(s1,s2,i-1,j-1);
        }
        
        int take_one = (int)s1.charAt(i-1) + solve(s1,s2,i-1,j);
        int take_two = (int)s2.charAt(j-1) + solve(s1,s2,i,j-1);

        return dp[i][j] = Math.min(take_one,take_two);
    }
}