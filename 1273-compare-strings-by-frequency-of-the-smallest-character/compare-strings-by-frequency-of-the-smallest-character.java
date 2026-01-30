class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int n = queries.length;
        int[] result = new int[n];
        int[] f1 = new int[n];
        int[] f2 = new int[words.length];
        for(int i = 0; i < n; i++){
            f1[i] = f(queries[i]);
        }
        for(int i = 0; i < words.length; i++){
            f2[i] = f(words[i]);
        }
        for(int i = 0; i < n; i++){
            int freqQuery = f1[i];
            int count = 0;
            for(int freqWord : f2){
                if(freqWord > freqQuery) count++;
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