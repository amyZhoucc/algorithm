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
        else if(t1 == null && t2 != null) return t2;        // 该节点非null，那就返回该节点即可
        else if(t1 != null && t2 == null) return t1;

        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        t1.left = left;
        t1.right = right;
        t1.val += t2.val;                                   // 如果两个节点都存在，就需要相加
        return t1;
    }
}

*/
class Solution {        // 迭代解法，t1作为被加树
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;           // 排除特殊情况
        else if(t2 == null) return t1;

        LinkedList<TreeNode[]> queue = new LinkedList<>();      // 存放遍历时的节点的左右孩子节点
        queue.offer(new TreeNode[] {t1, t2});           // 初始放入根节点
        while(!queue.isEmpty()){
            TreeNode[] current = queue.poll();
            if(current[0] == null || current[1] == null) continue;      // 只要有一个节点为空，那么以这个节点为树就不需要操作了，跳过下面的步骤
            current[0].val += current[1].val;
            if(current[0].left == null){                    // 如果t1的左孩子为null，那么就把t2的左孩子当作t1的左孩子，但是不需要再遍历了
                current[0].left = current[1].left;
            }
            else{                                           // 2种情况：left不为null，right为null/两个均不为null
                queue.offer(new TreeNode[] {current[0].left, current[1].left});
            }
            if(current[0].right == null){   // 同左子树
                current[0].right = current[1].right;
            }
            else{
                queue.offer(new TreeNode[] {current[0].right, current[1].right});
            }
        }
        return t1;
    }
}