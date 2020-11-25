/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {                // �ݹ�ⷨ
    private LinkedList<Integer>store = new LinkedList<Integer>();       // ע��������ȫ�ֱ���
    private void recursive(ListNode head){          // �ݹ麯��
        if(head == null) return;            // �ݹ���ֹ����
        recursive(head.next);           // һֱ�����ҵ�����β���
        store.offer(head.val);      // ����һ��˵�����Ѿ������ˣ����ڿ�ʼ�顪�����ǽ���ǰ�ڵ���뵽������
    }
    public int[] reversePrint(ListNode head) {
        recursive(head);        // ���ȵ��õݹ麯�������ڵ���뵽������
        int[] res = new int[store.size()];
        int i = 0;
        while(!store.isEmpty()){            // �������еĽڵ����γ��ӣ�ת��������
            res[i++] = store.poll();
        }
        return res;
    }
}

class Solution {                // ����ջ���
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> store = new LinkedList<Integer>();      // �������ջ
        while(head != null){
            store.addLast(head.val);        // ����Ϊջ��
            head = head.next;
        }
        int[] res = new int[store.size()];
        int i = 0;
        while(!store.isEmpty()){
            res[i++] = store.pollLast();        // ȡ��ջ����ʼȡ�����±��Ŀ�ʼȡ����
        }
        return res;
    }
}