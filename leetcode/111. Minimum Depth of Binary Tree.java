/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                                // 递归（方便理解版）
    public int minDepth(TreeNode root) {
        if(root == null) return 0;              // 递归终止条件
        if(root.left == null && root.right == null) return 1;           // 均不存在，就已经到了根节点，那么直接返回1（本身深度）

        int left_depth = minDepth(root.left);
        int right_depth = minDepth(root.right);
        if(root.left == null || root.right == null) return left_depth + right_depth + 1;        // 如果有一个不存在（至少存在一个），那么就返回存在的那个（当前节点就不会是叶子节点）
        return Math.min(left_depth, right_depth) + 1;               // 如果两个都存在，就返回小的值（因为不进行判断的话，肯定是0最小的，所以结果是存在问题的）
    }
}

class Solution {                                // 递归（整理简化版）
    public int minDepth(TreeNode root) {
        if(root == null) return 0;              // 递归终止条件
        int left_depth = minDepth(root.left);
        int right_depth = minDepth(root.right);
        // 首先需要判断其左右子树是否存在——左、右有一个不存在，那么就需要返回存在的那个（因为存在左or右，那么就不能说是叶子节点了），如果左右均不存在，那都是0，0+1，结果正确
        return root.left == null || root.right == null ? left_depth + right_depth + 1: Math.min(left_depth, right_depth) + 1;
    }
}

class Solution {                // 迭代
    public int minDepth(TreeNode root) {
        if(root == null) return 0;          // 处理特殊情况
        if(root.left == null && root.right == null) return 1;       // 特殊情况：左右节点均不存在，那么就直接返回1
        LinkedList<TreeNode> tree = new LinkedList<TreeNode>();
        tree.offer(root);
        int depth = 0;
        while(!tree.isEmpty()){
            int size = tree.size();
            while(size > 0){
                TreeNode current = tree.poll();
                if(current.left == null && current.right == null) return depth + 1;         // 一旦出了某个叶子节点（其左右孩子均不存在，那么就返回当前深度+1（其本身））
                if(current.left != null) tree.offer(current.left);                          // 否则就继续迭代遍历
                if(current.right != null) tree.offer(current.right);
                size--;
            }
            depth++;
        }
        return depth;
    }
}