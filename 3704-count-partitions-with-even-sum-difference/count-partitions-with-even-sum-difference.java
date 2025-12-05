class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;

        //calculating total sum
        int totalSum=0;
        for(int num:nums) totalSum+=num;

        //prefix sum
        int currsum=0;

        int count=0;

        //currsum stores the sum of elements till ith index
        for(int i=0;i<n-1;i++){
            currsum+=nums[i];
            int right=totalSum-currsum;
            if((currsum-right)%2==0) count++;
        }

        return count;
    }
}