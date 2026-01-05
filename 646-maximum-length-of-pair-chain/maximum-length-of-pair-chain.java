class Solution {
    int n;
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        dp = new int[n][n];
        Arrays.sort(pairs,(a,b)-> a[0]-b[0]);
        for(int[] row : dp) Arrays.fill(row,-1);
        return solve(pairs,0,-1);
    }
    public int solve(int[][] pairs,int i,int prev){
        if(i>=n) return 0;

        if(prev!=-1 && dp[i][prev]!=-1) return dp[i][prev];

        int take = 0;
        if(prev==-1 || pairs[prev][1]<pairs[i][0]){
            take = 1 + solve(pairs,i+1,i);
        }
        int skip = solve(pairs,i+1,prev);
        if(prev!=-1){
            return dp[i][prev]= Math.max(skip,take);
        }
        return Math.max(skip,take);
    }
}