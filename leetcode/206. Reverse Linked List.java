/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {			// 我的解法——迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev =  null, curr = head, succ;   // 设置3个结点，分别表示前驱、当前、后继结点
        while(curr != null){
            succ = curr.next;   // succ指向curr的下一个（为了保存下一个要修改的结点）
            curr.next = prev;   // 该换指向的结点
            prev = curr;        //
            curr = succ;
        }
        return prev;
    }
}

class recursiveSolution {		// 另一种解法——递归
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;	// 主要就是遍历之后，可以指向链表尾结点；head == null，主要是为了判断临界条件：链表为空
        ListNode curr = reverseList(head.next);		// curr就是指向链表尾
        head.next.next = head;	// head为当前结点，head.next:原先的后继结点，succ.next指向当前结点，那么就逆序了
        head.next = null;	// 当前结点的next一定要为null，当递归到最后是，给链表尾（原链表头）做截断，防止出现环
        return curr;
    }
}