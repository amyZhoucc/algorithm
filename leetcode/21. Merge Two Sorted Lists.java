package leetcode_algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {			// �ҵĽⷨ��������
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);   // �½�һ��ͷ���
        ListNode p = l1, q = l2, head = dummy;          // ָ��ָ������������ͷ��㣬�ͽ��ͷ���
        while(p != null && q != null){  // ǰ���������������Ϊ�գ�һ��Ϊ�գ��Ͳ����жϣ�ֱ�����ӣ�
            if(p.val <= q.val){
                head.next = p;
                p = p.next;
            }
            else{
                head.next = q;
                q = q.next;
            }
            head = head.next;
        }
        // ���˲�����һ�������Ѿ�Ϊ�գ���ôʣ���Ǹ���Ϊ�յ�����ȫ���ƶ�����
        if(p != null) head.next = p;    
        if(q != null) head.next = q;
        return dummy.next;
    }
}

class smarterSolution {		// �ݹ鷽��
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}