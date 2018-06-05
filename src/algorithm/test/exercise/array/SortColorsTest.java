package algorithm.test.exercise.array;
/**
 * 红白蓝排序
 *
 * @author  j_cong
 * @date    2018/05/19
 * @version V1.0
 */
public class SortColorsTest {

    public static void main(String[] args) {
        SortColorsTest test = new SortColorsTest();
        int[] arr = {1,2,0,2,1,0};
        test.sortColors(arr);
    }

    public void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return ;
        }
        int i = 0;
        int k = A.length - 1;
        int zeroNum = -1;

        while (i <= k) {
            if (A[i] == 0) {
                swap(A, i++, ++zeroNum);
            } else if (A[i] == 2) {
                swap(A, i, k--);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
