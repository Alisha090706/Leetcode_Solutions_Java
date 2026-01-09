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
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null && root.right == null) return -1;

        Queue<TreeNode> q = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();

        q.add(root);
        set.add(root.val);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                q.add(curr.left);
                set.add(curr.left.val);
            }
            if(curr.right != null){
                q.add(curr.right);
                set.add(curr.right.val);
            }
        }
        if(set.size() == 1) return -1;
        ArrayList<Integer> list = new ArrayList<>(set);
        return list.get(1);
    }
}