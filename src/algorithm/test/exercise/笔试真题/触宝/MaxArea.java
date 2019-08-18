package algorithm.test.exercise.笔试真题.触宝;

import java.util.Scanner;
/**
 * DFS
 * 
 * @author  j_cong
 * @date    2018/09/04
 * @version V1.0
 */
public class MaxArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int width = in.nextInt();
        int level = in.nextInt();
        int[][] matrix = new int[h][width];

        for (int i = 0; i < h; i++) {

            for (int j = 0; j < width; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int count = 0;
        int[][] flag = new int[h][width];
        for (int j = 0; j < width; j++) {
            count += count(matrix, level, 0, j, flag);
        }
        if (h > 1) {
            for (int i = 1; i < h; i++) {
                count += count(matrix, level, i, width - 1, flag);
            }
        }
        if (h > 1 && width > 1) {
            for (int j = width - 2; j >= 0; j--) {
                count += count(matrix, level, h - 1, j, flag);
            }
        }
        if (h > 2 && width > 1) {
            for (int i = h - 2; i > 0; i--) {
                count += count(matrix, level, i, 0, flag);
            }
        }
        System.out.println(h * width - count);
    }

    private static int count(int[][] matrix, int level, int row, int col, int[][] flag) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || flag[row][col] == -1 || matrix[row][col] > level) {
            return 0;
        }
        flag[row][col] = -1;
        return 1 + count(matrix, level, row + 1, col, flag) + count(matrix, level, row - 1, col, flag)
                + count(matrix, level, row, col + 1, flag) + count(matrix, level, row, col - 1, flag);
    }

}
