/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mySolution {			// �ҵĽⷨ���������󳤶ȣ��ٴ�ͷѰ�ҵ��м�ڵ�
    public ListNode middleNode(ListNode head) {
        int num = 0;    // ����
        ListNode curr = head;   // ��ǰλ�õ�ָ��
        while(curr != null){    // ����һ�Σ���������
            curr = curr.next;
            num++;
        }
        num = num / 2;
        for(int i = 0; i < num; i++){
            head = head.next;
        }
        return head;
    }
}

class smarterSolution {			// ����ָ��ⷨ������һ��
    public ListNode middleNode(ListNode head) {
        ListNode first = head, second = head;	// ��������ָ�룬һ��һ��
        int num = 1;			// ����
        while(first != null){		// ��߻��и��ŵĽⷨ�����ڱʼ�����д
            first = first.next;
            if(num % 2 == 0){
                second = second.next;
            }
            num++;
        }
        return second;
    }
}
