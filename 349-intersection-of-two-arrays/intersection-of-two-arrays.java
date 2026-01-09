class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num:nums1) set1.add(num);
        for(int num:nums2) set2.add(num);

        ArrayList<Integer> list = new ArrayList<>();
        for(int num: set1){
            if(set2.contains(num)) list.add(num);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}