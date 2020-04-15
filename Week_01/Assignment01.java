package week01;

import java.util.Arrays;

/**
 * 30688 on 2020/4/15
 */
public class Assignment01 {

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
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k){

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

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     *
     */

    public static void moveZeroes(int[] nums){
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j++;
            }
        }
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     *
     */

    public static int[] twoSum(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[2];
        int[] tmpArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmpArr);
        int left = 0;
        int right = tmpArr.length - 1;
        int a = 0;
        int b = 0;

        while (left < right) {
            int tmp = tmpArr[left] + tmpArr[right];
            if(tmp < target) {
                left++;
            }else if (tmp > target) {
                right--;
            }else {
                a = tmpArr[left];
                b = tmpArr[right];
                break;
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == a) {
                result[0] = i;
                break;
            }
        }

        if (a != b) {
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == b) {
                    result[1] = i;
                    break;
                }
            }
        }else {
            for (int i=0; i<nums.length; i++) {
                if (nums[i] == b && nums[i] != a) {
                    result[1] = i;
                    break;
                }
            }
        }

        return  result;
    }
}
