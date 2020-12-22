/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {        // �����ⷨ��������ʱ���β����ʼ�������Һ��ӵ�ʱ����flag���ң�
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        boolean flag = true;    // �Һ��� left->right= true;right->left=false;

        LinkedList<TreeNode> store = new LinkedList<>();    // �洢��ǰ��Ľڵ�
        store.offer(root); 

        while(!store.isEmpty()){
            int size = store.size();    // ��õ�ǰ��ڵ����
            ArrayList<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode cur = store.remove(size - 1);  // �Ӻ���ǰɾ�ڵ�
                temp.add(cur.val);      // ɾ���Ľڵ���Ǳ��������Ľڵ�
                if(flag){
                    if(cur.left != null) store.offer(cur.left);
                    if(cur.right != null) store.offer(cur.right);
                }
                else{
                    if(cur.right != null) store.offer(cur.right);
                    if(cur.left != null) store.offer(cur.left);
                }
                size--;
            }
            res.add(temp);      // ����ǰ���б���뵽���б���
            flag = !flag;
        }
        return res;
    }
}

class Solution {            // �����ǵĽⷨ����������ʱ���޸Ĳ���ķ�����ͷ�壨��->�󣩣�β�壨��->�ң�
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        boolean flag = true;    // �����Ľڵ���뷽����true����β�壻false����ͷ��

        LinkedList<TreeNode> store = new LinkedList<>();    // �洢��ǰ��Ľڵ�
        store.offer(root); 

        while(!store.isEmpty()){
            int size = store.size();    // ��õ�ǰ��ڵ����
            ArrayList<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode cur = store.poll();  // ɾ��ͷ���
                if(flag) temp.add(cur.val);      // ɾ���Ľڵ���Ǳ��������Ľڵ�
                else temp.add(0, cur.val);

                if(cur.left != null) store.offer(cur.left);
                if(cur.right != null) store.offer(cur.right);
                size--;
            }
            res.add(temp);      // ����ǰ���б���뵽���б���
            flag = !flag;
        }
        return res;
    }
}