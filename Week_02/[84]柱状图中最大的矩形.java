import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {

    /**
     * 84 柱状图中最大的矩形
     * 
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。 每个柱子彼此相邻，且宽度为1. 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * 
     * 示例： 输入：[2,1,5,6,2,3] 输出：10
     */

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return max;
    }
}