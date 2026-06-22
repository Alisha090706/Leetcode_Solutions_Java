class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] balloon = {'b', 'a', 'l', 'o', 'n'};
        for(char c : balloon) {
            map.put(c, 0);
        }

        for(char c: text.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
        }
        int total = Integer.MAX_VALUE;
        for(char c: map.keySet()) {
            if(c == 'l' || c == 'o') {
                total = Math.min(total, map.get(c) / 2);
            }
            else{
                total = Math.min(total, map.get(c));
            }
        }
        return total;
    }
}