class Solution {
    boolean[][] dp;
    int n;
    public int minCut(String s) {
        n=s.length();
        dp=new boolean[n][n];
        for(int l=1;l<=n;l++){
            for(int i=0;i+l-1<n;i++){
                int j=i+l-1;
                if(i==j) dp[i][j]=true;
                else if(i+1 == j){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }
                else{
                    dp[i][j]=dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                }
            }
        }
        int[] cut = new int[n];
        Arrays.fill(cut,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            if(dp[0][i]){
                cut[i]=0;
                continue;
            }
            for(int k=0;k<i;k++){
                if(dp[k+1][i]){
                    cut[i]=Math.min(cut[i],cut[k]+1);
                }
            }
        }
        return cut[n-1];
    }
}