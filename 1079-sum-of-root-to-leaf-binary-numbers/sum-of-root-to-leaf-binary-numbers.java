/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, new StringBuilder());
    }
    public int solve(TreeNode root, StringBuilder sb){
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            sb.append(root.val);
            int value = Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length() - 1);
            return value;
        }
        sb.append(root.val);
        int left = solve(root.left, sb);
        int right = solve(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);

        return left + right;
    }
}