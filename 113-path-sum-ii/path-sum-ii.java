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
    List<List<Integer>> paths=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathAll(root,targetSum,0,new ArrayList<>());
        return paths;
    }
    public void pathAll(TreeNode root,int target,int sum,ArrayList<Integer> path){
        if(root==null) return;
        sum+=root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target){
                paths.add(new ArrayList<>(path));
            }
        }
        else{
            pathAll(root.left,target,sum,path);
            pathAll(root.right,target,sum,path);
        }
        path.remove(path.size()-1);
    }
}