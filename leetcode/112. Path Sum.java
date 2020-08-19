/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                            // 迭代方法，基于 BFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;          // 处理特殊情况
        LinkedList<TreeNode> node = new LinkedList<TreeNode>();     // BFS遍历的链表
        LinkedList<Integer> pathVal = new LinkedList<Integer>();            // 对应的路径链表

        node.offer(root);
        pathVal.offer(root.val);

        while(!node.isEmpty()){
            TreeNode current = node.poll();     // 获得当前遍历的节点
            int current_path_val = pathVal.poll();      // 获得从根节点到当前节点的路径值
            if(current_path_val == sum && current.left == null && current.right == null)   // 值符合，且是叶子节点，目标获得
                return true;
            if(current.left != null){
                node.offer(current.left);
                pathVal.offer(current_path_val + current.left.val);
            }
            if(current.right != null){
                node.offer(current.right);
                pathVal.offer(current_path_val + current.right.val);
            }
        }
        return false;
    }
}

class Solution {                            // 递归方法
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return sum == root.val;
        
        boolean ret_left = hasPathSum(root.left, sum - root.val);
        boolean ret_right = hasPathSum(root.right, sum - root.val);
        return ret_left || ret_right;
    }
}