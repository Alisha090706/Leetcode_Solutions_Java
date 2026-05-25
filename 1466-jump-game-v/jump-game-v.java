class Solution {
    int n;
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp, -1);
            max = Math.max(max, solve(i, arr, d));
        }
        return max;
    }
    public int solve(int i, int[] arr, int d) {
        if(dp[i] != -1) return dp[i];

        int ans = 1;
        for(int j = i - 1; j >=  Math.max(0, i - d); j--) {
            if(arr[j] >= arr[i]) break;
            ans = Math.max(ans, solve(j, arr, d) + 1);
        }
        for(int j = i + 1; j <=  Math.min(n - 1, i + d); j++) {
            if(arr[j] >= arr[i]) break;
            ans = Math.max(ans, solve(j, arr, d) + 1);
        }

        return dp[i] = ans;
    }
}