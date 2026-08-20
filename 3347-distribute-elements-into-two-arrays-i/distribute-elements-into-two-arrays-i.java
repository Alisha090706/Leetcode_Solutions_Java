class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i = 2; i < n; i++) {
            if(arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            }
            else {
                arr2.add(nums[i]);
            }
        }
        arr1.addAll(arr2);
        int m = arr1.size();
        int[] result = new int[m];
        for(int i = 0; i < m; i++) {
            result[i] = arr1.get(i);
        }
        return result;
    }
}