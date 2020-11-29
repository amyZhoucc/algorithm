/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // dfs解法
    public static int num;
    public static int target;
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        num--;
        if(num == 0){           // 说明找到正确解了
            target =root.val;
        }
        if(num <= 0) return;// 找到解之后，不再递归下去（就是执行下面的left了），而是需要逐渐返回了——而返回的节点们都已经到了这步，所以判断<=0之后就可以返回了
        dfs(root.left);
    }
    public int kthLargest(TreeNode root, int k) {
        num = k;
        dfs(root);
        return target;
    }
}

class Solution {            // 稍微一丢丢的优化
    public static int num;
    public static int target;
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(num == 0){       // 已经找到过正确解了——直接返回
            return;
        }
        if(--num == 0){     // 如果--之后满足，那么就是正解；否则的话，就只是--
            target = root.val;
            return;
        }
        dfs(root.left);
    }
    public int kthLargest(TreeNode root, int k) {
        num = k;
        dfs(root);
        return target;
    }
}