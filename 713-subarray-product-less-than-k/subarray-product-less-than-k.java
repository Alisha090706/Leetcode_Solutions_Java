class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int sub = 0;
        int i = 0;
        int j = 0;
        int prod = 1;
        while(j < n){
            prod *= nums[j];
            while(i <= j  && prod >= k){
                prod /= nums[i];
                i++;
            }
            sub += (j - i + 1);
            j++;
        }
        return sub;
    }
}