/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */ 
class Solution {                    // 递归解法——直接无改进版
    // 根据前序遍历在中序遍历中找根节点的位置，从而划分左右子树
    public int findRoot(int root_val, int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root_val) return i;
        }
        return -1;
    }
    // 构造二叉树的函数，范围是preorder[](左闭右闭), inorder[](左闭右闭)
    // 参数含义：前序数组、中序数组、前序的起始地址、前序的终止地址、中序的起始地址、中序的终止地址
    public TreeNode construct(int[] preorder, int[] inorder, int pre_low, int pre_high, int in_low, int in_high){
        if(pre_low > pre_high) return null;            // 递归终止条件
        int root_index = findRoot(preorder[pre_low], inorder);      // 找到中序中的根节点位置——就是前序中的首地址
        TreeNode root = new TreeNode(preorder[pre_low]);            // 创建一个根节点
        int left_node_num = root_index - in_low;                // 求该节点的左子树的长度
        // 中序中的左、右子树位置确定：先确定根节点在中序的位置，那么中序的该位置之前就是左子树的位置；中序的该位置之后的就是右子树的位置；
        // 前序中的左、右子树位置确定：根据根节点在中序的位置，那么就能确定其左子树的长度，在前序中从首地址~首地址+左子树长度为左子树的范围；那么相应的首地址+左子树长度+1~终止地址为右子树的范围
        root.left = construct(preorder, inorder, pre_low + 1, pre_low + left_node_num, in_low, root_index - 1);  
        root.right = construct(preorder, inorder, pre_low + left_node_num + 1, pre_high, root_index + 1, in_high);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = construct(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return root;
    }
}