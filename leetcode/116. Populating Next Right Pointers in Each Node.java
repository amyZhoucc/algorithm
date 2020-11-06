/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {            // 常规解法——层序遍历
        if(root == null) return root;
        LinkedList<Node>queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Node curr = queue.poll();       // 弹出当前节点
                Node last = new Node();         
                if(size > 1) {                  // 获得目前的队首节点——就是当前节点的下一个节点，且是同层的
                    last = queue.get(0);
                }
                else{                           // 如果是cur该层的最后一个元素，那么next就是null
                    last = null;
                }
                curr.next = last;               // 当前节点指向next节点
                
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
                size--;
            }
        }
        return root;
    }
}


class Solution {                      // 解法1的改进版
    public Node connect(Node root) {
        if(root == null) return root;
        LinkedList<Node>queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = null;           // 保存一个prev节点——那么就不需要额外调用函数list.get(index)来获得队首节点
            while(size > 0){
                Node curr = queue.poll();
                if(prev != null) prev.next = curr;    // prev节点更新next  
                prev = curr;            // 更新prev节点

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
                size--;
            }
        }
        return root;
    }
}


class Solution {                        // 解法2——将对上层链表的遍历转换成对下层节点的连接
    public Node connect(Node root) {
        if(root == null) return root;
        Node cur = root;
        while(cur != null){            // 遍历，直到某一层不存在节点（此时的cur就可看成是链表头）
            Node dummy = new Node(0);       // 设置dummy节点，使操作统一，且方便查找下一层的链表首
            Node prev = dummy;
            while(cur != null && cur.left != null){     // 遍历当前层，因为是完美二叉树，所以左、右节点均存在
                prev.next = cur.left;                   // 将当前节点的左右孩子均连接起来
                cur.left.next = cur.right;

                prev = cur.right;                       // 更新到下一个节点
                cur = cur.next;
                
            }
            cur = dummy.next;           // 当前层遍历完毕，找到下一层的开头继续遍历
        }
        return root;
    }
}


class Solution {                        // 解法3——利用递归思想
    public void construct(Node cur, Node last){
        if(cur == null) return;
        cur.next = last;            // 两个节点连接起来
        construct(cur.left, cur.right);         // 连接左右孩子的
        construct(cur.right, cur.next == null ? null : cur.next.left);      // 连接右孩子和next的左孩子的
    }
    public Node connect(Node root) {
        construct(root, null);
        return root;
    }
}