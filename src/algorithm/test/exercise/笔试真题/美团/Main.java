package algorithm.test.exercise.笔试真题.美团;

/**
 * 最大公约数，只通过90%
 *
 * @author j_cong
 * @date 2018/04/20
 * @version V1.0
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        int[] array = new int[N];
        array[0] = p;

        for (int i = 1; i < N; i++) {
            array[i] = (array[i - 1] + 153) % p;
        }


        long maxCommon = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (array[i] % array[j] == 0) {
                    maxCommon += array[j - 1];
                } else if (array[j] % array[i] == 0) {
                    maxCommon += array[i - 1];
                } else {
                    maxCommon += array[gcd(i, j) - 1];
                }
            }
        }

        System.out.println(maxCommon);
    }


    public static int gcd(int m, int n) {

        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }

        int result = n == 0 ? m : gcd(n, m % n);

        return result;
    }
}
