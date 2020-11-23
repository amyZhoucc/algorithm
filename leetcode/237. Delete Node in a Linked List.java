/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {            // �ҵĽⷨ
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node.next != null){       // ��������󣬽����һ���ڵ㷵��
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}

class Solution {                // �Խת��ʽ�ⷨ
    public void deleteNode(ListNode node) {
        node.val = node.next.val;       // ������һ��ֵ�Ƶ���ǰ�ڵ�
        node.next = node.next.next;     // Ȼ��ɾ��next�ڵ�
    }
}