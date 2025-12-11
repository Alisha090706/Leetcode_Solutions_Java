class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,int[]> mapx=new HashMap<>();
        HashMap<Integer,int[]> mapy=new HashMap<>();
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            // Row map
            mapx.putIfAbsent(x, new int[]{y, y});
            mapx.get(x)[0] = Math.min(mapx.get(x)[0], y);
            mapx.get(x)[1] = Math.max(mapx.get(x)[1], y);

            // Column map
            mapy.putIfAbsent(y, new int[]{x, x});
            mapy.get(y)[0] = Math.min(mapy.get(y)[0], x);
            mapy.get(y)[1] = Math.max(mapy.get(y)[1], x);
        }

        int count=0;

        for(int[] b:buildings){
            int x=b[0];
            int y=b[1];
            int minx=mapy.get(y)[0];
            int maxx=mapy.get(y)[1];
            int miny=mapx.get(x)[0];
            int maxy=mapx.get(x)[1];

            if(minx<x && maxx>x && miny<y && maxy>y) count++;
        }
        return count;
    }
}