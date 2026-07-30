class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        int round = 1;
        int num = 0;
        for(char c : word.toCharArray()){
            count += round;
            if(num == 7) round++;
            num = (num + 1) % 8;
        }
        return count;
    }
}