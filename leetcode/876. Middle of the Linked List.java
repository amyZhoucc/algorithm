/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mySolution {			// 我的解法——遍历求长度，再从头寻找到中间节点
    public ListNode middleNode(ListNode head) {
        int num = 0;    // 计数
        ListNode curr = head;   // 当前位置的指针
        while(curr != null){    // 遍历一次，求链表长度
            curr = curr.next;
            num++;
        }
        num = num / 2;
        for(int i = 0; i < num; i++){
            head = head.next;
        }
        return head;
    }
}

class smarterSolution {			// 快慢指针解法：遍历一次
    public ListNode middleNode(ListNode head) {
        ListNode first = head, second = head;	// 设置两个指针，一快一慢
        int num = 1;			// 计数
        while(first != null){		// 这边还有更优的解法——在笔记中有写
            first = first.next;
            if(num % 2 == 0){
                second = second.next;
            }
            num++;
        }
        return second;
    }
}
