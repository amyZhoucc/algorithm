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

class Solution {                        // 解法1
    public Node connect(Node root) {
        if(root == null) return root;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            Node prev = new Node();
            while(size > 0){
                Node curr = queue.poll();
                if(prev != null) prev.next = curr;
                prev = curr;
                
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
                size--;
            }
        }
        return root;
    }
}


class Solution {                // 解法1的改进
    public Node connect(Node root) {
        if(root == null) return root;
        Node curr = root;

        while(curr != null){
            Node dummy = new Node(0);
            Node prev = dummy;
            while(curr != null){
                if(curr.left != null){
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if(curr.right != null){
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = dummy.next;
        }
        return root;
    }
}