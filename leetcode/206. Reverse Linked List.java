/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {			// �ҵĽⷨ��������
    public ListNode reverseList(ListNode head) {
        ListNode prev =  null, curr = head, succ;   // ����3����㣬�ֱ��ʾǰ������ǰ����̽��
        while(curr != null){
            succ = curr.next;   // succָ��curr����һ����Ϊ�˱�����һ��Ҫ�޸ĵĽ�㣩
            curr.next = prev;   // �û�ָ��Ľ��
            prev = curr;        //
            curr = succ;
        }
        return prev;
    }
}

class recursiveSolution {		// ��һ�ֽⷨ�����ݹ�
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;	// ��Ҫ���Ǳ���֮�󣬿���ָ������β��㣻head == null����Ҫ��Ϊ���ж��ٽ�����������Ϊ��
        ListNode curr = reverseList(head.next);		// curr����ָ������β
        head.next.next = head;	// headΪ��ǰ��㣬head.next:ԭ�ȵĺ�̽�㣬succ.nextָ��ǰ��㣬��ô��������
        head.next = null;	// ��ǰ����nextһ��ҪΪnull�����ݹ鵽����ǣ�������β��ԭ����ͷ�����ضϣ���ֹ���ֻ�
        return curr;
    }
}