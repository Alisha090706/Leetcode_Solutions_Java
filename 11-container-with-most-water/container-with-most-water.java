class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int maxWater = 0;
        int i = 0;
        int j = n - 1;
        while(i < j){
            int h1 = height[i];
            int h2 = height[j];
            int width = j - i;
            maxWater = Math.max(maxWater, Math.min(h1, h2) * width);
            if(h1 < h2){
                i ++;
            }
            else{
                j --;
            }
        }
        return maxWater;
        
    }
}