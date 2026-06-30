class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 1;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        int i = 0;
        int j = 0;
        while(j < n) {
            int window = j - i + 1;
            long maxSum = (long)window * nums[j];
            long sum = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
            while(i <= j && maxSum - sum > k) {
                sum -= nums[i];
                i++;
                maxSum = (long)(j - i + 1) * nums[j];
            }
            max = Math.max(max, j - i + 1);
            j++;
            
        }
        return max;
    }
}