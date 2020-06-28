package leetcode_algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mySolution {				// �Լ��Ľⷨ
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ���ԣ��ȱ���һ�μ���Ԫ�ظ�����Ȼ�����Ҫɾ���ľ���λ��
        // Ȼ���ٱ���һ�Σ���λ��ָ��λ�ã�ɾ��
        ListNode current = head;    // ָ��ǰ�ڵ�
        int num = 0;        // ��¼����ĳ���

        while(current != null){     // ����������������
            num++;
            current = current.next;
        }
        int loc = num - n;      // ��λҪɾ���Ľڵ������λ�ã�ע������ǰһ���ڵ��λ��������1��ʼ��
        current = head;     // ���»ص���ͷ
        num = 0;            // ����Ҳ�ص���ͷ

        if(loc == 0){               // �ж�������������Ҫɾ��ͷ�ڵ㣬��ô��ֱ��ָ����һ���ڵ�
            current = current.next; // ֻ��һ���ڵ��ɾ����Ҳ��������
            return current;
        }
        while(num != loc - 1){      // �ҵ���λ�ڵ�
            num++;
            current = current.next;
        }
        current.next = (current.next).next; // ���ýڵ�ɾ����current.next����ָ��ɾ���Ľڵ�
        return head;
    }
}

class Solution {				// �ٷ��ṩ��ԭʼ�ⷨ
	/* ���������dummy��ʹ�ã��ܹ�ͳһ�������н�㣨����ͷ����ɾ���� */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);     // �ڱ��ڵ㣬��������������Ĵ���ɾ��ͷ�ڵ�ȣ�
        dummy.next = head;      // �ڱ��ڵ��nextָ��head�����������㷨��ѧ��ͷ��㣬ָ�������ͷ��ʵ�����ǿյģ�

        ListNode current =  head;
        int num = 0;    // �����ڵ�
        while(current != null){     // ������������
            num++;
            current = current.next;
        }
        num -= n;   // ��λ��Ҫɾ���Ľ���ǰһ��
        current = dummy;		// ʹ���ڱ���㣡����
        while(num > 0){         // ��λ
            num--;
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}

class smarterSolution {				//�������Ľⷨ��ֻ��Ҫ����һ�μ���
	/* �����ʹ��˫ָ��+dummy��㣬��һ��ָ���ȿ�ʼ�ߣ��ڶ���ָ����n��֮�����ߣ���ô��һ��ָ��������ʱ���ڶ���ָ��(-n-1)��λ�þ���ɾ������ǰһ�� */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);     // �ڱ��ڵ㣬��������������Ĵ���ɾ��ͷ�ڵ�ȣ�
        dummy.next = head;      // �ڱ��ڵ��nextָ��head

        ListNode current =  dummy;   // ��ǰ���
        ListNode second = dummy;     // ���n�ĵڶ������

        for(int i = 0; i <= n; i++){
            current = current.next;
        }
        while(current != null){
            current = current.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}