class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> set = new HashSet<>();
        for(int bulb : bulbs){
            if(set.contains(bulb)) set.remove(bulb);
            else set.add(bulb);
        }
        List<Integer> result = new ArrayList<>();
        for(int bulb: set) result.add(bulb);
        Collections.sort(result);
        return result;

    }
}