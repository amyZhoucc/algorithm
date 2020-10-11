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
public class Solution {
    public boolean hasCycle(ListNode head) {            // 设置快慢指针，然后就是追及问题
        ListNode fast = head, slow = head;
        while(true){
            if(fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
    }
}