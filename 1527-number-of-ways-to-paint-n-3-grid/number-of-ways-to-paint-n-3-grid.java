class Solution {
    String[] states = {"RGY","RYG","RGR","RYR","YGR","YGY","YRG","YRY","GRG","GYG","GRY","GYR"};
    int[][] dp;
    int MOD = 1000000007;
    public int numOfWays(int n) {
        int answer = 0;

        dp = new int[n][12];
        for(int[] row : dp) Arrays.fill(row,-1);
        for(int i = 0 ;i < 12; i++){
            answer = (answer + solve(n-1,i)) % MOD;
        }

        return answer;
    }
    public int solve(int n, int prev){
        if(n == 0) return 1;

        if(dp[n][prev] != -1) return dp[n][prev]; 
        String last = states[prev];
        int result = 0;

        for(int i = 0; i < 12; i++){
            String curr=states[i];
            if(i == prev) continue;
            boolean conflict=false;
            for(int j = 0; j < 3; j++){
                if(last.charAt(j) == curr.charAt(j)){
                    conflict = true;
                    break;
                }
            }
            if(!conflict){
                result = (result + solve(n-1,i)) % MOD;
            }
        }
        return dp[n][prev] = result;

    }
}