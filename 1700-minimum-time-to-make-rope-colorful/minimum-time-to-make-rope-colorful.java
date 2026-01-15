class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int prev = 0;
        int curr = 1;
        int time = 0;
        while(curr < n){
            while(curr < n && colors.charAt(curr) == colors.charAt(prev)){
                time += (Math.min(neededTime[prev],neededTime[curr]));
                if(neededTime[curr] > neededTime[prev]){
                    prev = curr;
                }
                curr ++;
            }
            if(curr < n && colors.charAt(prev) != colors.charAt(curr)){
                prev = curr;
            }
            curr++;
        }
        return time;
    }
}