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