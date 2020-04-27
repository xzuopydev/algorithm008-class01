import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 77 组合 给定两个整数 n 和 k, 返回 1 ... n 中所有可能的 k 个数的组合。 示例： 输入：n = 4, k= 2 输出： [
     * [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
     */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        _generate(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    private void _generate(List<List<Integer>> combs, ArrayList<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            _generate(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }

        /**
         * 
         * for (int i = 0; i <= n; i++) { comb.add(i); _generate(combs, comb, i + 1, n,
         * k -1 ); comb.remove(comb.size() - 1); }
         * 
         * 
         * [[0,0],[0,1],[0,2],[0,3],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0],[2,1],[2,2],[2,3],[2,4],[3,0],[3,1],[3,2],[3,3],[3,4],[4,0],[4,1],[4,2],[4,3],[4,4]]
         * 
         */

        /**
         * for (int i = start; i <= n; i++) { comb.add(i); _generate(combs, comb, i + 1,
         * n, k -1 ); //comb.remove(comb.size() - 1); }
         * 
         * [[1,2],[1,2,3],[1,2,3,4],[1,2,3,4,2,3],[1,2,3,4,2,3,4],[1,2,3,4,2,3,4,3,4]]
         * 
         * 
         */

        /**
         * 
         * for (int i = start; i <= n; i++) { comb.add(i); _generate(combs, comb, i, n,
         * k -1 ); //[[1,1],[1,2],[1,3],[1,4],[2,2],[2,3],[2,4],[3,3],[3,4],[4,4]]
         * comb.remove(comb.size() - 1); }
         */
    }

}