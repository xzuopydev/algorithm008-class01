import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * 239 滑动窗口最大值
     * 
     * 给定一个数组 nums, 有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。 你只可以看到在滑动窗口内的 k
     * 个数字。滑动窗口每次只向右移动一位。
     * 
     * 返回滑动窗口中的最大值。
     * 
     * 进阶： 你能在线性时间复杂度内解决此问题吗？
     * 
     * 
     * 示例：nums = [1,3,-1,-3,5,3,6,7] 和 k = 3 输入：[3,3,5,5,6,7] 输出：
     * 
     * 解释：
     * 
     * 滑动窗口的位置 最大值 ------------------- ------ [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5 3
     * 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
     * -1 -3 5 [3 6 7] 7
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }

            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);

            if (i >= k - 1) {
                res[index++] = nums[q.peek()];
            }
        }

        return res;
    }
}