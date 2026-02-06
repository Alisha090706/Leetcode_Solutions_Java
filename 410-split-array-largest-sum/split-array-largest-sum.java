class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int left = nums[0];
        int right = 0;
        for(int num : nums){
            left = Math.max(left,num);
            right += num;
        }

        while(left <= right){
            int mid = left + (right - left)/2;
            int sub = 1;
            int sum = 0;
            for(int num:nums){
                sum += num;
                if(sum > mid){
                    sum = num;
                    sub++;
                }
            }
            if(sub <= k){
                ans = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return ans;
    }
}