class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int best = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i = 1; i < n; i++) {
            if(nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            best = Math.max(best, max);
        }
        return best;
    }
}