class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);
        int max_len = 0;
        int i = 0;
        int j = 0;
        while(j < n){
            while(i < n && (long) nums[i] * k < nums[j]) {
                i++;
            }
            max_len = Math.max(max_len, j - i + 1);
            j++;
        }
        return n - max_len;
    }
}