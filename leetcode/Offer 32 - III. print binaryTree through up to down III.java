/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                    // 策略1——按照不同层，最后将不同层的数组倒置
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();    // 创建一个链表存储当前层的节点
        List<List<Integer>> res = new ArrayList<>();            // 创建一个结果
        if(root == null) return res;
        int depth = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            res.add(new ArrayList<>());
            int size = queue.size();
            while(size > 0){
                TreeNode current = queue.poll();
                res.get(depth).add(current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                size--;
            }
            if(depth % 2 != 0) Collections.reverse(res.get(depth));
            depth++;
        }
        return res;
    }
}

class Solution {            // 策略2——按照不同层，选择头插法 or 尾插法，本质还是 BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();    // 创建一个链表存储当前层的节点
        List<List<Integer>> res = new LinkedList<>();            // 创建一个结果
        if(root == null) return res;
        int depth = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int size = queue.size();
            while(size > 0){
                TreeNode current = queue.poll();
                if(depth % 2 == 0) temp.addLast(current.val);
                else temp.addFirst(current.val);
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                size--;
            }
            res.add(temp);
            depth++;
        }
        return res;
    }
}