class Solution {
    public int expressiveWords(String s, String[] words) {
        int totalWords = 0;
        for(String word: words){
            if(stretchy(word,s)) totalWords++;
        }
        return totalWords;
    }
    public boolean stretchy(String word,String s){
        int i = 0;
        int j = 0;
        while(i < word.length() && j < s.length()){
            if(s.charAt(j) != word.charAt(i)) break;
            char ch = s.charAt(j);
            int lenS = 0;
            while(j < s.length() && s.charAt(j) == ch){
                j++;
                lenS++;
            }
            int lenW = 0;
            while(i < word.length() && word.charAt(i) == ch){
                i++;
                lenW++;
            }
            if(lenS < lenW) return false;
            if(lenS != lenW && lenS<3){
                return false;
            }
        }
        return i == word.length() && j == s.length();
    }
}