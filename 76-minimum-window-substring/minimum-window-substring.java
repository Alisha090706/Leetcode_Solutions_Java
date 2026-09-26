class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int required = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int len = Integer.MAX_VALUE;
        int st = 0;
        int i = 0;
        int j = 0;
        while(j < n) {
            char c = s.charAt(j);
            if(map.containsKey(c) && map.get(c) > 0) required--;
            map.put(c, map.getOrDefault(c, 0) - 1);
            while(required == 0) {
                char prev = s.charAt(i);
                int curr = j - i + 1;
                if(len > curr) {
                    len = curr;
                    st = i;
                }
                if(map.containsKey(prev)) {
                    map.put(prev, map.getOrDefault(prev, 0) + 1);
                    if(map.get(prev) > 0) {
                        required ++;
                    }
                }
                i++;
            }
            j++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(st, st + len);
    }
}