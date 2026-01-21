class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        //Brute Force
        // for(int i = 0 ;i < n ;i++){
        //     for(int j = i +1; j < n ;j++){
        //         if(nums[i] == nums[j]) return nums[i];
        //     }
        // }

        //HashSet
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) return num;
            set.add(num);
        }
        // int totalSum = 0;
        // for(int num: nums) totalSum += num;
        // int sum = 0;
        // for(int i = 1; i < n;i++) sum += i;
        // return totalSum - sum;
        return 0;
    }
}