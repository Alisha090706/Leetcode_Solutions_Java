class Solution {
    int N;
    int M;
    int K;
    int MOD = 1000000007;
    int[][][] dp;
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        dp = new int[n + 1][k + 1][m + 1];
        for(int[][] matrix : dp){
            for(int[] row : matrix) Arrays.fill(row,-1);
        }
        return solve(0,0,0);
    }
    public int solve(int i, int searchCost, int prev){
        if(i == N){
            return (searchCost == K) ? 1 : 0;
        } 

        if(searchCost > K) return 0;
        if(dp[i][searchCost][prev] != -1) return dp[i][searchCost][prev];
        long ans = 0;
        for(int num = 1; num <= M; num++){
            if(prev < num){
                ans += solve(i+1, searchCost+1, num);
            }
            else{
                ans += solve(i+1, searchCost, prev);
            }
        }

        return dp[i][searchCost][prev] = (int) (ans % MOD);
    }
}