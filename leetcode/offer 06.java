/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public LinkedList<Integer> temp = new LinkedList<Integer>();
    public int[] reversePrint(ListNode head) {
        recursive(head);            // ������ȥ���еݹ����
        int[] res = new int[temp.size()];
        int i = 0;
        while(!temp.isEmpty()){
            res[i] = temp.poll();
            i++;
        }
        return res;
    }
    public void recursive(ListNode head){
        if(head == null) return;        // �������������β�ˣ���ֱ�ӷ���
        recursive(head.next);           // ������β�ͼ���ȥ����
        temp.offer(head.val);                 // ����һ����˵���Ѿ���ʼ�����ˣ���ô�ͼ��������
    }
}