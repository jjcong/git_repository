package algorithm.test.exercise.array;
/**
 * 岛屿的最大面积
 * 
 * @author  j_cong
 * @date    2018/09/04
 * @version V1.0
 */
public class MaxIslandArea {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }

            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = -1;
        int area = 1;

        return  1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
}
