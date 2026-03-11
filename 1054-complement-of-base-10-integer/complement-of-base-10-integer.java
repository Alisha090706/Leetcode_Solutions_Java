class Solution {
    public int bitwiseComplement(int n) {
        int size = Integer.toBinaryString(n).length();
        int num = (int) Math.pow(2, size) - 1;

        return n ^ num;
    }
}