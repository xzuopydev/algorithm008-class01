import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * 从尾到头打印链表
     * 
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值 (用数组返回)。
     * 
     * 示例： 输入：head = [1,3,2] 输出：[2,3,1]
     * 
     * 限制 0 <= 链表长度 <= 10000
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode res = reverseList(head);
        List<Integer> list = new ArrayList<>();

        while (res != null) {
            list.add(res.val);
            res = res.next;
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public int[] reversePrintS(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.pop().val;
        }

        return res;
    }
}