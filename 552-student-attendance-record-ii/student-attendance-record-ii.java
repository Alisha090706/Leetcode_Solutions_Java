class Solution {

    int MOD = 1000000007;
    int[][][] dp = new int[100001][2][3]; //dp[day][absent][late];
    //day : how many days processed
    //absent: 0 or 1 (if 2 then invalid)
    //late : 0, 1 and 2 (if 3 then invalid)
    public int checkRecord(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++)
            for (int a = 0; a < 2; a++)
                Arrays.fill(dp[i][a], -1);

        return solve(0,0,0,n);
    }
    public int solve(int day,int absent,int late,int n){
        if(day == n) return 1;

        if(dp[day][absent][late] != -1) return dp[day][absent][late];

        long res = 0;

        res += solve(day+1,absent,0,n);
        if(absent == 0){
            res += solve(day+1,1,0,n);
        }
        if(late < 2){
            res += solve(day+1,absent,late+1,n);
        }
        return dp[day][absent][late] = (int)(res % MOD);
    }
}