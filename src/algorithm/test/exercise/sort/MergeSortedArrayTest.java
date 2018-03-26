package algorithm.test.exercise.sort;

import java.util.ArrayList;
import java.util.List;
/**
 * 合并两个有序数组
 *
 * @author  j_cong
 * @date    2018/03/25
 * @version V1.0
 */
public class MergeSortedArrayTest {


    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 0};
        int[] brr = {2, 4};

        int[] result = mergeSortedArray(arr, brr);
         mergeSortedArray(arr, 3, brr, 2);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

        for (int i = 0; i <  n; i++) {
            int wait = B[i];
            int j = 0;
            for (j = m - 1 + i; j >= 0 && wait < A[j]; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = wait;
        }
    }


    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }

        int a = A.length;
        int b = B.length;
        List<Integer> list = new ArrayList<>();
        Integer[] result = new Integer[a + b];
        int[] result1 = new int[a + b];

        int i = 0, j = 0;


        //比较数组A和数组B相同长度的数值，添加到list中
        while (i != a  && j != b) {
            if (A[i] > B[j]) {
                list.add(B[j]);
                j++;
            } else {
                list.add(A[i]);
                i++;
            }
        }

        //加入数组A剩余部分
        if (i < a) {
            for (int k = i; k < a; k++)
                list.add(A[k]);
        }
        //加入数组B剩余部分
        if (j < b ) {
            for (int m = j; m < b; m++)
                list.add(B[m]);
        }

        //list转为array，注意转化后为Integer[]
        list.toArray(result);
        for (int n = 0; n < list.size(); n++) {
            result1[n] = result[n];
        }


        return result1;

    }
}
