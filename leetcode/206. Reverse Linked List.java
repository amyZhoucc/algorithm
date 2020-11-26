/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {                // 迭代法
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;  // 排除特殊情况
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

class recursiveSolution {		// 另一种解法——递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;	// head.next == null，主要就是遍历之后，可以指向链表尾结点；head == null，主要是为了判断临界条件：链表为空
        ListNode curr = reverseList(head.next);		// curr一直就是指向链表尾，防止递归丢失
        head.next.next = head;	// head为当前结点，head.next:原先的后继结点，succ.next指向当前结点，那么就逆序了
        head.next = null;	// 当前结点的next一定要为null，当递归到最后是，给链表尾（原链表头）做截断，防止出现环
        return curr;            // 返回链表尾（就是现在的链表头节点）
    }
}
