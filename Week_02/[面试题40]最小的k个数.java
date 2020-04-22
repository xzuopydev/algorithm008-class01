import java.util.PriorityQueue;

public class Solution {

    /**
     * 最小的k个数
     * 
     * 输入整数数组arr， 找出其中最小的 k 个数。 例如，输入4,5,1,6,2,7,3,8 这8个数字， 则最小的4个数字是1,2,3,4
     * 
     * 示例： 输入：arr = [3,2,1] k = 2 输出：[1,2] 或者 [2,1]
     */

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }
}