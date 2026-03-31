class Solution {
    public int nthUglyNumber(int n) {
        long[] dp = new long[n];
        dp[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        for(int i = 1; i < n; i++) {
            long a = dp[i2] * 2;
            long b = dp[i3] * 3;
            long c = dp[i5] * 5;

            dp[i] = Math.min(a, Math.min(b, c));
            if(dp[i] == a) i2++;
            if(dp[i] == b) i3++;
            if(dp[i] == c) i5++;
        }
        return (int) dp[n - 1];
    }
}