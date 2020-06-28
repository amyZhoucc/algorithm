package leetcode_algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {			// 我的解法——迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);   // 新建一个头结点
        ListNode p = l1, q = l2, head = dummy;          // 指针指向两个参数的头结点，和结果头结点
        while(p != null && q != null){  // 前提是两个链表均不为空（一个为空，就不再判断，直接链接）
            if(p.val <= q.val){
                head.next = p;
                p = p.next;
            }
            else{
                head.next = q;
                q = q.next;
            }
            head = head.next;
        }
        // 到此步，有一个链表已经为空，那么剩下那个不为空的链表全部移动即可
        if(p != null) head.next = p;    
        if(q != null) head.next = q;
        return dummy.next;
    }
}

class smarterSolution {		// 递归方法
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}