package algorithm.test.exercise.array;

import java.util.ArrayList;

/**
 * 转圈打印二维数组
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/05/29
 */
public class PrintMatrixInCircle {

    ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        PrintMatrixInCircle test = new PrintMatrixInCircle();
        int[][] matrix = {{1,2}};
        test.spiralOrder(matrix);
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;
        int tR = 0;
        int tC = 0;
        while (tR <= rows && tC <= cols) {
            res = printEdge(matrix, tR++, tC++, rows--, cols--);
        }

        return res;
    }

    public ArrayList<Integer> printEdge(int[][] matrix, int tR, int tC, int rows, int cols) {
        //只有一行
        if (tR == rows) {
            for (int i = tC; i <= cols; i++) {
                res.add(matrix[tR][i]);
            }
            //只有一列
        } else if (tC == cols) {
            for (int j = tR; j <= rows; j++) {
                res.add(matrix[j][tC]);
            }
        } else {
            int curRow = tR;
            int curCol = tC;
            //左→右
            while (curCol != cols) {
                res.add(matrix[tR][curCol]);
                curCol++;
            }
            //上→下
            while (curRow != rows) {
                res.add(matrix[curRow][cols]);
                curRow++;
            }
            //右→左
            while (curCol != tC) {
                res.add(matrix[rows][curCol]);
                curCol--;
            }
            //下→上
            while (curRow != tR) {
                res.add(matrix[curRow][tC]);
                curRow--;
            }
        }
        return res;
    }
}
