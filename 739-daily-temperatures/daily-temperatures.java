class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        st.push(n - 1);
        for(int i = n - 2; i >= 0; i--) {
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                result[i] = st.peek() - i;
            }
            st.push(i);
        }
        return result;
    }
}