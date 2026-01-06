class Solution {
    int n;
    // long[][] dp;
    public long maxBalancedSubsequenceSum(int[] nums) {
        n = nums.length;
        int max = nums[0];
        for(int num: nums){
            max = Math.max(max,num);
        }
        if(max <= 0) return max;
        long ans = Long.MIN_VALUE;
        TreeMap<Long,Long> map = new TreeMap<>();

        for(int i = 0; i < n; i++){
            long key = (long) nums[i] - i;

            Map.Entry<Long, Long> prev = map.floorEntry(key);

            long currsum = nums[i] + (prev == null?0 : prev.getValue());

            currsum = Math.max(currsum, nums[i]);

            long old = map.getOrDefault(key, Long.MIN_VALUE);
            if(currsum > old){
                map.put(key, currsum);
            }

            while(true){
                Map.Entry<Long,Long> next = map.higherEntry(key);
                if(next != null && next.getValue() <= currsum){
                    map.remove(next.getKey());
                }
                else break;
            }
            ans = Math.max(ans, currsum);
        }
        return ans;
        // dp = new long[n][n];
        // for(long[] row: dp) Arrays.fill(row, -1);
        // return solve(nums,0,-1);
    }

    // Example : [4, 8, 5, 8]
    // map = {}
    // ans = -inf
    // i = 0{
    //     nums[i] - i = 4 - 0;
    //     prev = null;
    //     currsum = 4;
    //     map = {4 -> 4}
    //     higher = null;
    //     ans = 4;
    // }
    // i = 1{
    //     nums[i] - i = 8 - 1 = 7;
    //     prev = 4
    //     currsum = 12
    //     map = {4 -> 4, 7 -> 12}
    //     higher = null;
    //     ans = 12;
    // }
    // i = 2{
    //     nums[i] - i = 5 - 2 = 3
    //     prev = null
    //     currsum = 5;
    //     map = {3 -> 5, 4 -> 4, 7 -> 12}
    //     higher = 4
    //     remove 4
    //     map = {3 -> 5, 7 -> 12}
    //     ans = 12
    // }
    // i = 3{
    //     nums[i] - i = 8 - 3 = 5
    //     prev = 3
    //     currsum = 5 + 8 = 13
    //     map = {3 -> 5, 5 -> 13, 7 -> 12}
    //     higher = 7 
    //     remove 7
    //     map = {3 -> 5, 5 -> 13}
    //     ans = 13;
    // }
    // Final Answer = 13

    // DP - Memoiation ( gives TLE )
    // public long solve(int[] nums,int i,int prev){
    //     if(i == n){
    //         return 0;
    //     }
    //     if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];
    //     long take = Long.MIN_VALUE;
    //     if(prev == -1 || nums[prev] - prev <= nums[i] - i){
    //         take = nums[i] + solve(nums,i+1,i);
    //     }
    //     long skip = solve(nums,i+1,prev);

    //     if(prev != -1){
    //         return dp[i][prev] = Math.max(skip, take);
    //     }
    //     return Math.max(take, skip);
    // }
}