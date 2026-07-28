class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] letters = new int[26];
        for(char c: s.toCharArray()) {
            letters[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char mid = '.';
        for(int i = 0; i < 26; i++) {
            if(letters[i] == 0) continue;
            for(int j = 0; j < letters[i] / 2; j++) {
                sb.append((char) ('a' + i));
            }
            if(letters[i] % 2 != 0) {
                mid = (char) ('a' + i);
                letters[i] --;
            }

            letters[i] /= 2;
        }

        for(int i = 25; i >= 0; i--) {
            if(letters[i] == 0) continue;
            for(int j = 0; j < letters[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }

        int size = sb.length();
        if(mid != '.') {
            sb.insert(size / 2, mid);
        }

        return sb.toString();
    }
}