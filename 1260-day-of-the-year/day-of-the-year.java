class Solution {
    public int dayOfYear(String date) {
        String[] nums = date.split("-");
        int year = Integer.parseInt(nums[0]);
        int month = Integer.parseInt(nums[1]);
        int days = Integer.parseInt(nums[2]);

        int[] total = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int ans = days;
        for(int i = 0; i < month - 1; i++) {
            ans += total[i];
        }
        if(leapYear(year) && month > 2) ans += 1;
        return ans;
    }
    public boolean leapYear(int y) {
        if(y % 100 == 0) {
            if(y % 400 == 0) return true;
            return false;
        }
        return y % 4 == 0;
    }
}