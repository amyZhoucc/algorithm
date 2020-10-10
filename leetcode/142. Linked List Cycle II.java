/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {             // ˫ָ����
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null) return null;      // �����������β�ڵ㣬��ôһ�������ڻ�
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;     // �����ˣ��л�һ����������
        }
        fast = head;                    // �ڶ��α���
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}