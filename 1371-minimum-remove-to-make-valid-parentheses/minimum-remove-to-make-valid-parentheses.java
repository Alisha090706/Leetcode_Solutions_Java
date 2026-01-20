class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int countOpen = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                st.push(c);
                countOpen++;
            }
            else if(c == ')'){
                if(countOpen > 0){
                    countOpen--;
                    st.push(c);
                }
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char c = st.pop();
            if(c == '('){
                if(countOpen > 0){
                    countOpen --;
                }
                else{
                    sb.append(c);
                }
            }
            else{
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }
}