/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // 递归方法，基于 DFS 修改实现即可
    public void traversal(TreeNode root, List<Integer>res){
        if(root == null) return;        /* 递归的终止条件，遇到空节点了，那以其为根节点的树不再存在 */
        traversal(root.left, res);      
        traversal(root.right, res);
        res.add(root.val);        /* add 操作 */      
    }
    public List<Integer> postorderTraversal(TreeNode root) {    
        List<Integer>res = new ArrayList<Integer>();    /* 创建一个列表，存放遍历结果*/
        traversal(root, res);
        return res;
    }
}