package algorithm.test.exercise.sort;

import algorithm.test.order.shellsort.ShellSort;

/**
 * 希尔排序
 *
 * @author  j_cong
 * @date    2018/03/26
 * @version V1.0
 */
public class ShellSortTest {

    public static void main(String[] args) {

        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};

        shellSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void shellSort(int[] arr) {

        int start = 0;
        int end = arr.length;

        for (int gap = end / 2; gap > 0; gap /= 2) {
            groupSort(arr, start, end, gap);
        }
    }

    public static void groupSort(int[] arr, int start, int end, int gap) {

        for (int i = start + gap; i < end; i += gap) {
            int wait = arr[i];
            int j = 0;
            for (j = i - gap; j >= 0 && arr[j] > wait; j -= gap) {
                arr[j + gap] = arr[j];
            }

            arr[j + gap] = wait;
        }
    }
}
