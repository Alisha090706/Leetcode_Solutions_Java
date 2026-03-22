class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int count = 0;
        while(!equal(mat,target)) {
            rotate(mat);
            count++;
            if(count > 3) return false;
        }
        return true;
    }
    public boolean equal(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
    public void rotate(int[][] mat) {
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<j){
                    swap(mat,i,j);
                }
                
            }
        }
        for(int i=0;i<n;i++){
            int j=0;
            int k=n-1;
            while(j<k){
                int temp=mat[i][j];
                mat[i][j]=mat[i][k];
                mat[i][k]=temp;
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