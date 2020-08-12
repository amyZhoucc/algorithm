/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                // 递归方法，基于 DFS 修改实现即可
    public void traversal(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        traversal(root.left, res);
        traversal(root.right, res);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traversal(root, res);
        return res;
    }
}

class Solution {            // 迭代法，需要自己创建栈来实现
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();      // 存放要遍历的栈
        LinkedList<Integer> res = new LinkedList<Integer>();          // 存放前序遍历的数据的栈
        if(root == null) return res;        // 排除特殊情况
        stack.offer(root);          // 把根节点放入栈中
        while(!stack.isEmpty()){            // 迭代结束条件：栈为空
            TreeNode node = stack.pollLast();   // 取出栈顶元素
            res.offer(node.val);      // 将该节点的值压入结果栈中
            if(node.right != null) stack.add(node.right);   // 先存放右节点，后存放左节点
            if(node.left != null) stack.add(node.left);    
        }
        return res;     // 最后的输出顺序还是按照入栈的先后排列，先进先打印
    }
}

class Solution {        // 另一种迭代方法，为了和中序、后序遍历进行统一
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();      // 存放要遍历的栈
        LinkedList<Integer> res = new LinkedList<Integer>();          // 存放前序遍历的数据的栈
        TreeNode current =  root;
        while(current != null || !stack.isEmpty()){         // 迭代条件——同意
            if(current != null){
                res.offer(current.val);     // 将当前节点插入到结果链表中
                stack.offer(current);       // 当前节点压入栈           
                current = current.left;     // 继续深入左孩子节点
            }
            else{       // 当前节点的左子树遍历完成了
                current = stack.pollLast();
                current = current.right;
            }
        }
        return res;
    }
}