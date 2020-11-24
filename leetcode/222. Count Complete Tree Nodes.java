/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // 通用式解法，没有利用完全二叉树的特点，时间复杂度为O(N)
    public int num = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return num;
        countNodes(root.left);
        countNodes(root.right);
        num++;
        return num;
    }
}

class Solution {            // 稍微微优化版本
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}

class Solution {            // 利用了完全二叉树的特性
    private int countLevel(TreeNode root){      // 计算当前二叉树的深度
        int level = 0;
        while(root != null){
            level++;
            root = root.left;       // 根据完全二叉树的特性，从root开始一直搜左一定是最长的
        }
        return level;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftLevel = countLevel(root.left);  // 计算根节点的左/右子树的深度
        int rightLevel = countLevel(root.right);

        if(leftLevel == rightLevel){        // 那么左子树一定满了，再计算右子树即可
            return countNodes(root.right) + (1 << leftLevel);   // 右子树个数+左子树（2^n-1）+1（为root）
        }
        else{               // 那么右子树一定满了，再计算左子树即可
            return countNodes(root.left) + (1 << rightLevel);
        }
    }
}

class Solution {            // 更为巧妙的方法
    private boolean existNode(TreeNode root, int cur, int level){      // 通过位计算当前节点是否存在
        int bit = 1 << (level - 2);         // 因为level表示的是从1开始计算的当前层级，并且我们要排除最高位(表示当前层级)，从第二位开始计算
        while(root != null && bit != 0){
            if((bit & cur) != 0) root = root.right;     // 高位为1，表示在右子树
            else root = root.left;          // 高位为0，表示在左子树
            bit = bit >> 1;
        }
        if(root != null) return true;
        else return false;

    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int level = 0;
        TreeNode node = root;
        while(node != null){        // 遍历到最左节点，求该树的深度
            level++;
            node = node.left;
        }
        int left = (1 << (level - 1));   // 该二叉树最下层的最小值
        int right = (1 << level) - 1;     // 最下层的最大值

        while(left < right){            // 终止条件就是left=right，那么就是找到了——直接返回left就是需要的值
            int mid = (right - left + 1)/2 + left;  // 当两者相等的时候，取后面那个节点
            if(existNode(root, mid, level)){        // 如果存在该节点，那么节点个数>=mid
                left = mid;
            }
            else{           // 如果不存在，那么节点个数<mid
                right = mid - 1;
            }
        }
        return left;
    }
}