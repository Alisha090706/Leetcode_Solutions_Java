class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //transpose then reverse each row
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    swap(matrix,i,j);
                }
                
            }
        }
        for(int i=0;i<n;i++){
            int j=0;
            int k=n-1;
            while(j<k){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=temp;
                j++;
                k--;
            }
        }

    }
    public void swap(int[][] matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }
}