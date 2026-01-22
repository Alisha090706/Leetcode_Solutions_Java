class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int num: nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        //     if(map.get(num) > n/2) return num;
        // }
        // return 0;

        Arrays.sort(nums);
        int j = 0;
        for(int i = 0; i < n; i++){
            int num =nums[i];
            while(j < n && nums[j] == num){
                j++;
            }
            if(j - i > n/2) return num;
        }
        return 0;
    }
}