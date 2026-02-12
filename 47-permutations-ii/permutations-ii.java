class Solution {
    List<List<Integer>> result = new ArrayList<>();

    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        boolean[] visited = new boolean[nums.length];
        solve(nums, new ArrayList<>(), visited);
        return result;
    }
    public void solve(int[] nums,List<Integer> arr, boolean[] visited){
        if(arr.size() == n){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1])
                continue;
            arr.add(nums[i]);
            visited[i] = true;
            solve(nums,arr,visited);
            arr.remove(arr.size()-1);
            visited[i] = false;
        }
    }
}