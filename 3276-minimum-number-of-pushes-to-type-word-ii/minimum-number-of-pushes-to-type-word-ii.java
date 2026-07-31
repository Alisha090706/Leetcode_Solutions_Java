class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for(char c: word.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int i = 25;
        while(i >= 0 && freq[i] == 0) {
            i--;
        }
        int count = 0;
        int round = 1;
        int num = 0;
        for(int j = i; j >= 0; j--) {
            count += freq[j] * round;
            if(num == 7) round++;
            num = (num + 1) % 8;
        }
        return count;
    }
}