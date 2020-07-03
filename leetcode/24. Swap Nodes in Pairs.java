/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {		// �����ҵĽⷨ������
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);   // �ڱ����
        dummy.next = head;                  // nextָ��ͷ���
        ListNode ret = dummy, second;               // ret����dummy�����������ָʾǰһ�����
        while(head != null && head.next != null){ // ѭ�����������߾���Ϊnull�����н��������壩
            second = head.next;        // ������ָ���ɾ����������
            head.next = second.next;
            second.next = head;
            head = head.next;       // headָ����һ��Ҫ�����Ľ��
            ret.next = second;      // ǰһ�����ָ�򻻺ú�ĵ�һ�����
            ret = ret.next.next;    // ���Ҹ��µ����ú�ĵڶ������
        }  
        return dummy.next;
    }
}

class recursiveSolution {			// �����ݹ�ⷨ
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;  // ��ֹ����
        
        ListNode next = head.next;      // nextָ���һ����㣨head��ָ��ǰһ����㣩
        head.next = swapPairs(next.next); // ǰһ�����ָ���һ������next���Ѿ������õĺ������head��㣩
        next.next = head;   // next��ָ�򽻻�
        return next;
    }
}