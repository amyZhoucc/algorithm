package leetcode_algoritm;


// Definition for singly-linked list.
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addValue =  new ListNode(0);       // 新建一个节点，代表结果的头结点
        ListNode p_cur = l1, q_cur = l2, current = addValue;   // 分别指向加数、结果的当前节点
        int flag = 0; // 是否进位标志位，初始化为0

        while ( p_cur != null || q_cur != null){        // 循环条件：全为空
            int p = (p_cur != null) ? p_cur.val: 0;     // 如果为空，就补足0
            int q = (q_cur != null) ? q_cur.val: 0;

            int temp = p + q + flag;    // 带上标志位的加法
            // 新建一个节点，值为取余后的，并且为当前节点的下一个
            current.next = new ListNode(temp % 10); 

            flag = temp / 10;   // 更新当前的进位标志位

            current = current.next;     // 更新指向下一个节点
            if(p_cur != null) p_cur = p_cur.next;   // 同上
            if(q_cur != null) q_cur = q_cur.next;   // 同上
        }
        if (flag == 1){
            current.next = new ListNode(flag);
        }
        return addValue.next;
    }
}