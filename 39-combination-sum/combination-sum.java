class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates, 0, target, new ArrayList<>());
        return result;
    }
    public void solve(int[] nums, int i, int target, List<Integer> list) {
        if(i >= nums.length || target < 0) return;

        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        } 

        for(int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            solve(nums, j, target - nums[j], list);
            list.remove(list.size() - 1);
        }
    }
}