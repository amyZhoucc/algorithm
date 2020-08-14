/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];         // 处理特殊情况
        LinkedList<TreeNode>queue = new LinkedList<TreeNode>();     // 创建一个队列，存放当前层的节点
        ArrayList<Integer> value = new ArrayList<Integer>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();        // 获得当前层的节点个数
            while(size > 0){
                TreeNode current = queue.poll();        // 取出队首节点
                value.add(current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                size--;
            }
        }
        int[] res = new int[value.size()];          // 之后进行转换
        for(int i = 0; i < value.size(); i++){
            res[i] = value.get(i);
        }
        return res;
    }
}