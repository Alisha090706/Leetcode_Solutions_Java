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
class Pair{
    boolean balanced;
    int height;
    Pair(boolean b, int h){
        this.balanced = b;
        this.height = h;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        Pair ans = solve(root);
        return ans.balanced;
    }
    public Pair solve(TreeNode root){
        if(root == null) return new Pair(true,0);
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        if(!left.balanced || !right.balanced) return new Pair(false,0);
        int lefth = left.height;
        int righth = right.height;
        if(Math.abs(lefth - righth) > 1) return new Pair(false,0);
        return new Pair(true, 1 + Math.max(lefth,righth));
    }
}