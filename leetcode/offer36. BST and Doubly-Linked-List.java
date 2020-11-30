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
class Solution {            // �ҵĽⷨ������������޸�һ���
    public Node prev;
    public Node head = new Node();      // ����һ��dummy�ڵ�
    public void dfs(Node root){
        if(root == null) return;            // �ݹ���ֹ����
        Node left = root.left;              // ����һ������ָ��Ľڵ�
        Node right = root.right;

        dfs(left);
        
        prev.right = root;
        root.left = prev;
        root.right = head;      // ��ǰ��root�����һ���ڵ㣬Ҫȥָ�����������ͷ�ڵ�
        head.left = root;       // ��ͷ���Ҫȥָ�������β�ڵ㣨��Ҫ��Ϊ�˱��֣����һ���ڵ��ܹ�ֱ�ӱ��ҵ���
        prev = root;

        dfs(right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;       // �����Ϊ�գ�ֱ�ӷ���null
        prev = head;
        dfs(root);              // �ݹ����
        head.right.left = head.left;        // ������ʵͷ�ڵ��prevָ���޸�Ϊ����β������ͷ��prevָ����head������Ҫָ��β�ڵ㣬����head��right��
        head.left.right = head.right;       // ����β�ڵ��nextָ���޸�Ϊ������ʵͷ������β��nextָ����head������Ҫָ���һ����ʵԪ�أ�����head��next��
        return head.right;
    }
}

class Solution {            // �Ż��汾
    public Node prev, head;
    public void dfs(Node root){
        if(root == null) return;
        dfs(root.left);
        if(prev != null) {         // prev != null����ʾ�ǵ�һ���ڵ㣬��ô����ֵ��ֵ����
            prev.right = root;
            root.left = prev;
        }
        else head = root;       // prev == null����ʾ�ǵ�һ���ڵ㣬��ô����������Ԫ�أ����д��
        prev = root;
        dfs(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;   
        dfs(root);
        head.left = prev;           // ����ʱ��dfsִ����ɣ���ôprev���ǵ�ǰ��β�ڵ�
        prev.right = head;          // head��������ͷ������������һ�¼���
        return head;
    }
}