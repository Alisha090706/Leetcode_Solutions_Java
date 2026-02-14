class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: words){
            if(s.length() < k) continue;
            String sub = s.substring(0,k);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        int comp = 0;
        for(int val: map.values()){
            if(val > 1 ) comp++;
        }
        return comp;
    }
}