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
    public TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if(prev != null){
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        flatten(left);
        flatten(right);
    }
}