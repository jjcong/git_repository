package algorithm.test.exercise.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 对角线打印二维数组
 * 思路：
 * 将整个输出以最长的斜对角线分为两部分：右上部分和左下部分。
 * 右上部分：对角线的起点在第一行，列数递减，对角线上相邻元素之间横坐标和纵坐标均相差1；
 * 左下部分：对角线的起点在第一列上，行数递减，对角线上相邻元素之间横坐标和纵坐标均相差1；
 *
 * @author  j_cong
 * @date    2018/08/25
 * @version V1.0
 */
public class PrintInDiagonal {


    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> res = print(a, a.length);

        res.stream().forEach(e -> System.out.print(e + " "));
    }


    public static List<Integer> print(int[][] matrix, int n) {
        int row;
        int col;

        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            row = 0;
            col = i;
            while (row >= 0 && row < n && col >= 0 && col < n) {
                res.add(matrix[row][col]);
                row++;
                col++;
            }
        }

        for (int j = 1; j < n; j++) {
            row = j;
            col = 0;
            while (row >= 0 && row < n && col >= 0 && col < n) {
                res.add(matrix[row][col]);
                row++;
                col++;
            }

        }
        return res;
    }


}
