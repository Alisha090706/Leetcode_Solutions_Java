class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n=apple.length;
        int m=capacity.length;

        Arrays.sort(capacity);

        int packs=0;
        for(int i=0;i<n;i++) packs+=apple[i];

        int count=0;
        int boxesCap=0;
        for(int i=m-1;i>=0;i--){
            boxesCap+=capacity[i];
            count++;
            if(boxesCap>=packs) return count;
        }
        return count;
    }
}