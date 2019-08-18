package algorithm.test.exercise.笔试真题.网易;

import java.util.Scanner;

/**
 * 若干个人过桥，分许需要A,B,C,D,......Z,求最短过桥时间
 * 要么是最快者将最慢的2个送过桥，要么是最快的2个将最慢的2个送过桥
 * https://blog.csdn.net/MoreWindows/article/details/7481851
 * @author  j_cong
 * @date    2018/08/14
 * @version V1.0
 */
public class MinTimeCrossBridge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] person = new int[num];

        for (int i = 0; i < num; i++) {
            person[i] = scanner.nextInt();
        }
        int res = minTime(person);
        System.out.println(res);

    }

    public static int minTime(int[] arr) {

        quickSort(arr, 0, arr.length - 1);
        int sum = 0;
        int first = 0;
        int second = 0;
        int i = 0;
        for(i = arr.length - 1; i > 2; i -= 2) {
            //最小者将最大2个送走
            first = arr[0] + arr[0] + arr[i - 1] + arr[i];
            //最小2个将最大2个送走
            second = arr[0] + arr[1] + arr[1] + arr[i];
            sum += first > second ? second : first;
        }
        if (2 == i) {
            sum += arr[0] + arr[1] + arr[2];
        } else if (1 == i) {
            sum += arr[1];
        } else {
            sum += arr[0];
        }
        return sum;
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }
        int pivot = partition(arr, low, high);

        quickSort(arr, low, pivot - 1);
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

        return  low;
    }

}
