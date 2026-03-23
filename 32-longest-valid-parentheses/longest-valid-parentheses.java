class Solution {
    int n;
    public int longestValidParentheses(String s) {
        n = s.length();
        if(n == 0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(') {
                st.push(i);
            }
            else{
                st.pop();
                if(st.isEmpty()) {
                    st.push(i);
                }
                maxlen = Math.max(maxlen, i - st.peek());
            }
        }
        return maxlen;
    }
}