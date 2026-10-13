class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0) nums[i]=-nums[i];
        }
        Arrays.sort(nums);
        long ans=0;
        int i=0;
        int j=n-1;
        while(i<j){
            ans+= (long)nums[j]*nums[j] - (long)nums[i]*nums[i];
            j--;
            i++;
        }
        if(i==j){
            ans+=(long)nums[j]*nums[j];
        }
        return ans;
    }
}