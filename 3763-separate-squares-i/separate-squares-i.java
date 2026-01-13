class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double max_y = Double.NEGATIVE_INFINITY;
        double min_y = Double.MAX_VALUE;
        double total_area = 0;
        for(int[] sq: squares){
            max_y = Math.max(max_y, sq[1]+sq[2]);
            min_y = Math.min(min_y, sq[1]);
            total_area += (double) sq[2] * sq[2];
        } 

        while(max_y - min_y > 1e-6){
            double mid = min_y + (max_y - min_y)/2;
            double area_1 = 0;
            for(int[] sq: squares){
                int bottom = sq[1];
                int top = sq[1]+sq[2];
                int side = sq[2];
                if(mid <= bottom) continue;
                else if(mid >=top){
                    area_1 += (double) side * side;
                }
                else{
                    area_1 += (double) side * (mid - bottom);
                }
            }
            if(area_1 * 2 >= total_area){
                max_y = mid;
            }
            else{
                min_y = mid;
            }
            
        }
        return (min_y + max_y) / 2;
    }
}