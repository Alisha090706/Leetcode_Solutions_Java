class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int MOD = 1000_000_007;

        for(int[] query : queries) {
            int idx = query[0];
            int r = query[1];
            int v = query[3];
            int k = query[2];
            while(idx <= r) {
                long prod = (long)nums[idx] * v;
                nums[idx] = (int)(prod % MOD);
                idx += k;
            }
        }

        int ans = nums[0];
        for(int i = 1; i < n; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}