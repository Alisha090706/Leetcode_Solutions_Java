class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int lastPlantDay = -1;
        int lastBloomDay = 0;
        int[][] seeds = new int[n][2];
        for (int i = 0; i < n; i++) {
            seeds[i][0] = plantTime[i];
            seeds[i][1] = growTime[i];
        }
        // Sort by growTime descending
        Arrays.sort(seeds, (a, b) -> b[1] - a[1]);
        for(int i = 0; i < n; i++){
            lastBloomDay = Math.max(lastBloomDay,lastPlantDay + 1 + seeds[i][0] + seeds[i][1]);
            lastPlantDay += seeds[i][0];
        }
        return lastBloomDay;
        
    }
}