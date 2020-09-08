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
    public TreeNode buildTree(int left, int right, int[] nums){
        if(left == right) return null;                   // 处理特殊情况
        int mid = left + (right - 1 - left) / 2;        // 找到该范围内的中点
        TreeNode root = new TreeNode(nums[mid]);         // 将该点设为当前的根节点
        root.left = buildTree(left, mid, nums);       // 范围是[)
        root.right = buildTree(mid + 1, right, nums);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length, nums);          // 去调用实际的构造函数
    }
}