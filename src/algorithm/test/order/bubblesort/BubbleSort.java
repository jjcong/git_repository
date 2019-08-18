package algorithm.test.order.bubblesort;

/**
 * 冒泡排序
 *
 * @author j_cong
 * @version V1.0
 * @date 2017/09/14
 */
public class BubbleSort {

    /**
     * 冒泡排序,最简单粗暴的一种，但是效率最低，每一趟都要比较
     *
     * @param a 待排序的数组
     * @param n 数组的长度
     */
    public static void bubbleSort1(int[] a, int n) {
        int i, j;

        for (i = n - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }


    /**
     * 冒泡排序，改进版，从首尾逼近，并且增加交换标记，可大幅度提高数组在有序时的效率
     *
     * @param a 待排序的数组
     * @param n 数组的长度
     */
    private static void bubbleSort2(int[] a, int n) {
        int flag;      //标记

        for (int i = n - 1; i > 0; i--) {
            //初始化标记为0
            flag = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;

                    //若发生交换，则标记为1
                    flag = 1;
                }
            }

            if (flag == 0) {
                break;         //若没发生交换，说明数组已经有序
            }
        }
    }

    public static void bubbleSort3(int[] arr, int n) {

        boolean flag = false;
        int length = arr.length;

        for (int i = 0; i < length; i++) {

            for (int j = length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;

                    flag = true;
                }
            }
            //数据已经有序，直接退出程序
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 使用一层for循环，每次循环到times-1，则重置i
     *
     * @param arr
     * @param n
     */
    public static void bubbleSort4(int[] arr, int n) {

        int times = arr.length - 1;

        for (int i = 0; i < times; i++) {

            if (arr[i + 1] < arr[i]) {
                int tmp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = tmp;
            }
            if (i == times - 1) {
                i = -1;
                times--;
            }
        }
    }


    public static void main(String[] args) {

        int[] a = {20, 40, 30, 10, 60, 50};

        System.out.println("Before sort:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        bubbleSort4(a, a.length);

        System.out.println("After sort:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
