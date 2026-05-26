class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        HashSet<Character> lower = new HashSet<>();
        for(int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
            if(word.charAt(i) <= 'z' && word.charAt(i) >= 'a') lower.add(word.charAt(i));
        }

        for(char c : lower) {
            char ch = (char)(c - 32);
            if(set.contains(ch)) count++;
        }
 
        return count;
        
    }
}