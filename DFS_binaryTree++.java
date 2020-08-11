/**
 * @brief 二叉树的深度优先遍历模板，以及对应的一些常见的扩展补充，例如求二叉树的深度等
 * 可以在此模板上修改成需要的内容，例如求二叉树的深度等
 */
/**
 * 结点的数据结构
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class DFS_binaryTree{
    public void DFS_Tree(TreeNode root){    /* 根节点开始遍历 */
        if(root == null) return null;       /* 该节点为空，说明从其开始不存在一颗子树，所以直接返回 */
        DFS_Tree(root.left);                /* 递归遍历左孩子节点 */
        DFS_Tree(root.right);               /* 递归遍历又孩子节点 */
    }

    /* 通过基本的 DFS，进行二叉树深度的计算 */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;      /* 空节点，直接返回不计数 */
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    /* 前、中、后序的遍历 */
    /* 通过基本的 DFS，实现前序遍历 */
    public void preorderTraversal(TreeNode root){
        if(root == null) return null;
        System.out.println(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    /* 通过基本的 DFS，实现前序遍历 */
    public void inorderTraversal(TreeNode root){
        if(root == null) return null;
        inorderTraversal(root.left);
        System.out.println(root.val);
        inorderTraversal(root.right);
    }
    
    /* 通过基本的 DFS，实现前序遍历 */
    public void postorderTraversal(TreeNode root){
        if(root == null) return null;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.println(root.val);
    }
}