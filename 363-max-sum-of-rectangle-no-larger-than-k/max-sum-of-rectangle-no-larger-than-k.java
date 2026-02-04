class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int ans = Integer.MIN_VALUE;
        for(int left = 0; left < n; left++){
            int[] rowSum = new int[m];
            for (int right = left; right < n; right++) {
                // Compress rows between left and right
                for (int row = 0; row < m; row++) {
                    rowSum[row] += matrix[row][right];
                }

                // Find max subarray sum <= k in rowSum
                ans = Math.max(ans, maxSubArrayNoMoreThanK(rowSum, k));

                // Early exit if best possible found
                if (ans == k) return k;
            }
        }
        return ans;
        
    }
    private int maxSubArrayNoMoreThanK(int[] nums, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        for (int num : nums) {
            sum += num;

            // We want smallest prefix >= sum - k
            Integer prev = set.ceiling(sum - k);
            if (prev != null) {
                max = Math.max(max, sum - prev);
            }

            set.add(sum);
        }
        return max;
    }
}