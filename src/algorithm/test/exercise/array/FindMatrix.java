package algorithm.test.exercise.array;
/**
 * 在行和列都有序的二维数组中寻找某个值
 *
 * @author  j_cong
 * @date    2018/03/28
 * @version V1.0
 */
public class FindMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        int[] result = findKey(matrix, 100);

        System.out.println("关键词在第" + result[0] + "行" + result[1] +"列" );
    }

    public static int[] findKey(int[][] matrix, int key) {

        int[] result = new int[2];

        if (matrix == null) {
            return null;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                break;

            } else if (matrix[row][col] > key) {
                col--;
            } else {
                row++;
            }
        }

        result[0] = row + 1;
        result[1] = col + 1;

        return result;
    }
}
