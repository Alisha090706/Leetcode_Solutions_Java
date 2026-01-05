class Solution {
    int n;
    // int[][] dp;
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(pairs,(a,b)-> a[0]-b[0]);

        int len = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1] < pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    len=Math.max(dp[i],len);
                }
            }
        }
        return len;
        // for(int[] row : dp) Arrays.fill(row,-1);
        // return solve(pairs,0,-1);
    }

    // Approach : Memoization
    // public int solve(int[][] pairs,int i,int prev){
    //     if(i>=n) return 0;

    //     if(prev!=-1 && dp[i][prev]!=-1) return dp[i][prev];

    //     int take = 0;
    //     if(prev==-1 || pairs[prev][1]<pairs[i][0]){
    //         take = 1 + solve(pairs,i+1,i);
    //     }
    //     int skip = solve(pairs,i+1,prev);
    //     if(prev!=-1){
    //         return dp[i][prev]= Math.max(skip,take);
    //     }
    //     return Math.max(skip,take);
    // }
}