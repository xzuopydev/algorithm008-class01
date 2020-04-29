
public class Solution {

    /**
     * 206 反转链表
     * 
     * 反转一个单链表
     * 
     * 示例： 输入：1 -> 2 -> 3 -> 4 -> 5 -> NULL 输出：5 -> 4 -> 3 -> 2 -> 1 -> NULL
     * 
     * 进阶： 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        /**
         * 1. terminator 2. process current logic 3. drill down 4. revert
         */

        /**
         * 递归的意思： 我子节点下的所有节点都已经反转好了， 现在就剩下我和我的子节点没有完成最后的反转了 所以反转一下我和我的子节点
         */
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverseList(head.next); // 反转我子节点下的所有节点

        head.next.next = head; // 反转我的子节点
        head.next = null; // 反转我
        return res;
    }
}