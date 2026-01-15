class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // sort the arrays
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxh = 0;
        int maxv = 0;
        int curr = 0;
        for(int j = 1; j <hBars.length; j++){
            if(hBars[j] == hBars[j-1] + 1){
                curr++;
            }
            else curr = 0;
            maxh = Math.max(maxh, curr);
        }
        curr = 0;
        for(int j = 1; j <vBars.length; j++){
            if(vBars[j] == vBars[j-1] + 1){
                curr++;
            }
            else curr = 0;
            maxv = Math.max(maxv, curr);
        }

        int side = Math.min(maxh,maxv) + 2;
        return side * side;
    }
}