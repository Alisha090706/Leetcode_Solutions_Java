class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        // sort the arrays
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxh = 1;
        int maxv = 1;
        int curr = 1;
        for(int j = 1; j <hBars.length; j++){
            if(hBars[j] == hBars[j-1] + 1){
                curr++;
            }
            else curr = 1;
            maxh = Math.max(maxh, curr);
        }
        curr = 1;
        for(int j = 1; j <vBars.length; j++){
            if(vBars[j] == vBars[j-1] + 1){
                curr++;
            }
            else curr = 1;
            maxv = Math.max(maxv, curr);
        }

        int side = Math.min(maxh,maxv) + 1;
        return side * side;
    }
}