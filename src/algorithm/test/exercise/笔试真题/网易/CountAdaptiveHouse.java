package algorithm.test.exercise.笔试真题.网易;

import java.util.Scanner;
/**
 * n个房子，住户有k个，求左右都有住户的选择树
 *
 * @author  j_cong
 * @date    2018/09/09
 * @version V1.0
 */
public class CountAdaptiveHouse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        for (int i = 0; i < sum; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            solution(n, k);
        }
    }


    public static void solution(int n, int k) {

        int max = k <= n / 2 ? k - 1 : n - k;
        max = Math.max(0, max);

        System.out.println(0 + " " + max);
    }
}
