/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // dfs�ⷨ
    public static int num;
    public static int target;
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        num--;
        if(num == 0){           // ˵���ҵ���ȷ����
            target =root.val;
        }
        if(num <= 0) return;// �ҵ���֮�󣬲��ٵݹ���ȥ������ִ�������left�ˣ���������Ҫ�𽥷����ˡ��������صĽڵ��Ƕ��Ѿ������ⲽ�������ж�<=0֮��Ϳ��Է�����
        dfs(root.left);
    }
    public int kthLargest(TreeNode root, int k) {
        num = k;
        dfs(root);
        return target;
    }
}

class Solution {            // ��΢һ�������Ż�
    public static int num;
    public static int target;
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        if(num == 0){       // �Ѿ��ҵ�����ȷ���ˡ���ֱ�ӷ���
            return;
        }
        if(--num == 0){     // ���--֮�����㣬��ô�������⣻����Ļ�����ֻ��--
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