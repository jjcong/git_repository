package algorithm.test.exercise;

import java.util.Arrays;

/**
 * 获取数组局部最小值，获取任意一个即可
 *
 * @author  j_cong
 * @date    2018/08/12
 * @version V1.0
 */
public class LessMin {

    public static void main(String[] args) {

        String str = "I have a dream!";
        String[] word = str.split(",");


        int[] arr = new int[]{2, 9, 12, 16, 25};
        System.out.println(Arrays.toString(arr));
        System.out.println(getLessMin(arr));

        int num = Arrays.binarySearch(arr, 3);
        System.out.println(num);
    }
    public static int getLessMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int left = 1;
        int right = arr.length - 2;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return left;
    }
}
