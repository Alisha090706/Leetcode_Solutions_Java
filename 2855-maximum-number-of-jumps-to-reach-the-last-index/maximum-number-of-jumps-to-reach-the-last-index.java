class Solution {
    int n;
    int tar;
    int[][] dp;
    public int maximumJumps(int[] nums, int target) {
        n = nums.length;
        tar = target;
        dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = solve(nums, 0, 0);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
    public int solve(int[] nums, int i, int steps) {
        if(i >= n) return Integer.MIN_VALUE;
        if(i == n - 1) return steps;

        if(dp[i][steps] != -1) return dp[i][steps];
        int max = Integer.MIN_VALUE;
        for(int j = i + 1; j < n; j++) {
            int diff = nums[j] - nums[i];
            if(diff >= -tar && diff <= tar) {
                int take = solve(nums, j, steps + 1);
                max = Math.max(max, take);
            }
        }

        return dp[i][steps] = max;
    }

}