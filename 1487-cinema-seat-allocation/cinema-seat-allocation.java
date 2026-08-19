class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int[] r: reservedSeats) {
            map.putIfAbsent(r[0], new HashSet<>());
            map.get(r[0]).add(r[1]);
        }
        int count = 2 * n;
        for(int row : map.keySet()) {
            boolean left = true;
            boolean middle = true;
            boolean right = true; 
            HashSet<Integer> key = map.get(row);
            for(int j = 2; j <= 5; j++) {
                if(key.contains(j)) {
                    left = false;
                    break;
                }
            }
            for(int j = 4; j <= 7; j++) {
                if(key.contains(j)) {
                    middle = false;
                    break;
                }
            }
            for(int j = 6; j <= 9; j++) {
                if(key.contains(j)) {
                    right = false;
                    break;
                }
            }
            if(left && right);
            else if(left || middle || right) count -= 1;
            else count -= 2;
        }
        return count;
    }
}