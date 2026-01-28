class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int answer = check(tops[0],tops,bottoms);
        if(answer != -1) return answer;
        return check(bottoms[0],tops,bottoms);
    }
    public int check(int num,int[] tops, int[] bottoms){
        int n = tops.length;
        int topSwaps = 0;
        int bottomSwaps = 0;
        for(int i = 0; i < n; i++){
            if(tops[i] != num && bottoms[i] != num) return -1;
            if(tops[i] != num){
                topSwaps++;
            }
            if(bottoms[i] != num) bottomSwaps++;
        }
        return Math.min(bottomSwaps, topSwaps);
    }
}