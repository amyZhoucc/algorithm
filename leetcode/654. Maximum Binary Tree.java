/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                    // 递归的方法
    // 求数组中的最大值——返回最大值的下标
    public int maxNum(int[] nums){
        int max_index = 0;              
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[max_index]) max_index = i;
        }
        return max_index;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;           // 递归终止条件
        int max_index = maxNum(nums);       // 求当前数组的最大值
        TreeNode root = new TreeNode(nums[max_index]);              // 创建根节点
        int[] leftArray = Arrays.copyOfRange(nums, 0, max_index);                   // 构建左边的数组——O(n)时间复杂度，且需要额外的内存空间
        int[] rightArray = Arrays.copyOfRange(nums, max_index + 1, nums.length);        // 构建右边的数组，O(n)时间复杂度，且需要额外的内存空间
        TreeNode left = constructMaximumBinaryTree(leftArray);              // 递归调用去创建左右子树
        TreeNode right = constructMaximumBinaryTree(rightArray);
        root.left = left;               // 更新该根节点的左右孩子
        root.right = right;
        return root;
    }
}


class Solution {                // 稍微改进的递归算法（去掉不必要的时间和空间消耗）——是在原数组上进行的操作
    // 求数组中的最大值——返回最大值的下标
    public int maxNum(int[] nums, int low, int high){
        int max_index = low;              
        for(int i = low; i < high; i++){
            if(nums[i] > nums[max_index]) max_index = i;
        }
        return max_index;
    }
    // 为二叉树的构造函数——主要是为了方便传参，所以不在原来的函数基础上，而是重建一个函数
    public TreeNode construct(int[]nums, int low, int high){
        if(high == low) return null;           // 递归终止条件
        int max_index = maxNum(nums, low, high);       // 求当前数组的最大值
        TreeNode root = new TreeNode(nums[max_index]);          // 创建当前树的根节点
        root.left = construct(nums, low, max_index);            // 递归调用创建左、右子树， 传递的数组是左闭右开[)
        root.right = construct(nums, max_index + 1, high);      
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = construct(nums, 0, nums.length);
        return root;
    }
}