class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = commands.length;
        HashSet<String> set = new HashSet<>();
        for(int[] obs: obstacles) {
            String s = obs[0] + "_" + obs[1];
            set.add(s);
        }
        int x = 0;
        int y = 0;
        int maxD = 0;

        //positioning north
        int[] dir = {0, 1};

        for(int i = 0; i < n; i++) {
            if(commands[i] == -2) {
                //turn left
                int xl = dir[0];
                int yl = dir[1];
                dir[0] = -yl;
                dir[1] = xl;
            }
            else if(commands[i] == -1) {
                //turn right
                int xr = dir[0];
                int yr = dir[1];
                
                dir[0] = yr;
                dir[1] = -xr;
            }
            else{
                for(int step = 0; step < commands[i]; step++) {
                    int newx = x + dir[0];
                    int newy = y + dir[1];
                    String s = newx + "_" + newy;
                    if(set.contains(s)) {
                        break;
                    }

                    x = newx;
                    y = newy;
                }
            }
            maxD = Math.max(maxD, x * x + y * y);
        }
        return maxD;
    }
}