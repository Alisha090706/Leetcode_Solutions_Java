class Solution {
    public int countCommas(int n) {
        int count = 0;
        if(n <= 999) return 0;
        if(n == 100000) {
            return (n - 1001) + 2;
        }
        return n - 999;
    }
}