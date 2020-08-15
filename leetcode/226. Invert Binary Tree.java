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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;        // 递归的终止条件
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;          // 将两个节点互换即可，以其节点为root的子树都已经翻转好了
        root.right = left;
        return root;
    }
}

class Solution {                    // 迭代解法，完全按照模板
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;       // 处理特殊情况
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode current = queue.poll();
                TreeNode temp = current.right;          // 进行左右孩子节点的互换
                current.right = current.left;
                current.left = temp;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                size--;
            }
        }
        return root;
    }
}

class Solution {            // 迭代解法，稍微有所修改
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;       // 处理特殊情况
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){                // 不需要再考虑一层一层的明显界限，只需要保证遍历到所有节点即可
                TreeNode current = queue.poll();
                TreeNode temp = current.right;
                current.right = current.left;
                current.left = temp;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
        }
        return root;
    }
}