class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < n; i++) {
            char c = arr[i];
            if(c == '(') {
                st.push(i);
            }
            else if(c == ')') {
                reverse(arr, st.pop() + 1, i - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            if(c != '(' && c != ')') sb.append(c);
        }
        return sb.toString();
    }
    public void reverse(char[] arr, int i, int j) {
        while(i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}