class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;

        while(n > 0) {
            int digit = n % 10;
            if(digit != 0) {
                x = x * 10 + digit;
                sum += digit;
            }
            n /= 10;
        }
        int x_r = reverse(x);
        return (long) sum * x_r;
    }
    public int reverse(int x) {
        int reverse = 0;
        while(x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }
}