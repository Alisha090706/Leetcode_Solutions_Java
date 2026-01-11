class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] oneD = new int[col];
        int result = 0;
        for(int i = 0;i<row;i++){
            int area = 0;
            for(int j = 0;j<col;j++){
                if(matrix[i][j] == '0'){
                    oneD[j] = 0;
                }
                else{
                    oneD[j] += 1;
                }
            }
            int[] left = left(oneD);
            int[] right = right(oneD);
            for(int j = 0;j<col;j++){
                area = Math.max((right[j]-left[j]-1)*oneD[j],area);
            }
            result = Math.max(area,result);
        }
        return result;
    }
    public int[] left(int[] arr){
        int n = arr.length;
        int[] l = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        l[0]=-1;
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                l[i]= st.peek();
            }
            else{
                l[i]=-1;
            }
            st.push(i);

        }
        return l;
    }
    public int[] right(int[] arr){
        int n = arr.length;
        int[] r = new int[n];
        r[n-1] = n;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for(int i = n-2;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                r[i]=st.peek();
            }
            else{
                r[i]=n;
            }
            st.push(i);
        }
        return r;
    }
}