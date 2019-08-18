package algorithm.test.exercise;

import java.math.BigInteger;

/**
 * 递归与非递归模式的斐波那契数列实现方式
 *
 * @author  j_cong
 * @date    2018/03/29
 * @version V1.0
 */
public class FibonacciTest {


    public static void main(String[] args) {

//        System.out.println(fibonacci1(100));

        System.out.println(fibonacci2(60));
    }

    /**
     * 递归方式的方法(1, 1, 2)
     *
     * @param n  第n个数列
     * @return   第n个数列表示的具体值
     */
    private static long fibonacci1(long n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 递归方式的方法(1, 1, 2)
     *
     * @param n  第n个数列
     * @return   第n个数列表示的具体值
     */
    private static long fibonacci2(long n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        long former = 1;
        long latter = 1;
        long result = 0;

        for (int i = 3; i <= n; i++) {
            result = former + latter;
            former = latter;
            latter = result;
        }

        return result;
    }

}
