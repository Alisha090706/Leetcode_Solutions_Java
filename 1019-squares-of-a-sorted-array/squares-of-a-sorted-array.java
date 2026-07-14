class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int idx = n - 1;
        int[] result = new int[n];
        while(idx >= 0) {
            int sql = nums[l] * nums[l];
            int sqr = nums[r] * nums[r];
            if(sql < sqr) {
                result[idx] = sqr;
                r--;
            }
            else{
                result[idx] = sql;
                l++;
            }
            idx --;
        }
        return result;
    }
}