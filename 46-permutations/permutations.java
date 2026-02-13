class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        visited = new boolean[n];
        solve(nums,new ArrayList<>());
        return result;
    }
    public void solve(int[] nums,ArrayList arr){
        if(arr.size() == n){
            result.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            arr.add(nums[i]);
            visited[i] = true;
            solve(nums, arr);
            arr.remove(arr.size()-1);
            visited[i] = false;
        }
    }
}