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
        recursive(head);            // 首先先去进行递归操作
        int[] res = new int[temp.size()];
        int i = 0;
        while(!temp.isEmpty()){
            res[i] = temp.poll();
            i++;
        }
        return res;
    }
    public void recursive(ListNode head){
        if(head == null) return;        // 如果遍历到链表尾了，就直接返回
        recursive(head.next);           // 非链表尾就继续去调用
        temp.offer(head.val);                 // 到这一步，说明已经开始回溯了，那么就加入队列中
    }
}