class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int num: nums) {
            min = Math.min(min, sumDigits(num));
        }
        return min;
    }
    public int sumDigits(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}