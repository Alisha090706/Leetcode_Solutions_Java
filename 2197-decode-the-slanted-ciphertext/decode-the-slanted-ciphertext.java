class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n / rows;

        StringBuilder sb = new StringBuilder();

        for(int c = 0; c < cols; c++) {
            int r = 0;
            int j = c;
            while(r < rows && j < cols) {
                sb.append(encodedText.charAt(r * cols + j));
                r++;
                j++;
            }

        }
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }
        return sb.substring(0, end + 1);
    }
}