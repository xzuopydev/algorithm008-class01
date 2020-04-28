
public class Solution {

    /**
     * 50 Pow(x,n)
     * 
     * 实现 pow(x, n)， 即计算 x 的 n 次幂函数。
     * 
     * 示例1： 输入：2.00000， 10 输出：1024.00000
     * 
     * 示例2： 输入：2.10000， 3 输出：9.26100
     * 
     * 示例3： 输入：2.00000， -2 输出：0.25000
     * 
     * 说明： -100.0 < x < 100.0 n 是32位有符号整数
     */

    public double myPow(double x, int n) {
        int N = n;
        if (N < 0) {
            x = 1 / x;
            N = -n;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);

        return half % 2 == 0 ? half * half : half * half * x;
    }

}