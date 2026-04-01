class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robots = new int[n][4];

        for(int i = 0; i < n; i++){
            robots[i][0] = i; //index
            robots[i][1] = positions[i];
            robots[i][2] = healths[i]; 
            robots[i][3] = directions.charAt(i) == 'R' ? 0 : 1;
        }
        Arrays.sort(robots, (a,b) -> a[1] - b[1]);
        Stack<int[]> st = new Stack<>(); //position and health;
        for(int i = 0; i < n; i++) {
            if(robots[i][3] == 0) {
                st.push(new int[]{robots[i][0], robots[i][2], robots[i][3]});
            }
            else{
                int currHealth = robots[i][2];
                while(!st.isEmpty() && st.peek()[2] == 0 && currHealth > 0) {
                    int[] top = st.peek();
                    int topHealth = top[1];
                    if(topHealth > currHealth) {
                        currHealth = 0;
                        st.peek()[1] -= 1; 
                        
                    }
                    else if(topHealth < currHealth) {
                        currHealth -= 1;
                        topHealth = 0;
                        st.pop();
                    }
                    else{
                        currHealth = 0 ;
                        st.pop();
                    }
                }
                if(currHealth > 0) {
                    st.push(new int[]{robots[i][0], currHealth, robots[i][3]});
                }

            }
        }
        ArrayList<int[]> arr = new ArrayList<>();
        while(!st.isEmpty()) {
            arr.add(st.pop());
        }
        Collections.sort(arr, (a,b) -> a[0] - b[0]);
        List<Integer> result = new ArrayList<>();
        for(int[] list : arr) {
            result.add(list[1]);
        }
        return result;
    }
}