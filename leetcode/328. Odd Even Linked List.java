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
class Solution {		// 我的解法
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;  // 处理特殊情况
        ListNode odd = new ListNode(0); // 奇数结点，用来指示当前的odd结点
        ListNode even = new ListNode(0);    // 偶数结点，用来指示当前的even结点
        ListNode current = head, flag = even;  // 当前结点，偶数链表头
        int num = 1;        // 判断奇偶
        while(current != null){     // 遍历链表
            if(num % 2 == 0){           // 如果是偶数，那么就加入到even中
                even.next = current;
                even = even.next;
            }
            else{
                odd.next = current;
                odd = odd.next;
            }
            ListNode n = current.next;  // 将结点的next清除，防止偶数的尾部结点出现一个循环
            current.next = null;
            current = n;
            num++;
        }
        odd.next = flag.next;   // 合并两个链表
        return head;
    }
}

class smarterSolution {		// 官方解法——更优雅
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;   // 处理特殊情况
        ListNode odd = head, even = head.next, evenHead = even; // 3个指针
        while(even != null && even.next != null){   // even结点作为判断标记
            odd.next = even.next;   // odd先更新
            odd = odd.next;
            even.next = odd.next; 
            even = even.next;
        }
        odd.next = evenHead;    // 合并
        return head;    
    }
}