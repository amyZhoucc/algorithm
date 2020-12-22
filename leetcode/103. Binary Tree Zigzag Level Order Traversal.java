/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {        // 笨蛋解法（遍历的时候从尾部开始遍历，找孩子的时候按照flag来找）
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        boolean flag = true;    // 找孩子 left->right= true;right->left=false;

        LinkedList<TreeNode> store = new LinkedList<>();    // 存储当前层的节点
        store.offer(root); 

        while(!store.isEmpty()){
            int size = store.size();    // 获得当前层节点个数
            ArrayList<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode cur = store.remove(size - 1);  // 从后向前删节点
                temp.add(cur.val);      // 删除的节点就是被遍历到的节点
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
            res.add(temp);      // 将当前层列表加入到总列表中
            flag = !flag;
        }
        return res;
    }
}

class Solution {            // 更机智的解法——遍历的时候修改插入的方法：头插（右->左）；尾插（左->右）
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        boolean flag = true;    // 遍历的节点插入方法：true——尾插；false——头插

        LinkedList<TreeNode> store = new LinkedList<>();    // 存储当前层的节点
        store.offer(root); 

        while(!store.isEmpty()){
            int size = store.size();    // 获得当前层节点个数
            ArrayList<Integer> temp = new ArrayList<>();
            while(size > 0){
                TreeNode cur = store.poll();  // 删除头结点
                if(flag) temp.add(cur.val);      // 删除的节点就是被遍历到的节点
                else temp.add(0, cur.val);

                if(cur.left != null) store.offer(cur.left);
                if(cur.right != null) store.offer(cur.right);
                size--;
            }
            res.add(temp);      // 将当前层列表加入到总列表中
            flag = !flag;
        }
        return res;
    }
}