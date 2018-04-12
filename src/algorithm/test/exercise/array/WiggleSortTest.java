package algorithm.test.exercise.array;

import java.util.Arrays;

/**
 * 给你一个没有排序的数组，请将原数组就地重新排列满足如下性质
 * nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * @author  j_cong
 * @date    2018/04/01
 * @version V1.0
 */
public class WiggleSortTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3,4};
//        wiggleSort1(arr);
        partitionArray(arr, 5);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 分析：先将数组快速排序，然后我们发现如果nums元素个数为偶数我们从倒数第二个元素开始与正数第二个元素进行交换，
     * 并且步长都为2.为奇数时将从最后一个元素与正数第二个元素交换，步长为2，即可得到答案。
     *
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        // write your code here
        int length = nums.length;

        quickSort(nums, 0, length - 1);

        int end = length % 2 == 0 ? length - 2 : length - 1;

        int start = 1;

        while (start < end + 1) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start += 2;
            end -= 2;
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = partition(arr, low, high);

        quickSort(arr, low, pivot);
        quickSort(arr, pivot + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];

        }

        arr[low] = pivot;

        return low;
    }

    public static void wiggleSort1(int[] nums) {
        // write your code here
        int length = nums.length;
        if (length == 0) {
            return;
        }

        int[] arr = Arrays.copyOfRange(nums, 0, length);
        Arrays.sort(arr);

        int start = 0;
        int mid = (length - 1) / 2;
        int end = length - 1;

        boolean flag = true;

        //flag 在此处是分别从左右取数的作用，length不可更改
        while (start < length) {

            nums[start++] = flag ?  arr[mid--] : arr[end--];

            flag = !flag;
        }
    }

    public static int partitionArray(int[] nums, int k) {
        // write your code here
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {

                int tmp = nums[i];
                nums[i] = nums[start];
                nums[start] = tmp;

                start++;
            }
        }
        return start;

    }
}
