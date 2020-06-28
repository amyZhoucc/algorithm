package leetcode_algorithm;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mySolution {				// 自己的解法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 策略：先遍历一次计算元素个数，然后求得要删除的具体位置
        // 然后再遍历一次，定位到指定位置，删除
        ListNode current = head;    // 指向当前节点
        int num = 0;        // 记录链表的长度

        while(current != null){     // 遍历，计算链表长度
            num++;
            current = current.next;
        }
        int loc = num - n;      // 定位要删除的节点的正序位置，注意是其前一个节点的位置数（从1开始）
        current = head;     // 重新回到开头
        num = 0;            // 计数也回到开头

        if(loc == 0){               // 判断特殊情况：如果要删除头节点，那么就直接指向下一个节点
            current = current.next; // 只有一个节点的删除，也包括在内
            return current;
        }
        while(num != loc - 1){      // 找到定位节点
            num++;
            current = current.next;
        }
        current.next = (current.next).next; // 将该节点删除：current.next就是指定删除的节点
        return head;
    }
}

class Solution {				// 官方提供的原始解法
	/* 巧妙点在于dummy的使用，能够统一处理所有结点（包括头结点的删除） */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);     // 哨兵节点，用来简化特殊情况的处理（删除头节点等）
        dummy.next = head;      // 哨兵节点的next指向head——类似于算法中学的头结点，指向链表的头（实际上是空的）

        ListNode current =  head;
        int num = 0;    // 计数节点
        while(current != null){     // 遍历求链表长度
            num++;
            current = current.next;
        }
        num -= n;   // 定位到要删除的结点的前一个
        current = dummy;		// 使用哨兵结点！！！
        while(num > 0){         // 定位
            num--;
            current = current.next;
        }
        current.next = current.next.next;
        return dummy.next;
    }
}

class smarterSolution {				//更聪明的解法，只需要遍历一次即可
	/* 巧妙地使用双指针+dummy结点，第一个指针先开始走，第二个指针间隔n个之后再走，那么第一个指针遍历完成时，第二个指针(-n-1)的位置就是删除结点的前一个 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);     // 哨兵节点，用来简化特殊情况的处理（删除头节点等）
        dummy.next = head;      // 哨兵节点的next指向head

        ListNode current =  dummy;   // 当前结点
        ListNode second = dummy;     // 间隔n的第二个结点

        for(int i = 0; i <= n; i++){
            current = current.next;
        }
        while(current != null){
            current = current.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}