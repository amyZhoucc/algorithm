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
    int min_value = Integer.MAX_VALUE;      // �����С�Ĳ�ֵ
    TreeNode prev = null;           // ���ǰ��Ľڵ�

    public void inorder(TreeNode root){     // �������
        if(root == null) return;    
        inorder(root.left);
        
        if(prev != null){
            int temp = root.val - prev.val;
            min_value = Math.min(min_value, temp);      // �ж��Ƿ���Ҫ������Сֵ
        }
        prev = root;            // ����ǰ��Ľڵ�

        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min_value;
    }
}