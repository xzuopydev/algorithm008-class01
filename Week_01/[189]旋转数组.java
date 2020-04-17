/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 *
 */

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }

        k %= nums.length;

        reverse(nums, 0, nums.length-1); //1,2,3,4,5,6,7 => 7,6,5,4,3,2,1
        reverse(nums, 0, k-1);           //7,6,5,4,3,2,1 => 5,6,7,4,3,2,1
        reverse(nums, k, nums.length-1);      //5,6,7,4,3,2,1 => 5,6,7,1,2,3,4
    }



    public static void reverse(int[] nums, int start, int end){
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}