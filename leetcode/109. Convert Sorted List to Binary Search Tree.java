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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 查找中间节点的函数——通过快慢指针来实现一次遍历就找到中间值，范围是[)
    public ListNode findMedium(ListNode head, ListNode tail){
        ListNode first = head, second = head;
        while(first != tail && first.next != tail){     // 循环的终止条件——注意 first.next也不能为null，否则会报错
            first = first.next.next;
            second = second.next;
        }
        return second;
    }
    public TreeNode construct(ListNode head, ListNode tail){
        if(head == tail) return null;           // [)的区间范围，所以相等时，中间没有任何值，所以递归结束
        ListNode mid = findMedium(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = construct(head, mid);
        root.right = construct(mid.next, tail);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = construct(head, null);          // 本人觉得，算是本题最巧妙的地方：最大的一个递归点——tail是null，就是链表尾部的next
        return root;
    }
}