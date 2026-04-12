class Solution {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(s, 0);

    }
    public int solve(String s, int idx) {
        if(idx == n) return 1;

        //if current digit is 0 then no decoding possible;
        if (s.charAt(idx) == '0') return 0;

        if(dp[idx] != -1) return dp[idx];
        int ways = solve(s, idx + 1);

        if(idx + 1 < n) {
            int num = (s.charAt(idx) - '0') * 10 + (s.charAt(idx + 1) - '0');
            if(num >= 10 && num <= 26) {
                ways += solve(s, idx + 2);
            }
        }
        return dp[idx] = ways;
    }
}