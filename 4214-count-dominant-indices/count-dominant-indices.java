class Solution {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        int count = 0;
        for(int i = 0; i < n-1; i++){
            int sum = prefix[n-1] - prefix[i];
            double avg = (double)sum/(n - i -1);
            if(nums[i] > avg) count++;
        }
        return count;
    }
}