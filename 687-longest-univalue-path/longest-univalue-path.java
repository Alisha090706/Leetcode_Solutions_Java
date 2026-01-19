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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftLength = 0;
        int rightLength = 0;
        if(root.left != null && root.left.val == root.val){
            leftLength = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rightLength = right + 1;
        }
        max = Math.max(max, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }
}