class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Shrink window if sum becomes too large
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Current subarray has sum = target
            if (sum == target) {
                int len = right - left + 1;

                // Check if there is a previous non-overlapping subarray
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + dp[left - 1]);
                }
            }

            // Carry forward the best answer so far
            if (right > 0) {
                dp[right] = dp[right - 1];
            }

            // Current subarray can become the best
            if (sum == target) {
                int len = right - left + 1;
                dp[right] = Math.min(dp[right], len);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}