/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {                // 递归解法
    private LinkedList<Integer>store = new LinkedList<Integer>();       // 注意类似于全局变量
    private void recursive(ListNode head){          // 递归函数
        if(head == null) return;            // 递归终止条件
        recursive(head.next);           // 一直深入找到链表尾结点
        store.offer(head.val);      // 到这一步说明递已经结束了，现在开始归——就是将当前节点插入到队列中
    }
    public int[] reversePrint(ListNode head) {
        recursive(head);        // 首先调用递归函数，将节点加入到队列中
        int[] res = new int[store.size()];
        int i = 0;
        while(!store.isEmpty()){            // 将队列中的节点依次出队，转换成数组
            res[i++] = store.poll();
        }
        return res;
    }
}

class Solution {                // 调用栈求解
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> store = new LinkedList<Integer>();      // 这个就是栈
        while(head != null){
            store.addLast(head.val);        // 后面为栈顶
            head = head.next;
        }
        int[] res = new int[store.size()];
        int i = 0;
        while(!store.isEmpty()){
            res[i++] = store.pollLast();        // 取从栈顶开始取（从下标大的开始取出）
        }
        return res;
    }
}