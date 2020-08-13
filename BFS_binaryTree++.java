/* TreeNode类，是树节点的属性和函数 */
public class TreeNode {
	int val;		// 节点的值
	TreeNode left;	// 左孩子节点
	TreeNode right;	// 右孩子节点
	TreeNode(int x) { val = x; }
 }

public void levelOrder(TreeNode root){          // 宽度优先遍历
    if(root == null) return null;		// 处理特殊情况
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();		// 存放当前层级的节点
    queue.offer(root);		// 将根节点压入栈
    int depth = 0;			// 记录树的深度
    while(!queue.isEmpty()){		// 开始迭代——当前层存在需要遍历的节点
        int size = queue.size();
        while(size > 0){		// 遍历当前层的所有节点
            TreeNode current = queue.poll();		// 取出队首元素
            if(current.left != null) queue.offer(current.left);		// 将当前节点的左右孩子节点均加入到队尾
            if(current.right != null) queue.offer(current.right);
            size--;
        }
        depth++;
    }
}