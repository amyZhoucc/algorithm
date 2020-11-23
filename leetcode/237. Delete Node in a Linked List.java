/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {            // 我的解法
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        while(node.next != null){       // 遍历到最后，将最后一个节点返回
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}

class Solution {                // 脑筋急转弯式解法
    public void deleteNode(ListNode node) {
        node.val = node.next.val;       // 将后面一个值移到当前节点
        node.next = node.next.next;     // 然后删除next节点
    }
}