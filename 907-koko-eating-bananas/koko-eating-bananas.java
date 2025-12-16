class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l=1;
        int r=piles[0];
        for(int num:piles){
            r=Math.max(r,num);
        }
        while(l<r){
            int mid=l+(r-l)/2;
            int hours=0;
            for(int num:piles){
                hours+=(mid+num-1)/mid;
            }
            if(hours>h){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
        
    }

}