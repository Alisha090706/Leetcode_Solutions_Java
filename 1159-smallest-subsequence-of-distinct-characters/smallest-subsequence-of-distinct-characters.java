class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int[] last = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26];

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(visited[c - 'a']) continue;

            while(!st.isEmpty() && st.peek() > c && last[st.peek() - 'a'] > i) {
                visited[st.pop() - 'a'] = false;
            }
            st.push(c);
            visited[c - 'a'] = true;
        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}