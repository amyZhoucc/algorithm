/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // �ݹ�ⷨ����Ҫ��ѡһ��root��Ϊ����������һ��root��Ϊ����
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {  
        if(t1 == null && t2 == null) return null;           // �ݹ����ֹ����
        else if(t1 == null && t2 != null) return t2;        // �ýڵ��null���Ǿͷ��ظýڵ㼴��
        else if(t1 != null && t2 == null) return t1;

        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        t1.left = left;
        t1.right = right;
        t1.val += t2.val;                                   // ��������ڵ㶼���ڣ�����Ҫ���
        return t1;
    }
}

*/
class Solution {        // �����ⷨ��t1��Ϊ������
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;           // �ų��������
        else if(t2 == null) return t1;

        LinkedList<TreeNode[]> queue = new LinkedList<>();      // ��ű���ʱ�Ľڵ�����Һ��ӽڵ�
        queue.offer(new TreeNode[] {t1, t2});           // ��ʼ������ڵ�
        while(!queue.isEmpty()){
            TreeNode[] current = queue.poll();
            if(current[0] == null || current[1] == null) continue;      // ֻҪ��һ���ڵ�Ϊ�գ���ô������ڵ�Ϊ���Ͳ���Ҫ�����ˣ���������Ĳ���
            current[0].val += current[1].val;
            if(current[0].left == null){                    // ���t1������Ϊnull����ô�Ͱ�t2�����ӵ���t1�����ӣ����ǲ���Ҫ�ٱ�����
                current[0].left = current[1].left;
            }
            else{                                           // 2�������left��Ϊnull��rightΪnull/��������Ϊnull
                queue.offer(new TreeNode[] {current[0].left, current[1].left});
            }
            if(current[0].right == null){   // ͬ������
                current[0].right = current[1].right;
            }
            else{
                queue.offer(new TreeNode[] {current[0].right, current[1].right});
            }
        }
        return t1;
    }
}