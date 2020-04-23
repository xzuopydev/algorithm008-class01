import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    /**
     * 347 前K个高频元素
     * 
     * 
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
     * 
     * 
     * 示例： 输入：nums = [1,1,1,2,2,3], k = 2 输出：[1,2]
     * 
     * 输入：nums = [1], k = 1 输出：[1]
     * 
     */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            list.add(entry.getKey());
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}