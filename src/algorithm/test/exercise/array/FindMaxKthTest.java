package algorithm.test.exercise.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在无序有重复数组中寻找最大的第K个数
 *
 * @author  j_cong
 * @date    2018/08/25
 * @version V1.0
 */
public class FindMaxKthTest {

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,4,7,6};
        find_k(6,arr,0, arr.length - 1);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low < high) {
            while (low < high && pivot <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && pivot >= arr[low]) {
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = pivot;

        return low;
    }

    /**
     * 平均时间复杂度为O(n)，最坏情况下为O(n^2)。
     * @param k
     * @param arr
     * @param low
     * @param high
     */
    public static void find_k(int k, int[] arr, int low, int high) {

        int pivot = partition(arr, low, high);

        if (pivot == k - 1) {
            System.out.println(arr[pivot]);
        } else if (pivot > k - 1) {
            find_k(k, arr, low, pivot - 1);
        } else {
            find_k(k, arr, pivot + 1, high);
        }
    }


    /**
     * 时间复杂度为O(nlog(k))，空间复杂度为 O(k) 。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i : arr) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 时间复杂度为O(nlog(n))
     *
     * @param arr
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] arr, int k) {

        Arrays.sort(arr);
        return arr[arr.length - k];
    }

}
