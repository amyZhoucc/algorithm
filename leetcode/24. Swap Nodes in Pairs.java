/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {		// ——我的解法：迭代
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);   // 哨兵结点
        dummy.next = head;                  // next指向头结点
        ListNode ret = dummy, second;               // ret保存dummy，用来后面的指示前一个结点
        while(head != null && head.next != null){ // 循环条件（两者均不为null，才有交换的意义）
            second = head.next;        // 交换（指针的删除和重连）
            head.next = second.next;
            second.next = head;
            head = head.next;       // head指向下一个要交换的结点
            ret.next = second;      // 前一个结点指向换好后的第一个结点
            ret = ret.next.next;    // 并且更新到换好后的第二个结点
        }  
        return dummy.next;
    }
}

class recursiveSolution {			// ——递归解法
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;  // 终止条件
        
        ListNode next = head.next;      // next指向后一个结点（head是指向前一个结点）
        head.next = swapPairs(next.next); // 前一个结点指向后一个结点的next（已经交换好的后链表的head结点）
        next.next = head;   // next的指向交换
        return next;
    }
}