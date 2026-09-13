class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int count=0;
        for(int rowOff=-n+1;rowOff<n;rowOff++){
            for(int colOff=-n+1;colOff<n;colOff++){
                count=Math.max(count,countOverlaps(img1,img2,rowOff,colOff));
            }
        }     
        return count;
    }
    public int countOverlaps(int[][] img1,int[][] img2,int rowOff,int colOff){
        int count=0;
        int n=img1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int row=i+rowOff;
                int col=j+colOff;
                if(row<0||col<0|| row>=n|| col>=n) continue;
                if(img1[i][j]==1 && img2[row][col]==1){
                    count++;
                }
            }
        }
        return count;
    }
}