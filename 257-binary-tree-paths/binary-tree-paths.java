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
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        solve(root,new StringBuilder());
        return result;
    }
    public void solve(TreeNode root, StringBuilder sb){
        if(root == null) return;
        int length = sb.length();

        if(root.left == null && root.right == null){
            sb.append(root.val);
            result.add(sb.toString());
        }
        else{
            sb.append(root.val).append("->");
            solve(root.left, sb);
            solve(root.right, sb);
        }
        sb.setLength(length);
    }
}