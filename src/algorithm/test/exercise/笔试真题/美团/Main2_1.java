package algorithm.test.exercise.笔试真题.美团;

import java.util.Scanner;

public class Main2_1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        for (int num : nums) {
            printLength(num);
            getLength(num);
        }
    }

    private static void printLength(int num) {

        String s = String.valueOf(num);
        int length = s.length();
        long res = 0;

        if (length == 1) {
            System.out.println(num);
            return;
        }

        if (length == 2) {
            System.out.println(2 * num - 9);
            return;
        }

        for (int i = 0; i <= length - 2; i++) {
            res = (long) (res + (i + 1) * 9 * Math.pow(10, i));
        }

        res += (num - Math.pow(10, length - 1) + 1) * length;

        System.out.println(res);
    }

    /**
     *思路： 1234 = 9 * 10^0 * 1 + 9 * 10^1 * 2  + 9 * 10^2 * 3 + (1234 - 999) * 4
     *
     * @param num
     */
    public static void getLength(int num) {

        String str = String.valueOf(num);
        int length = str.length();
        long sum = 0;

        for (int i = 0; i < length; i++) {

            long tmp = (long) (9 * Math.pow(10, i) * (i + 1));

            if (i == length - 1) {
                tmp = (long) (num - Math.pow(10, i) + 1) * (i + 1);
            }
            sum += tmp;
        }

        System.out.println(sum);

    }
}
