class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;

        Arrays.sort(hand);

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:hand){
            if(!map.containsKey(num)) continue;
            if(!map.containsKey(num-1)){
                int curr = num;
                int len = 0;
                while(map.containsKey(curr)){
                    len++;
                    map.put(curr,map.get(curr)-1);
                    if(map.get(curr) == 0) map.remove(curr);
                    curr++;
                    if(len == groupSize) break;
                }
                if(len < groupSize) return false;
            }
        }
        return true;
    }
}