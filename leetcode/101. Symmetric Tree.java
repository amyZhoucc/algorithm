/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                                // 递归求解
    public boolean judge(TreeNode left_node, TreeNode right_node){          // 实际的判断函数
        if(left_node == null && right_node == null) return true;            // 处理特殊情况
        else if(left_node == null || right_node == null) return false;      // 只存在一个null
        else if(left_node.val != right_node.val) return false;              // 两个值都存在，但是值不等，那就是不对称——直接返回
        // 到这一步，说明left和right的值相等
        return judge(left_node.left, right_node.right) && judge(left_node.right, right_node.left);  // 必须同时满足——才是对称的
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;   // 处理最大的特殊情况——整个棵树为空
        return judge(root.left, root.right);   // 去调用左右子树的判断函数
    }
}


class Solution {                        // 迭代求解
    public boolean judge(TreeNode left_node, TreeNode right_node){          // 实际的判断函数
        LinkedList<TreeNode> queue= new LinkedList<TreeNode>();      // 存放遍历的队列
        queue.offer(left_node);         // 将根节点的左、右节点都压入队列
        queue.offer(right_node);

        while(!queue.isEmpty()){
            left_node = queue.poll();       // 同时弹出两个节点——左右节点
            right_node = queue.poll();
            if(left_node == null && right_node == null) continue;       // 均为null，那么就跳过下面步骤——不存在左右孩子
            else if(left_node == null || right_node == null) return false;      // 排除不满足的情况——直接返回
            else if(left_node.val != right_node.val) return false;

            queue.offer(left_node.left);               // 将左的左孩子和右的右孩子压入——之后一起弹出判断
            queue.offer(right_node.right);
            
            queue.offer(left_node.right);               // 将左的右孩子和右的左孩子压入——之后一起弹出判断
            queue.offer(right_node.left);
        }
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;   // 处理最大的特殊情况——整个棵树为空
        return judge(root.left, root.right);   // 去调用左右子树的判断函数
    }
}