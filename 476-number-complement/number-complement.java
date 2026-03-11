class Solution {
    public int findComplement(int num) {
        int size = Integer.toBinaryString(num).length();
        int n = (1 << size) - 1;

        return n ^ num;
    }
}