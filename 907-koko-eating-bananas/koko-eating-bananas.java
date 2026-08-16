class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1;
        int r = 0;
        for(int num : piles) {
            r = Math.max(num, r);
        
        }
        int ans = -1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            long hours = 0;
            for(int pile : piles) {
                hours += pile / mid;
                if((pile / mid) * mid < pile) hours++;
            }
            if(hours <= h) {
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
}