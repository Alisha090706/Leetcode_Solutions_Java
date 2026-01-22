class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n]; // product till index i
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] * nums[i];
        } 

        // product except itself == prefix[i-1] * suffix[i+1];
        int suffix = 1;
        int[] result = new int[n];
        for(int i = n - 1; i > 0; i--){
            result[i] = prefix[i-1] *suffix;
            suffix *= nums[i];
        }
        result[0] = suffix;
        return result;
    }
}