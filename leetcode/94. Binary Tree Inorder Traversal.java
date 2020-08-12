/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // 递归方法，基于 DFS 修改实现即可
    public void traversal(TreeNode root, List<Integer> res){
        if(root == null) return;
        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
}

class Solution {            // 迭代方法
    public List<Integer> inorderTraversal(TreeNode root) { 
        LinkedList<Integer> res = new LinkedList<Integer>();     // 存放中序遍历的链表
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();    // 模拟堆栈
        TreeNode current = root;        // 存放当前遍历的节点
        while(current != null || !stack.isEmpty()){     // 迭代条件
            while(current != null){     // 一直深挖，直到遇到没有左孩子节点——current节点压栈、并且更新current为其左孩子
                stack.offer(current);
                current = current.left;
            }
            // 到这一步，是current为null
            current = stack.pollLast(); // 弹出栈顶节点（最新入栈的）
            res.offer(current.val);     // 放入遍历链表
            current = current.right;    // 更新current——到这一步，说明current节点的左子树已经遍历完成了，开始遍历右子树
        }      
        return res;
    }
}

class Solution {            // 另一种迭代方法，为了统一格式
    public List<Integer> inorderTraversal(TreeNode root) { 
        LinkedList<Integer> res = new LinkedList<Integer>();     // 存放中序遍历的链表
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();    // 模拟堆栈
        TreeNode current = root;        // 存放当前遍历的节点
        while(current != null || !stack.isEmpty()){     // 迭代条件
            if(current != null){     // 一直深挖，直到遇到没有左孩子节点
                stack.offer(current);
                current = current.left;
            }
            else{
                // 到这一步，是current为null
                current = stack.pollLast(); // 弹出栈顶节点（最新入栈的）
                res.offer(current.val);     // 放入遍历链表
                current = current.right;
            }
        }      
        return res;
    }
}