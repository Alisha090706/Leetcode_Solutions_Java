class Solution {
    List<String> result = new ArrayList<>();
    String[] numbers = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        solve(digits,0,new StringBuilder());
        return result;
    }
    public void solve(String digits, int i, StringBuilder sb){
        if(digits.length() == i){
            result.add(sb.toString());
            return;
        }
        for(char c: numbers[digits.charAt(i) - '0'].toCharArray()){
            sb.append(c);
            solve(digits,i+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}