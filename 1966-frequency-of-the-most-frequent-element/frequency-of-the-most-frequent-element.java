class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 1;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
        for(int i = 1; i < n; i++) {
            int left = 0;
            int right = i;
            while(left <= right) {
                int mid = left + (right - left) / 2;
                int expsum = (i - mid + 1) * nums[i];
                int sum = prefix[i] - (mid - 1 >= 0 ? prefix[mid - 1] : 0);
                if(expsum - sum <= k) {
                    max = Math.max(max, i - mid + 1);
                    right = mid - 1;
                }

                else {
                    left = mid + 1;
                }
            }
        }
        return max;
    }
}