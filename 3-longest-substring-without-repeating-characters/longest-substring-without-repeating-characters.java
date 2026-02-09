class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j < n){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.containsKey(ch) && map.get(ch)>1){
                char ch2 = s.charAt(i);
                map.put(ch2, map.get(ch2)-1);
                if(map.get(ch2) == 0) map.remove(ch2);
                i++;
            }
            maxlen = Math.max(maxlen, j- i+1);
            j++;
        }
        return maxlen;
    }
}