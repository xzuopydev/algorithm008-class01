/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
 * 你可以假设除了整数0之外，这个整数不会以零开头
 *
 * 示例： 输入：[1,2,3] 输出：[1,2,4] 解释：输入数组表示数字 123.
 */

class Solution {
    public int[] plusOne(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 9) {
                nums[i]++;
                break;
            } else {
                nums[i] = 0;
            }
        }

        if (nums[0] == 0) {
            int[] res = new int[nums.length + 1];
            res[0] = 1;
            return res;
        }

        return nums;
    }
}