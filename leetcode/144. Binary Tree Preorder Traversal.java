/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                // 递归方法，基于 DFS 修改实现即可
    public void traversal(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        traversal(root.left, res);
        traversal(root.right, res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
}