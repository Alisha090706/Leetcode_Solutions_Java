class Solution {
    public int minTimeToType(String word) {
        int n = word.length();
        int time = 0;
        char prev = 'a';
        for(char c: word.toCharArray()){
            int one = Math.abs(c - prev);
            int second = Math.abs(26 - one);
            time += Math.min(one, second) + 1;
            prev = c;
        }
        return time;
    }
}