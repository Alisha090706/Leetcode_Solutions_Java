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
    int MOD = 1000000007;
    long PROD = 0;
    long SUM = 0;
    public int maxProduct(TreeNode root) {
        SUM = sum(root);
        dfs(root);
        return (int) (PROD % MOD);
    }
    public long sum(TreeNode root) {
        if(root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    public long dfs(TreeNode root){
        if(root == null) return 0;
        long left = dfs(root.left);
        long right = dfs(root.right);
        long subtree = root.val + left + right;
        PROD = Math.max(PROD, subtree * (SUM - subtree));
        return subtree;

    }

}