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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;

        return sum(root,targetSum,0);
    }
    public boolean sum(TreeNode root,int target,int sum){
        if(root==null){
            return false;
        }
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==target) return true;
        }
        return sum(root.left,target,sum) || sum(root.right,target,sum);
    }
}