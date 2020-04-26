import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 22 括号生成
     * 
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 
     * 示例： 输入： n = 3 输出： [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     * 
     */
    public List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return res;
    }

    private void _generate(int left, int right, int n, String string) {
        if (left == n && right == n) {
            res.add(string);
        }

        if (left < n) {
            _generate(left + 1, right, n, string + "(");
        }

        if (left > right) {
            _generate(left, right + 1, n, string + ")");
        }
    }
}