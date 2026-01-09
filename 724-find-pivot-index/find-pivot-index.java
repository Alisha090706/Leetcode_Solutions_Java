class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }
        int currSum = 0;
        for(int i = 0; i < n ; i++){
            int right = totalSum - currSum - nums[i];
            if(currSum == right) return i;
            currSum += nums[i];
        }
        return -1;
    }
}