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
    List<TreeNode> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return splitAndMerge(0,list.size()-1);
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    public TreeNode splitAndMerge(int left,int right){
        if(left <= right){
            int mid = (left + right) / 2;
            TreeNode middleroot = list.get(mid);
            middleroot.left = splitAndMerge(left,mid-1);
            middleroot.right = splitAndMerge(mid+1,right);
            return middleroot;
        }
        return null;
    }
}