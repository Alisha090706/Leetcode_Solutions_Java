class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater = 0;
        int i = 0;
        int j = n-1;
        while(i < j){
            int h = Math.min(height[i],height[j]);
            int w = j - i;
            int area = h * w;
            maxWater = Math.max(maxWater, area);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxWater;
    }
}