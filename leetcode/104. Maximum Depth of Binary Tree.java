/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // 递归解法
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;      /* 空节点，直接返回不计数 */
        int left_depth = maxDepth(root.left);       // 求左子树的深度
        int right_depth = maxDepth(root.right);     // 求右子树的深度
        return Math.max(left_depth, right_depth) + 1;   // 两个子树的最大值+其本身
    }
}

class Solution {            // 广度优先遍历
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;      /* 空节点，直接返回不计数 */
        LinkedList<TreeNode> tree = new LinkedList<TreeNode>();   // 存放当前层的节点链表
        int depth = 0;
        tree.offer(root);       // 首先将根节点压入栈
        while(!tree.isEmpty()){         // 迭代条件：当前层存在节点——当前层一个节点也没有了，说明已经遍历到最后一层的下面了
            int size = tree.size();         // 求当前层的节点个数
            while(size > 0){                // 遍历当前层的所有节点
                TreeNode current = tree.poll();     // 弹出链表头
                if(current.left != null) tree.offer(current.left);      // 将该节点的左孩子插入到链表尾部
                if(current.right != null) tree.offer(current.right);    // 将该节点的右孩子插入到链表尾部
                size--;
            }
            depth++;
            // 每次到这边，都说明当前层的节点已经全部遍历完成了，现在要开始遍历下一层
        }
        return depth;
    }
}