class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int i = 0;
        int j = 0;
        Stack<Integer> st = new Stack<>();
        while(i < n){
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            st.push(pushed[i]);
            i++;
        }
        while(j < n){
            if(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
            else return false;
        }
        return st.isEmpty();
    }
}