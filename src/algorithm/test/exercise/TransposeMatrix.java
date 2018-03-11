package algorithm.test.exercise;

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

    public static void main(String[] args) {
        int[][] matrix = {{100, 200, 300}, {400, 500, 600}, {150, 250, 350}, {110, 210, 310}};
        printTransposeMatrix(matrix);
    }
}
