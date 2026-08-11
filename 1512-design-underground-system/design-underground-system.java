class ListNode {
    int id;
    String startStation;
    int t;
    ListNode(int id, String stationName, int t) {
        this.id = id;
        this.startStation = stationName;
        this.t = t;
    }
}
class UndergroundSystem {
    HashMap<Integer, ListNode> map;
    HashMap<String, double[]> avgtime;
    public UndergroundSystem() {
        map = new HashMap<>();
        avgtime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        ListNode node = new ListNode(id, stationName, t);
        map.put(id, node);
    }
    
    public void checkOut(int id, String stationName, int t) {
        ListNode node = map.get(id);
        map.remove(id);
        String journey = node.startStation + "-" + stationName;
        double[] data = avgtime.getOrDefault(journey, new double[2]);

        data[0] += t - node.t; // total time
        data[1]++;             // number of trips
        avgtime.put(journey, data);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String journey = startStation + "-" + endStation;
        double[] time = avgtime.get(journey);
        return time[0] / time[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */