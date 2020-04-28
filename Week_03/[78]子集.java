import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 78 子集 给定一组不含重复元素的整数数组 nums, 返回该数组所有可能的子集 (幂集)
     * 
     * 说明：解集不能包含重复的子集
     * 
     * 示例： 输入： nums = [1, 2, 3] 输出： [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2],
     * [] ]
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        _generatesubsets(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }

    private void _generatesubsets(List<List<Integer>> res, ArrayList<Integer> list, int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        _generatesubsets(res, list, index + 1, nums);

        list.add(nums[index]);
        _generatesubsets(res, list, index + 1, nums);

        list.remove(list.size() - 1);
    }
}