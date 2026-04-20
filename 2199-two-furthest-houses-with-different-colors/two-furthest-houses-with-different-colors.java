class Solution {
    public int maxDistance(int[] colors) {
        int i = 0;
        int j = colors.length - 1;
        int max = 0;
        while(i <= j && colors[i] == colors[j]) j--;
        max = j - i;
        j = colors.length - 1;
        while(i <= j && colors[i] == colors[j]) i++;
        max = Math.max(max, j - i);
        return max;
    }
}