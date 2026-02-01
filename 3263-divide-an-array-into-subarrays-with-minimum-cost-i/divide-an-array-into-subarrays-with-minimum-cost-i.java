class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            if(nums[i] <= min){
                secondmin = min;
                min = nums[i];
            }
            else if(nums[i] > min && nums[i] < secondmin){
                secondmin = nums[i];
            }
        }
        return nums[0] + min + secondmin;
    }
}