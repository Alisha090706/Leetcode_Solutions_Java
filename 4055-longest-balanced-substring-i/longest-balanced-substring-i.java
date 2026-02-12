class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int len = 0;
        for(int i = 0; i < n; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j < n; j++){
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0)+1);
                boolean balanced = true;
                int val = map.get(c);
                for(char ch : map.keySet()){
                    if(map.get(ch) != val){
                        balanced = false;
                        break;
                    }
                }
                if(balanced) len = Math.max(len, j -i + 1);
            }
        }
        return len;
        
    }
}