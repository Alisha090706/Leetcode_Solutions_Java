class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        solve(n, k, new ArrayList<>(), 1);
        return result;
    }
    public void solve(int n, int k, ArrayList<Integer> arr, int i){
        if(k == 0){
            result.add(new ArrayList<>(arr));
            return;
        }
        if(i > n) return;
        arr.add(i);
        solve(n, k - 1, arr, i + 1);
        arr.remove(arr.size() - 1);
        solve(n, k, arr, i + 1);
    }
}