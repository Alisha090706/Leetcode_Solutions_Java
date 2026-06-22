class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            int target = -nums[i];
            while(j < k) {
                int sum = nums[j] + nums[k];
                if(sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    if(!set.contains(triplet)) {
                        result.add(triplet);
                        set.add(triplet);
                    }
                    j++;
                    k--;
                }
                else if(sum > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return result;
    }
}