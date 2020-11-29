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

class Solution {            // 非递归方式求解
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();      // 返回值
        if(root == null) return res;        // 处理特殊情况

        LinkedList<Node> temp = new LinkedList<Node>();       // 当前在栈中的节点
        temp.addLast(root);             // 先将根节点压入栈
        while(!temp.isEmpty()){
            Node cur = temp.pollLast();         // 栈顶元素出栈
            res.add(cur.val);
            int size = cur.children.size() - 1;
            for(; size >= 0; size--){           // 遍历其所有的孩子节点，从右向左依次入栈
                Node child = cur.children.get(size);
                if(child != null)
                    temp.addLast(child);
            }
        }
        return res;
    }
}