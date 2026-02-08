class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> st = new Stack<>();
        for(int num:nums){
            long curr = (long) num;
            while(!st.isEmpty() && st.peek() == curr){
                st.pop();
                curr = 2 * curr;
            }
            st.push(curr);
            
        }
        List<Long> result = new ArrayList<>();
        while(!st.isEmpty()){
            result.add(st.pop());
        }
        Collections.reverse(result);
        return result;
    }
}