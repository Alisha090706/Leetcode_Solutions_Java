class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int change_5 = 0;
        int change_10 = 0;

        for(int i = 0; i < n; i++){
            int bill = bills[i];
            if(bill == 5){
                change_5++;
            }
            else if(bill == 10){
                if(change_5 == 0) return false;
                change_5--;
                change_10++;
            }
            else{
                if(change_5 < 3 && (change_5 == 0 || change_10 == 0)) return false;
                if(change_10 > 0){
                    change_10--;
                    change_5--;
                }
                else if(change_5 >= 3){
                    change_5 -= 3;
                }
            }
        }
        return true;
    }
}