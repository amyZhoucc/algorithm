package leetcode_algoritm;


// Definition for singly-linked list.
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addValue =  new ListNode(0);       // �½�һ���ڵ㣬��������ͷ���
        ListNode p_cur = l1, q_cur = l2, current = addValue;   // �ֱ�ָ�����������ĵ�ǰ�ڵ�
        int flag = 0; // �Ƿ��λ��־λ����ʼ��Ϊ0

        while ( p_cur != null || q_cur != null){        // ѭ��������ȫΪ��
            int p = (p_cur != null) ? p_cur.val: 0;     // ���Ϊ�գ��Ͳ���0
            int q = (q_cur != null) ? q_cur.val: 0;

            int temp = p + q + flag;    // ���ϱ�־λ�ļӷ�
            // �½�һ���ڵ㣬ֵΪȡ���ģ�����Ϊ��ǰ�ڵ����һ��
            current.next = new ListNode(temp % 10); 

            flag = temp / 10;   // ���µ�ǰ�Ľ�λ��־λ

            current = current.next;     // ����ָ����һ���ڵ�
            if(p_cur != null) p_cur = p_cur.next;   // ͬ��
            if(q_cur != null) q_cur = q_cur.next;   // ͬ��
        }
        if (flag == 1){
            current.next = new ListNode(flag);
        }
        return addValue.next;
    }
}