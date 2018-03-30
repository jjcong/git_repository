package algorithm.test.exercise.link;

import java.util.Scanner;
/**
 * 携程笔试题，顺时针旋转矩阵90
 * 难点在于如何输入数组（Scanner）
 *
 * @author  j_cong
 * @date    2018/03/29
 * @version V1.0
 */
public class ScannerReverseMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] input = new int[n][n];


        //必须添加此语句，将nextInt（）后的enter去掉
        sc.nextLine();
        for (int j = 0; j < n; j++) {

            String line = sc.nextLine();
            String[] tmp = line.split(" ");

            for (int k = 0; k < n; k++) {
                input[j][k] = Integer.valueOf(tmp[k]);
            }
        }

        print(input);

        rotate(input);
    }

    public static void rotate(int[][] matrix) {

        if (matrix == null) {
            return;
        }

        if (matrix.length != matrix[0].length) {
            return;
        }

        int n = matrix.length;
        int limit = (n - 1) / 2;
        for (int i = 0; i <= limit; i++) {
            //列号
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }

        print(matrix);
    }


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
}
