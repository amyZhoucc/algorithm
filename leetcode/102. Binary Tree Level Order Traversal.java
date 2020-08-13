/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // BFS遍历，基本算法结构，外加输出即可
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();    // 创建一个结果的二级数组
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();        // 存放当前层的节点
        if(root == null) return res;
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            res.add(new ArrayList<>());     // 添加新的一层的数组
            int size = queue.size();        // 获得当前层级的节点个数‘
            while(size > 0){
                TreeNode current = queue.poll();       // 出队
                res.get(depth).add(current.val);        
                if(current.left != null)  queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                size--;
            }
            depth++;
        }
        return res;
    }
}