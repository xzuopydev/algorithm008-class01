
public class Solution {

    /**
     * 21 合并两个有序链表
     * 
     * 将两个升序链表合并为一个新的升序链表并返回。 新链表是通过拼接给定的两个链表的所有节点组成的。
     * 
     * 示例： 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /**
         * 递归思想： 若两者其中一个为 null 就返回另一个 否则 val值小的链表作为头，然后它的 next 指向它的下一个节点和另一个有序链表的合并
         * 
         * 1. terminator 2. process current logic 3. drill down 4. revert
         */
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l2.next, l1);
        }

        return head;
    }
}