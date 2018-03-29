package algorithm.test.exercise;
/**
 * 递归与非递归模式的斐波那契数列实现方式
 *
 * @author  j_cong
 * @date    2018/03/29
 * @version V1.0
 */
public class FibonacciTest {


    public static void main(String[] args) {

        System.out.println(fibonacci1(6));
        System.out.println(fibonacci2(6));
    }

    /**
     * 递归方式的方法
     *
     * @param n  第n个数列
     * @return   第n个数列表示的具体值
     */
    private static int fibonacci1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 递归方式的方法
     *
     * @param n  第n个数列
     * @return   第n个数列表示的具体值
     */
    private static int fibonacci2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int former = 1;
        int latter = 1;
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = former + latter;
            former = latter;
            latter = result;
        }

        return result;
    }

}
