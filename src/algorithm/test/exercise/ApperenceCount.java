package algorithm.test.exercise;
/**
 * 算法1.1.15
 * 统计数组中某个值出现的次数
 *
 * @author  j_cong
 * @date    2018/03/06
 * @version V1.0
 */
public class ApperenceCount {

    public static int[] histogram(int[] arr, int m) {

        int[] result = new int[m];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i] < m) {
                result[arr[i]]++;
            }
        }

        return  result;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 3, 1, 7, 5, 3, 2, 2, 2};
        int[] result = histogram(arr, 8);

        for (int var : result) {
            System.out.printf("%3d", var);
        }
    }
}
