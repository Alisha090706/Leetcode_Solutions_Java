class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length;
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int days = 0;
        
        for(int i = 0; i < n; i++) {
            days += courses[i][0];
            pq.add(courses[i][0]);
            if(days > courses[i][1]) {
                int duration = pq.poll();
                days -= duration;
            }
        }
        return pq.size();
    }
}