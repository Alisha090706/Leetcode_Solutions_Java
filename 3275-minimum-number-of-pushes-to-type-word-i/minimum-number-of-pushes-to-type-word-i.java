class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int num = 0;
        int round = 1;
        for(char c: word.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, round);
            }
            if(num == 7) round++;
            num = (num + 1) % 8;
        }
        for(char c: word.toCharArray()) {
            count += map.get(c);
        }
        return count;
    }
}