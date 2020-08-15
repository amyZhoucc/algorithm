/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {                    // �ݹ�ⷨ
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;        // �ݹ����ֹ����
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;          // �������ڵ㻥�����ɣ�����ڵ�Ϊroot���������Ѿ���ת����
        root.right = left;
        return root;
    }
}

class Solution {                    // �����ⷨ����ȫ����ģ��
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;       // �����������
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode current = queue.poll();
                TreeNode temp = current.right;          // �������Һ��ӽڵ�Ļ���
                current.right = current.left;
                current.left = temp;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
                size--;
            }
        }
        return root;
    }
}

class Solution {            // �����ⷨ����΢�����޸�
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;       // �����������
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){                // ����Ҫ�ٿ���һ��һ������Խ��ޣ�ֻ��Ҫ��֤���������нڵ㼴��
                TreeNode current = queue.poll();
                TreeNode temp = current.right;
                current.right = current.left;
                current.left = temp;
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
        }
        return root;
    }
}