
public class Solution {

    /**
     * 236 二叉树的最近公共祖先
     * 
     * 给定一个二叉树，找到该树中两个指定节点的最近公共祖先。
     * 
     * 百度百科中最近公共祖先的定义为："对于有根树 T 的两个节点 p、q, 最近 公共祖先表示为一个节点 x, 满足 x 是 p、q的祖先且 x
     * 的深度尽肯能大 (一个节点也可以是它自己的祖先)。"
     * 
     * 例如：给定如下二叉树： root = [3,5,1,6,2,0,8,null,null,7,4]
     * 
     * 示例1： 输入：root = [3,5,1,6,2,0,8,null,null,7,4] p = 5, q = 1 输出：3 解释：节点 5 和 节点 1
     * 的最近公共祖先是 节点 3.
     * 
     * 示例2： 输入：root = [3,5,1,6,2,0,8,null,null,7,4] p = 5, q = 1 输出：5 解释：节点 5 和 节点
     * 4的最近公共祖先是节点5. 因为根据定义 最近公共祖先节点可以为节点本身。
     * 
     * 说明：
     * 
     * 所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉树中。
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        recurseTree(root, p, q);
        return ans;
    }

    public boolean recurseTree(TreeNode curNode, TreeNode p, TreeNode q) {
        if (curNode == null) {
            return false;
        }

        int left = recurseTree(curNode.left, p, q) ? 1 : 0;
        int right = recurseTree(curNode.right, p, q) ? 1 : 0;

        int mid = (curNode == p || curNode == q) ? 1 : 0;

        if (left + right + mid >= 2) { // 一定是大于等于2
            ans = curNode;
        }

        return left + right + mid > 0;
    }

}