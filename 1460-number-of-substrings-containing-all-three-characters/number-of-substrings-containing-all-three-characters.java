class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[3];
        int sub = 0;
        int i = 0;
        int j = 0;
        while(j < n) {
            char c = s.charAt(j);
            freq[c - 'a'] ++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                sub += n - j;
                freq[s.charAt(i) - 'a'] --;
                i++;
            }
            j++;
        }
        return sub;
    }
}