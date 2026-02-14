class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Integer, Character> map = new HashMap<>();
        int val = 25;
        for(char c = 'a'; c <= 'z'; c++){
            map.put(val,c);
            val--;
        }
        StringBuilder sb = new StringBuilder();
        for(String w: words){
            int sum = 0;
            for(char c: w.toCharArray()){
                sum += weights[c-'a'];
            }
            sum= sum % 26;
            sb.append(map.get(sum));
        }
        return sb.toString();
    }
}