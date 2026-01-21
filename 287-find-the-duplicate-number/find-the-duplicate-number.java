class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // int i = 0 ;
        // int j = n-1;
        // while(i < j){
        //     int mid = i + (j -i)/2;
        //     int count = 0;
        //     for(int num:nums){
        //         if(num <= mid) count++;
        //     }
        //     if(count > mid){
        //         j = mid;
        //     }
        //     else{
        //         i = mid+1;
        //     }
        // }
        // return i;

        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
            
        }while(slow!=fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}