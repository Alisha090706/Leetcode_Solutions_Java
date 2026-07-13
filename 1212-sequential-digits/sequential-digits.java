class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> sequentialDigits(int low, int high) {
        for(int i = 1; i < 9; i++) {
            solve(i, i, low, high);
        }
        Collections.sort(list);
        return list;
    }
    public void solve(int num, int digit, int low ,int high) {
        if(num > high || digit == 0) return;
        if(num >= low && num <= high) {
            list.add(num);
        }
        int newNum = num * 10 + (digit + 1) % 10;
        
        solve(newNum, newNum % 10, low, high);

    }
}