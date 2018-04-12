package algorithm.test.exercise;
/**
 * 计算A^b
 * 思路：分奇数偶数，然后递归函数
 *
 * @author  j_cong
 * @date    2018/04/02
 * @version V1.0
 */
public class PowerWithExponent {

    public static void main(String[] args) {
          double result = powerWithExponent(2, 7);
        System.out.println(result);
    }

    private static double powerWithExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        double result = powerWithExponent(base, exponent >> 1);
        result *= result;

        //exponent为奇数
        if ((exponent & 1) == 1) {
            result *= base;
        }

        return result;
    }
}
