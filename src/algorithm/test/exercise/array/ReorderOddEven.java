package algorithm.test.exercise.array;

import java.util.*;

/**
 * 调整数组中的偶数，使奇数位于前面，偶数位于后面
 *
 * @author  j_cong
 * @date    2018/04/30
 * @version V1.0
 */
public class ReorderOddEven {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray3(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 第一个思路：类似冒泡算法，前偶后奇数就交换
     *
     * @param array
     */
    public static void reOrderArray1(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) {
                if (array[j - 1] % 2 == 0 && array[j] % 2 == 1) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    /**
     * 时间复杂度为O（n），空间复杂度为O（n）的算法
     * 首先统计奇数的个数
     * 然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始 遍历，填数
     *
     */
    public static void reOrderArray2(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        int[] newArr = new int[length];
        int oddNum = 0;
        int oddStart = 0;

        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 1) {
                oddNum++;
            }
        }
        for (int i = 0; i < length; i++) {
            if (array[i] % 2 == 1) {
                newArr[oddStart++] = array[i];
            } else {
                newArr[oddNum++] = array[i];
            }
        }

        for (int i = 0; i < length; i++) {
            array[i] = newArr[i];
        }
    }

    /**
     * 时间复杂度为O（n），空间复杂度为O（n）的算法
     * 首先统计奇数的个数
     * 然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始 遍历，填数
     *
     */
    public static void reOrderArray3(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }

        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        for (int num : array) {
            if ((num & 1) == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }

        oddList.addAll(evenList);

        for (int i = 0; i < oddList.size(); i++) {
            array[i] = oddList.get(i);
        }

    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }


}
