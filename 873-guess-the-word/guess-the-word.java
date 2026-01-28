/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        for (int i = 0; i < 10; ++i) {
            String guess = words[new Random().nextInt(words.length)];
            int x = master.guess(guess);
            List<String> words2 = new ArrayList<>();
            for (String w : words)
                if (match(guess, w) == x)
                    words2.add(w);
            words = words2.toArray(new String[0]);
        }
    }
    
    public int match(String s1, String s2){
        int count = 0;
        for(int i = 0; i < 6; i++){
            if(s1.charAt(i) == s2.charAt(i)) count++;
        }
        return count;
    }
}