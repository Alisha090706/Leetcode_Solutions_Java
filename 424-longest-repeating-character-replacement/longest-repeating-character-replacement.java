class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int len = 0;
        int i = 0;
        int j = 0;
        while(j < n){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));

            while((j - i + 1) - max > k){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                max = 0;
                for(int val : map.values()){
                    max = Math.max(max, val);
                }
                i++;
            }
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
}