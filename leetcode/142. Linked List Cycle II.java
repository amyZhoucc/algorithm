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
public class Solution {             // 双指针题
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast == null || fast.next == null) return null;      // 如果存在链表尾节点，那么一定不存在环
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;     // 相遇了（有环一定会相遇）
        }
        fast = head;                    // 第二次遍历
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}