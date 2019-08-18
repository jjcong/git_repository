package algorithm.test.exercise.笔试真题.中国电信;

import java.util.Scanner;

public class UglyNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(getUglyNumber(num));
    }

    public static int getUglyNumber(int index) {
        if (index < 1) {
            return 0;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int left = 0;
        int mid = 0;
        int right = 0;

        for (int i = 1; i < index; i++) {
            arr[i] = getMin(arr[left] * 2, arr[mid] * 3, arr[right] * 5);

            if (arr[i] == arr[left] * 2) {
                left++;
            }
            if (arr[i] == arr[mid] * 3) {
                mid++;
            }
            if (arr[i] == arr[right] * 5) {
                right++;
            }
        }
        return arr[index - 1];
    }

    public static int getMin(int num1, int num2, int num3) {
        int min = num1 > num2 ? num2 : num1;
        min = min > num3 ? num3 : min;
        return min;
    }
}
