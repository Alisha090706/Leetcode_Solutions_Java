class Solution {
    List<List<String>> result = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        // Approach 1 : Backtracking
        List<String> list = new ArrayList<>();
        backtracking(s, 0, list);
        return result; 
    }
    public void backtracking(String s, int i, List<String> list){
        if(i == n){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<n;j++){
            if(palindrome(s.substring(i,j+1))){
                list.add(s.substring(i,j+1));
                backtracking(s,j+1,list);
                list.remove(list.size()-1);

            }
        }
    }
    public boolean palindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}