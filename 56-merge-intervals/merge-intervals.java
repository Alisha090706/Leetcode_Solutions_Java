class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < n; i++) {
            int[] last = list.get(list.size() - 1);
            int[] curr = intervals[i];
            if(last[1] >= curr[0]) {
                list.remove(list.size() - 1);
                list.add(new int[]{last[0], Math.max(curr[1], last[1])});
            }
            else {
                list.add(curr);
            }
        }
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            result[i][0] = arr[0];
            result[i][1] = arr[1];
        }
        return result;
    }
}