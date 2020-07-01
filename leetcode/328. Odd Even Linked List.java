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
class Solution {		// �ҵĽⷨ
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;  // �����������
        ListNode odd = new ListNode(0); // ������㣬����ָʾ��ǰ��odd���
        ListNode even = new ListNode(0);    // ż����㣬����ָʾ��ǰ��even���
        ListNode current = head, flag = even;  // ��ǰ��㣬ż������ͷ
        int num = 1;        // �ж���ż
        while(current != null){     // ��������
            if(num % 2 == 0){           // �����ż������ô�ͼ��뵽even��
                even.next = current;
                even = even.next;
            }
            else{
                odd.next = current;
                odd = odd.next;
            }
            ListNode n = current.next;  // ������next�������ֹż����β��������һ��ѭ��
            current.next = null;
            current = n;
            num++;
        }
        odd.next = flag.next;   // �ϲ���������
        return head;
    }
}

class smarterSolution {		// �ٷ��ⷨ����������
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;   // �����������
        ListNode odd = head, even = head.next, evenHead = even; // 3��ָ��
        while(even != null && even.next != null){   // even�����Ϊ�жϱ��
            odd.next = even.next;   // odd�ȸ���
            odd = odd.next;
            even.next = odd.next; 
            even = even.next;
        }
        odd.next = evenHead;    // �ϲ�
        return head;    
    }
}