class Solution {
    int n;
    public int largestRectangleArea(int[] heights) {
        n = heights.length;
        int[] left = smallestLeft(heights);
        int[] right = smallestRight(heights);

        int area = 0;
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            area = Math.max(area, heights[i] * width);
        }
        return area;
    }
    public int[] smallestLeft(int[] h){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && h[st.peek()] >= h[i]) st.pop();
            if(st.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = st.peek();
            }
            st.push(i);
        }
        return result;
    }
    public int[] smallestRight(int[] h){
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && h[st.peek()] >= h[i]) st.pop();
            if(st.isEmpty()){
                result[i] = n;
            }
            else{
                result[i] = st.peek();
            }
            st.push(i);
        }
        return result;
    }
}