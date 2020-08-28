/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                    // 递归解法
    public boolean judge(TreeNode root, int num){           // 自己构造一个函数，使之满足参数传递的要求
        if(root == null) return true;                       // 递归的结束条件
        else if(root.val != num) return false;              // 一旦出现不满足，就直接返回，而不会继续遍历下去
        return judge(root.left, num) && judge(root.right, num);     // 到这一步说明当前节点满足要求，转而去遍历其左右子树——都满足要求才行
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;                   // 处理特殊情况——不存在该树
        return judge(root, root.val);                   
    }
}

class Solution {                       // 迭代解法
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;           // 处理特殊情况——不存在该树
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();    // 存放遍历的节点
        queue.offer(root);
        int value = root.val;           // 标注应该相同的值

        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.val != value) return false;

            if(current.left != null) queue.offer(current.left);
            if(current.right != null) queue.offer(current.right);
        }
        return true;
    }
}