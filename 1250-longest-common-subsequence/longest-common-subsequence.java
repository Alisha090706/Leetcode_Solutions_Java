class Solution {
    int m;
    int n;
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();
        dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0){
            if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                sb.append(text2.charAt(j - 1));
                i--;
                j--;
            }
            else{
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
        return dp[m][n];
    }
    // public int solve(String s, String p, int i, int j){
    //     if(i < 0 || j < 0) return 0;
    //     if(s.charAt(i) == p.charAt(j)){
    //         return dp[i][j] = 1 + solve(s,p,i-1,j-1);
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];
    //     return dp[i][j] = Math.max(solve(s,p,i-1,j), solve(s,p,i,j-1));
    // }
}