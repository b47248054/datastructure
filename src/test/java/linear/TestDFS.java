package linear;

import org.junit.Test;

/**
 * @author liuzhongxu
 * @date 2020/4/20
 */
public class TestDFS {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 示例 1:
     *
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * 示例 2:
     *
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsIslands(i, j, grid);
                }
            }
        }
        return count;
    }

    private void dfsIslands(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || null == grid || grid.length == 0 || x > grid.length - 1 || y > grid[0].length - 1) {
            return;
        }

        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfsIslands(x + 1, y, grid);// 右
            dfsIslands(x - 1, y, grid);// 左
            dfsIslands(x, y - 1, grid);// 上
            dfsIslands(x, y + 1, grid);// 下
        }

    }

    @Test
    public void test() {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int count = numIslands(grid);
        System.out.println(count);
    }
}
