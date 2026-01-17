class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long area = 0;
        for(int i = 0; i < n ; i++){
            for(int j = i + 1; j < n ; j++){
                int x1 = Math.max(bottomLeft[j][0],bottomLeft[i][0]);
                int x2 = Math.min(topRight[j][0],topRight[i][0]);
                int y1 = Math.max(bottomLeft[j][1],bottomLeft[i][1]);
                int y2 = Math.min(topRight[j][1],topRight[i][1]);
                int side1 = x2 - x1;
                int side2 = y2 - y1;
                if(side1 <=0 || side2 <= 0) continue;
                int side = Math.min(side1, side2); 

                area = Math.max(area, (long)side*side);
            }
        }
        return area;
        
    }
}