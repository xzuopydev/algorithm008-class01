import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    /**
     * 面试题06 从尾到头打印链表
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

    // 先将链表反转，再存入数组中
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    // 利用stack的特性 后进先出
    // 将链表存入stack
    // 从stack中弹出元素放在数组中
    public int[] reversePrintS(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        int[] res = new int[stack.size()];

//        for (int i = 0; i < stack.size(); i++) {
//            res[i] = stack.pop().val;
//        }

        /**
         * 出错： 输入：[1,3,2] 输出：[2,3,0]
         */
        // i = 0 statck[2 3 1] -> pop -> statck[3 1] --> result[2]
        // i = 1 statck[3 1] -> pop -> stack[1] --> reuslt[2,3]
        // i = 2 stack[1] 不满足条件 退出 for

        // 修改为：
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }

        return res;
    }
}