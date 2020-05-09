import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * 515 在每个树行中找最大值
     * 
     * 您需要在二叉树的每一行中找到最大的值。
     * 
     * 示例: 输入：1 3 2 5 3 null 9 输出：[1,3,9]
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            max = Integer.MIN_VALUE;
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.val > max) {
                    max = node.val;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(max);
        }
        return res;
    }
}

/**
 * 在 java5 中新增加了 java.util.Queue 接口，用以支持队列的常见操作。 该接口扩展了java.util.Collection 接口。
 * 
 * Queue使用时要尽量避免Collection的add() 和 remover() 方法，而是要使用 offer() 来加入元素， 使用 poll()
 * 来获取并移出元素。它们的优点是通过返回值就可以判断成功与否。 add() 和 remove() 方法在失败的时候会抛出异常。
 * 如果要使用顶端元素而不移出顶端元素，使用 element() 或 peek() 方法。
 * 
 * 值得注意的是 LinkedList 类实现了Queue接口，因此可以把LinkedList 当成 Queue 来用。
 */