package algorithm.test.exercise.array;
/**
 * 数组中的逆序对
 * 
 * @author  j_cong
 * @date    2018/04/15
 * @version V1.0
 */
public class CountInverseArray {

    int count = 0;

    public int inversePairs(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return count;
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);

    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i];
            } else {
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            tmp[k++] = arr[i++];
        }

        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        for (int s = 0; s < k; s++) {
            arr[start + s] = tmp[s];
        }
    }
}
