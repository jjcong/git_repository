package scanner.test;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第一行为两个整数
 * 第二行为n个整数，表示集合a的元素
 * 第三行为m个整数，表示集合b的元素
 * 例如 ：
 *      3 5
 *      1 2 5
 *      2 3 4 5 6
 *
 * @author  j_cong
 * @date    2018/03/30
 * @version V1.0
 */
public class ScannerInputTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        int[] brr = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            brr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < m; i++) {
            System.out.print(brr[i] + " ");
            ;
        }
    }
}
