package algorithm.test.exercise.sort;
/**
 * 归并排序
 *
 * @author  j_cong
 * @date    2018/03/26
 * @version V1.0
 */
public class MergeSortTest {

    public static void main(String[] args) {

        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);


    }

    public static void merge(int[] arr, int start, int mid, int end) {

        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {

            tmp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];

        }

        if (i <= mid) {
           tmp[k++] = arr[i++];
        }

        if (j <= end) {
            tmp[k++] = arr[j++];
        }
/*        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= end) {
            tmp[k++] = arr[j++];
        }*/


        //这里arr的下标为什么要加start？？？
        for (int m = 0; m < tmp.length; m++) {
            arr[start + m] = tmp[m];
        }
        tmp = null;
    }
}
