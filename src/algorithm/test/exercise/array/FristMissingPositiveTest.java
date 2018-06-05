package algorithm.test.exercise.array;
/**
 * 数组中第一个缺失的正数
 *
 * @author  j_cong
 * @date    2018/05/29
 * @version V1.0
 */
public class FristMissingPositiveTest {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        int res = firstMissingPositive(arr);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }
        for (int j = 0; j < A.length; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        return A.length + 1;
    }
}
