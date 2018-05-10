package algorithm.test.exercise.array;

/**
 * 判断矩阵中是否有某条路径
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/05/01
 */
public class HasPathTest {


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        boolean[] flag = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (coreSolution(matrix, rows, cols, i, j, str, 0, flag)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean coreSolution(char[] matrix, int rows, int cols, int i, int j, char[] str,
                                int k, boolean[] flag) {
        int index = i * cols + j;

        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        flag[index] = true;

        if (coreSolution(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || coreSolution(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || coreSolution(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || coreSolution(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }

        flag[index] = false;

        return false;

    }

}
