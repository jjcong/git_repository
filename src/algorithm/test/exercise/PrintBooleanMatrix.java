package algorithm.test.exercise;

/**
 * 算法1.1.11
 * 打印二维布尔数组内容，true为“*”,false为“%”，同时打印出行号和列号
 *
 * @author  j_cong
 * @date    2018/03/06
 * @version V1.0
 */
public class PrintBooleanMatrix {

    public static void printBooleanMatrix(boolean[][] matrix) {

        System.out.print(" ");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] ? " *" : " %");
            }
            System.out.println();
        }



    }

    public static void main(String[] args) {

        boolean[][] booleans = {
                {true, false, true},  {false, false, true}, {true, false, false}
        };

        printBooleanMatrix(booleans);
    }
}
