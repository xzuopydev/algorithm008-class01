
public class Solution {

    /**
     * 200 岛屿问题
     * 
     * 给你一个由 '1'(陆地) 和 '0'(水) 组成的二维网格，请你计算 网格中岛屿的数量。
     * 
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻 的陆地连接形成。
     * 
     * 此外，你可以假设该网格的四条边均被水包围。
     * 
     * 示例1： 输入： 11110 11010 11000 00000 输出:1
     * 
     * 示例2： 输入： 11000 11000 00100 00011 输出：3
     * 
     * 解释：每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     */

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}