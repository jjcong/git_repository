package algorithm.test.exercise.array;

/**
 * 从数组中不重复的随机打印M个数
 *
 * @author  j_cong
 * @date    2018/09/03
 * @version V1.0
 */
public class PrintRandonM {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        PrintRandonM test = new PrintRandonM();
        test.printRanM(arr, 3);

    }


    public void printRanM(int[] arr, int m) {
        if (arr == null || arr.length == 0 || m < 0) {
            return;
        }
        int length = arr.length;
        int count = 0;
        int i = 0;

        while (count < m) {
            i = (int)(Math.random() * (length - count));
            System.out.println(arr[i]);
            swap(arr, i, length - 1 - count);
            count++;
        }
    }

    public void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }
}
