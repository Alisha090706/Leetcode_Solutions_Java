class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            String q = queries[i];
            int freqQuery = f(q);
            int count = 0;
            for(String w: words){
                int freqWord = f(w);
                if(freqQuery < freqWord) count++;
            }
            result[i] = count;
        }
        return result;

    }
    public int f(String s){
        char[] letters = s.toCharArray();
        char smallest = letters[0];
        int count = 0;
        for(char c : letters){
            if(c < smallest){
                smallest = c;
                count = 1;
            }
            else if(c == smallest) count++;
        }
        return count;
    }
}