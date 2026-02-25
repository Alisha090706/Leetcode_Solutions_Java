class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int bits =Integer.bitCount(num);
            map.putIfAbsent(bits, new ArrayList<>());
            map.get(bits).add(num);
        }
        int i = 0;
        for(int bit: map.keySet()){
            for(int num: map.get(bit)){
                arr[i] = num;
                i++;
            }
        }
        return arr;
    }
}