class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operations = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) arr.add(num);

        while(!sorted(arr)){
            int minsum = arr.get(0) + arr.get(1);
            int minidx = 0;
            for(int i = 1; i < arr.size()-1; i++){
                if(arr.get(i) + arr.get(i+1) < minsum){
                    minsum = arr.get(i) + arr.get(i+1);
                    minidx = i;
                }
            }
            arr.set(minidx,minsum);
            arr.remove(minidx + 1);
            operations ++;
        }
        return operations;
    }
    public boolean sorted(ArrayList<Integer> arr){
        int n = arr.size();
        for(int i = 0; i < n-1; i++){
            if(arr.get(i) > arr.get(i+1)) return false;
        }
        return true;
    }
}