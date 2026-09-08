class Solution {
    public int countCommas(int n) {
        int count = 0;
        if(n <= 999) return 0;
        return n - 999;
    }
}