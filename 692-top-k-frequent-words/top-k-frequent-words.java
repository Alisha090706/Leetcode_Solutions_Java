class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(String w : words){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result, (a,b) -> {
            if(map.get(a) == map.get(b)){
                return a.compareTo(b);
            }
            return map.get(b)-map.get(a);
        });
        return result.subList(0,k);
    }
}