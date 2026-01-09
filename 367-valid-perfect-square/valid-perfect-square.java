class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true;
        int i = 1;
        int j = num/2;
        while(i <= j){
            int mid = i + (j - i)/2;
            long sq =(long) mid * mid;
            if(sq == num) return true;
            else if(sq < num){
                i = mid + 1;
            }
            else{
                j = mid -1;
            }
        }
        return false;
    }
}