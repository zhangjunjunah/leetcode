package cn.edu.aqtc.leetcode;

/**
 * 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 * @Description:
 * @ClassName: IslandPerimeter
 * @Author: zhangjj
 * @Date: 2020-10-30
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};

    }

    public int islandPerimeter(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (1 == grid[i][j]) {
                    return dfs(grid, i, j);
                }

            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int x, int y) {
        // 若坐标不合法，直接返回
        if (x < 0 || x > grid.length || y < 0 || y > grid[0].length) {
            return 0;
        }
        // 若该方格不是岛屿，直接返回
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;
        return dfs(grid, x - 1, y) + dfs(grid, x, y - 1) + dfs(grid, x + 1, y) + dfs(grid, x, y + 1);

    }
}
