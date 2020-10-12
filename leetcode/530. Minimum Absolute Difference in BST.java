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
    int min_value = Integer.MAX_VALUE;      // 存放最小的差值
    TreeNode prev = null;           // 存放前面的节点

    public void inorder(TreeNode root){     // 中序遍历
        if(root == null) return;    
        inorder(root.left);
        
        if(prev != null){
            int temp = root.val - prev.val;
            min_value = Math.min(min_value, temp);      // 判断是否需要更新最小值
        }
        prev = root;            // 更新前面的节点

        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min_value;
    }
}