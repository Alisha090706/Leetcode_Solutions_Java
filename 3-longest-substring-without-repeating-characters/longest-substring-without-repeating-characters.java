class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int i = 0; 
        int j = 0;
        while(j < n) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.get(c) > 1) {
                char prev = s.charAt(i);
                map.put(prev, map.get(prev) - 1);
                if(map.get(prev) == 0) map.remove(prev);
                i++;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}