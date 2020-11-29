/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> res = new ArrayList<Integer>();
    public void dfs(Node root){
        if(root == null) return;
        res.add(root.val);
        for(Node child: root.children){
            dfs(child);
        }
    }
    public List<Integer> preorder(Node root) {
        dfs(root);
        return res;
    }
}

class Solution {            // �ǵݹ鷽ʽ���
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();      // ����ֵ
        if(root == null) return res;        // �����������

        LinkedList<Node> temp = new LinkedList<Node>();       // ��ǰ��ջ�еĽڵ�
        temp.addLast(root);             // �Ƚ����ڵ�ѹ��ջ
        while(!temp.isEmpty()){
            Node cur = temp.pollLast();         // ջ��Ԫ�س�ջ
            res.add(cur.val);
            int size = cur.children.size() - 1;
            for(; size >= 0; size--){           // ���������еĺ��ӽڵ㣬��������������ջ
                Node child = cur.children.get(size);
                if(child != null)
                    temp.addLast(child);
            }
        }
        return res;
    }
}