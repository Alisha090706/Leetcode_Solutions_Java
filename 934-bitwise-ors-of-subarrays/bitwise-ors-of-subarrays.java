class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        for(int i = 0; i < n; i++) {
            HashSet<Integer> curr = new HashSet<>();
            for(int x : prev) {
                set.add(x | arr[i]);
                curr.add(x | arr[i]);
            }
            set.add(arr[i]);
            curr.add(arr[i]);
            prev = curr;
        }
        return set.size();
    }
}