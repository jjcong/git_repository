package algorithm.test.exercise.笔试真题.美团;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] value = new int[n];
        int[] sleep = new int[n];
        for (int i = 0; i < value.length; i++) {
            value[i] = input.nextInt();
        }
        for (int i = 0; i < sleep.length; i++)
            sleep[i] = input.nextInt();
        int max_value = compute_value(m, value, sleep, n);
        System.out.println(max_value);
    }

    public static int compute_value(int m, int[] value, int[] sleep, int n) {
        int max = 0;
        if (m >= n) {
            for (int i = 0; i < n; i++) {
                max += value[i];
            }
            return max;
        }
        if (m == 0)
            return 0;
        int temp = 0;
        int Max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (sleep[i] == 1)
                max += value[i];
        }
        for (int i = 0; i < m; i++) {
            if (sleep[i] == 0)
                temp += value[i];
        }
        Max = temp;
        int start = 1, end = m + 1;
        while (end <= n) {
            temp = 0;
            for (int i = start; i < end; i++) {
                if (sleep[i] == 0) {
                    temp += value[i];
                }
            }
            if (Max < temp)
                Max = temp;
            start++;
            end++;
        }
        return max + Max;
    }

}
