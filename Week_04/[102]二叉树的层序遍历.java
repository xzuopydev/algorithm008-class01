import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * 102 二叉树的层序遍历
     * 
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 (即逐层地，从左到右访问所有节点)。
     * 
     * 示例： 二叉树： [3,9,20,null,null,15,7] 返回其层次遍历结果： [ [3], [9,20], [15,7] ]
     * 
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            res.add(new ArrayList<Integer>());

            for (int i = 0; i < length; i++) {
                TreeNode node = queue.remove();
                res.get(level).add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            level++;

        }

        return res;
    }
}