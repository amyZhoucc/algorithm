/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }public
};
*/
class Solution {            // 我的解法——中序遍历修改一点点
    public Node prev;
    public Node head = new Node();      // 保存一个dummy节点
    public void dfs(Node root){
        if(root == null) return;            // 递归终止条件
        Node left = root.left;              // 保护一下左右指向的节点
        Node right = root.right;

        dfs(left);
        
        prev.right = root;
        root.left = prev;
        root.right = head;      // 当前的root是最后一个节点，要去指向整个链表的头节点
        head.left = root;       // 而头结点要去指向链表的尾节点（主要是为了保持，最后一个节点能够直接被找到）
        prev = root;

        dfs(right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;       // 如果树为空，直接返回null
        prev = head;
        dfs(root);              // 递归调用
        head.right.left = head.left;        // 链表真实头节点的prev指向修改为链表尾（本来头的prev指向了head，现在要指向尾节点，就是head的right）
        head.left.right = head.right;       // 链表尾节点的next指向修改为链表真实头（本来尾的next指向了head，现在要指向第一个真实元素，就是head的next）
        return head.right;
    }
}

class Solution {            // 优化版本
    public Node prev, head;
    public void dfs(Node root){
        if(root == null) return;
        dfs(root.left);
        if(prev != null) {         // prev != null，表示非第一个节点，那么两个值赋值即可
            prev.right = root;
            root.left = prev;
        }
        else head = root;       // prev == null，表示是第一个节点，那么就是链表首元素，进行存放
        prev = root;
        dfs(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;   
        dfs(root);
        head.left = prev;           // 到此时，dfs执行完成，那么prev就是当前的尾节点
        prev.right = head;          // head就是链表头，将两者连接一下即可
        return head;
    }
}