package algorithm.test.exercise.array;
/**
 * 判断机器人能够运动范围，剑指offer P92
 *
 * @author  j_cong
 * @date    2018/05/01
 * @version V1.0
 */
public class MovingCountTest {

    public int movingCount(int threshold, int rows, int cols) {

        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];

        int res = coreSolution(threshold, rows, cols, 0, 0, visited);

        return res;

    }

    /**
     * 回溯，上下左右移动
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    public int coreSolution(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;

            count = 1 + coreSolution(threshold, rows, cols, row - 1, col, visited)
                    + coreSolution(threshold, rows, cols, row + 1, col, visited)
                    + coreSolution(threshold, rows, cols, row , col - 1, visited)
                    + coreSolution(threshold, rows, cols, row , col + 1, visited);
        }
        return count;
    }

    /**
     * 判断机器人能否进入坐标为(row, col)的方格
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

        if (row >= 0 && row < rows && col >= 0 && col < cols
            && getDigitSum(row) + getDigitSum(col) <= threshold && visited[row * cols + col]) {

            return true;
        }

        return false;
    }

    /**
     * 得到num的数位之和
     *
     * @param num
     * @return
     */
    public int getDigitSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
