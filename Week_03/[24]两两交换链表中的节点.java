
public class Solution {

    /***
     * 24 两两交换链表中的节点
     * 
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
     * 
     * 示例： 给定 1->2->3->4, 你应该返回 2->1->4->3
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        /**
         * 1 terminator 2 process current logic 3 drill down 4 revert
         */

        // 终止条件：当前没有节点或者只有一个节点，就不需要交换了
        if (head == null || head.next == null) {
            return head;
        }

        // 先交换第一个节点(fstNode)和第二个节点(sndNode) ，即 head 和 head.next
        ListNode fstNode = head;
        ListNode sndNode = head.next;

        // 第一个节点(fstNode)指向(next)后面交换完成的子链表 品 细品 仔细品
        fstNode.next = swapPairs(sndNode.next); // drill down

        // 第二个节点(sndNode)指向(next)第一个节点
        sndNode.next = fstNode;

        // 返回交换完成的子链表 ，第二个节点(sndNode)是头节点
        return sndNode;
    }
}