class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2,nums1);
        int left = 0;
        int right = m;
        while(left <=right){
            int Px = left + (right - left)/2;
            int Py = (m+n+1)/2 - Px;

            //left
            int a1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px-1];
            int a2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py-1];
            //right
            int a3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];
            int a4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];

            if(a1 <= a4 && a2 <= a3){
                if((m+n)%2 == 0) return (Math.max(a1,a2)+Math.min(a3,a4))/2.0;
                else return Math.max(a1,a2);
            }
            else if(a1 > a4) right = Px-1;
            else left = Px +1;
        }
        return -1;
    }
}