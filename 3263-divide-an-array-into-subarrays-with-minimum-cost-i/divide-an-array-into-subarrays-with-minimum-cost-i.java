class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < n; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        return nums[0] + list.get(0) + list.get(1);
    }
}