class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int n = s.length();
        int wordCount = words.length;
        int wordLen = words[0].length();

        for(String w: words){
            map.put(w,map.getOrDefault(w,0)+1);
        }
        for(int i = 0; i < wordLen; i++){
            HashMap<String, Integer> window = new HashMap<>();
            int left = i;
            int count = 0;
            for(int right = i; right + wordLen <= n; right += wordLen){
                String w = s.substring(right, right + wordLen);
                if(map.containsKey(w)){
                    window.put(w, window.getOrDefault(w,0)+1);
                    count++;
                    while(window.get(w) > map.get(w)){
                        String w2 = s.substring(left, left + wordLen);
                        window.put(w2, window.get(w2) - 1);
                        left += wordLen;
                        count --;
                    }
                    if(count == wordCount) result.add(left);
                }
                else{
                    window.clear();
                    left = right + wordLen;
                    count = 0;
                }
            }
        }
        return result;
    }
}