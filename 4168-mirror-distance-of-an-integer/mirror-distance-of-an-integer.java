class Solution {
    public int mirrorDistance(int n) {
        int rev=0;
        int number=n;
        while(number>0){
            rev=rev*10+number%10;
            number/=10;
        }
        return Math.abs(n-rev);
    }
}