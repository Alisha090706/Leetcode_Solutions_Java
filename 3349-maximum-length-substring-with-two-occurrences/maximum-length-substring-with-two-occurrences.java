class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxLen = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.containsKey(c) && map.get(c) > 2) {
                char c2 = s.charAt(j);
                map.put(c2, map.get(c2) - 1);
                if(map.get(c2) == 0) map.remove(c2);
                j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }
}