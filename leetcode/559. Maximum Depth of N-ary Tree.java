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

class Solution {                        // 递归方法，基于二叉树的深度扩展而来
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;          // 该树不存在的情况
        }
        else if(root.children.isEmpty()) {
            return 1;      // 该树只有根节点本身的情况
        }
        else{
            List<Integer> depth = new ArrayList<Integer>();     // 创建一个list，用来存放其孩子子树的深度
            for(Node child: root.children){                 // 遍历所有孩子子树，获得他们的树深
                depth.add(maxDepth(child));
            }
            return Collections.max(depth) + 1;             // 其孩子子树的最大深度+其本身
        }

    }
}

class Solution {                    // 迭代的方法，是基于 BFS 的求解
    public int maxDepth(Node root) {
        if(root == null) return 0;          // 处理特殊情况
        LinkedList<Node> list = new LinkedList<Node>();     // 创建一个链表存放当前层的节点
        int depth = 0;
        list.offer(root);       // 初始情况
        while(!list.isEmpty()){         // 迭代条件——当前层不为空的情况下
            int size = list.size();     // 求当前层的节点个数
            while(size > 0){            // 循环条件——遍历完所有本层的节点
                Node current = list.poll();     // 取出当前遍历的节点
                for(Node child: current.children){  // 遍历当前节点的所有孩子节点，把他们都插入到链表尾部
                    list.offer(child);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}