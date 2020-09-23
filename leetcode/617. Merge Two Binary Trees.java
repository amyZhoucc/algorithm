/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // 递归解法，需要挑选一个root作为被加树，另一个root作为加树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {  
        if(t1 == null && t2 == null) return null;           // 递归的终止条件
        else if(t1 == null && t2 != null) return t2;        // 还可以简化一下的
        else if(t1 != null && t2 == null) return t1;

        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        t1.left = left;
        t1.right = right;
        t1.val += t2.val;                                   // 如果两个节点均存在，那么需要值相加
        return t1;
    }
}

*/
class Solution {        // 迭代解法，且t1作为被加树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;           // 处理特殊情况
        else if(t2 == null) return t1;

        LinkedList<TreeNode[]> queue = new LinkedList<>();      // 构建一个队列存放遍历的节点，且元素是数组
        queue.offer(new TreeNode[] {t1, t2});               // 将根节点插入队列中——这边能保证根节点一定存在

        while(!queue.isEmpty()){                // 当队列不为空
            TreeNode[] current = queue.poll();          // 弹出当前节点
            if(current[0] == null || current[1] == null){       // 防止下面的加操作报错——因为下面两个else，存在t2为null的情况
                continue;
            }
            current[0].val += current[1].val;

            if(current[0].left == null) {           // t1的左孩子为空，那么直接将t2的左孩子当作t1的左孩子
                current[0].left = current[1].left;
            }
            else{                             //t1的左孩子不为空，那么加入队列，存在两种情况：t1!=null t2!=null/t1!=null t2==null
                queue.offer(new TreeNode[] {current[0].left, current[1].left});
            }

            if(current[0].right == null){           // 同左孩子
                current[0].right = current[1].right;
            }
            else{
                queue.offer(new TreeNode[] {current[0].right, current[1].right});
            }
        }
        return t1;
    }
}