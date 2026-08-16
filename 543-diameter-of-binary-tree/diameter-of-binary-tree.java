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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int leftH = maxHeight(root.left);
        int rightH = maxHeight(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int dia1 = leftH + rightH;
        int dia2 = Math.max(left, right);
        return Math.max(dia1, dia2);
    }
    public int maxHeight(TreeNode root) {
        if(root == null) return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        return 1 + Math.max(left, right);
    }
}