class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            int diff = arr[i] - arr[i-1];
            min = Math.min(min,diff);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i < n; i++){
            int diff = arr[i] - arr[i-1];
            if(diff == min){
                List<Integer> a = new ArrayList<>();
                a.add(arr[i-1]);
                a.add(arr[i]);
                result.add(a);
            }
        }
        return result;
        
    }
}