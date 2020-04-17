/**
 * 删除排序数组中的重复项
 *
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素
 * 只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在
 * 使用O(1)额外空间的条件下完成。
 *
 * 示例1：
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度2，并且原数组nums的前两个元素被修改为1,2.
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */

class Solution {
    public int removeDuplicates(int[] nums){
        if (nums==null || nums.length==0) {
            return 0;
        }

        int i = 1;
        int j = 0;

        for (; i<nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j+1;
    }
}