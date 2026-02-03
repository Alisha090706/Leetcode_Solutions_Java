class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if(nums[0] >= nums[1] || nums[n-1] <= nums[n-2] ) return false;
        boolean increasing = true;
        int i = 1;
        int dec = 0;
        while(i < n){
            if(nums[i-1] < nums[i]){
                if(!increasing){
                    dec += 1;
                    increasing = true;
                }
            }
            else if(nums[i - 1] > nums[i]){
                increasing = false;
            }
            else return false;
            i++;
        }
        return increasing && (dec == 1);
    }
}