public class Solution {

    /**
     * 寻找旋转排序数组中的变化点
     * 
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。 (例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]).
     * 请找出该数组中的变化点。 你可以假设数组中不存在重复元素。
     * 
     * 示例1： 输入：[3,4,5,1,2] 输出：3 示例2： 输入：[4,5,6,7,0,1,2] 输出：4
     */

    public int findChangePoint(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] >= nums[left] && nums[mid] < nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}