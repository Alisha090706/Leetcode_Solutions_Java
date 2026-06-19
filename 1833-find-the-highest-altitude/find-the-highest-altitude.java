class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int start = 0;
        for(int n : gain) {
            max = Math.max(max, start + n);
            start += n;
        }
        return max;
    }
}