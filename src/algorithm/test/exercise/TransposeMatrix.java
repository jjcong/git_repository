package algorithm.test.exercise;

import java.util.Stack;

/**
 * 算法1.1.13
 * 打印M*N的二维数组的转置（交换行和列）
 *
 * @author  j_cong
 * @date    2018/03/06
 * @version V1.0
 */
public class TransposeMatrix {

    public static void printTransposeMatrix(int[][] matrix) {

        //matrix[0].length为列数
        for (int i = 0; i < matrix[0].length; i++) {
            //matrix.length为行数
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%4d", matrix[j][i]);
            }
            System.out.println();
        }

    }

    /**
     * 转置输出
     *
     * @param arr
     */
    public static void rotate(int[][] arr) {

        print(arr);

        //对于非正规矩阵，转置后行与列需交换
        int row = arr.length;
        int col = arr[0].length;
        int[][] newMatrix = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                newMatrix[j][i] = arr[i][j];
//                int tmp = arr[i][j];
//                arr[i][j] = arr[j][i];
//                arr[j][i] = tmp;
            }
        }

        System.out.println("---------------");
        print(newMatrix);

        System.out.println("---------------");


        invertPrint(arr);
    }

    /**
     * 逆序输出
     *
     * @param arr
     */
    public static void invertPrint(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < col; i++) {
            for (int j = col - 1; j >= col / 2; j--) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][col - j - 1];
                arr[i][col - j - 1] = tmp;
            }
        }

        print(arr);

    }

    /**
     * 正序输出
     *
     * @param arr
     */
    public static void print(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

//        int[][] matrix = {{100, 200, 300}, {400, 500, 600}, {700, 800, 900}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};


        rotate(matrix);
//        printTransposeMatrix(matrix);
    }
}
