class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int last_idx = 0;
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(dp[i] > maxlen){
                maxlen = dp[i];
                last_idx = i;
            }
        }
        result.add(nums[last_idx]);
        while(parent[last_idx] != last_idx){
            last_idx = parent[last_idx];
            result.add(nums[last_idx]);
        }
        return result;
    }
}