class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int ans = 0;
        Arrays.sort(arr);
        for(int a : arr) {
            ans = Math.min(ans + 1, a);
        }
        return ans;
    }
}