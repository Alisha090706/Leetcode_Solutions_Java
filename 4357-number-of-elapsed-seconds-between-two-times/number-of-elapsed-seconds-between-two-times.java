class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int startHour = Integer.parseInt(start[0]);
        int startMinute = Integer.parseInt(start[1]);
        int startSecond = Integer.parseInt(start[2]);
        int endHour = Integer.parseInt(end[0]);
        int endMinute = Integer.parseInt(end[1]);
        int endSecond = Integer.parseInt(end[2]);

        return (endHour - startHour) * 3600 +
                (endMinute - startMinute) * 60 +
                (endSecond - startSecond);
    }
}