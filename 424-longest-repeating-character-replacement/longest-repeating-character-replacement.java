class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int maxScore = 0;
        int maxLength = 0;
        int i = 0;
        int j = 0;
        while(j < n){
            int idx = s.charAt(j) - 'A';
            freq[idx]++;
            maxScore = Math.max(maxScore, freq[idx]);

            while((j - i + 1) - maxScore > k){
                int idx2 = s.charAt(i) - 'A';
                freq[idx2] --;
                maxScore = Math.max(maxScore, freq[idx]);

                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;

    }
}