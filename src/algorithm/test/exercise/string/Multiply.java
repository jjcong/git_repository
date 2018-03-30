package algorithm.test.exercise.string;

import java.math.BigInteger;

/**
 * 给定以字符串表示的两个数字，将数字的乘法作为字符串返回。
 *    注意：数字可以是任意大的，并且是非负的。
 *
 * @author  j_cong
 * @date    2018/03/28
 * @version V1.0
 */
public class Multiply {

    public static void main(String[] args) {

        String num1 = "135547468757856457647568578578";
        String num2 = "265468578679";
        String num3 = "1.0";
        System.out.println();

        System.out.println(multiply(num1, num2));
        System.out.println(atoi(num3));

    }

    public static String multiply(String num1, String num2) {

        BigInteger a = strToNum(num1);
        BigInteger b = strToNum(num2);

        BigInteger result = a.multiply(b);

        return String.valueOf(result);
    }

    public static BigInteger strToNum(String str) {

        if (str == null || str.length() == 0) {
            return BigInteger.valueOf(0);
        }

        str = str.trim();

        int sign = 1;
        int index = 0;


        if ("+".equals(str.charAt(index))) {
            index++;
        } else if ("-".equals(str.charAt(index))) {
            sign = -1;
            index++;
        }

        BigInteger number = BigInteger.valueOf(0);

        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            int tmp = str.charAt(index) - '0';

            number = number.multiply(BigInteger.valueOf(10))
                    .add (BigInteger.valueOf(tmp));
        }

        number = number.multiply(BigInteger.valueOf(sign));

        return number;

    }

    public static int atoi(String str) {
        // write your code here
        str = str.trim();
        int length = str.length();

        if (str == null || length == 0) {
            return 0;
        }
        int index = 0;
        int sign = 1;

        if ('+' == (str.charAt(index))) {
            index++;
        } else if ('-' == (str.charAt(index))) {
            sign = -1;
            index++;
        }

        int result = 0;

        for (;index < length; index++) {

            if (str.charAt(index) == '.') {
                break;
            }
            if (str.charAt(index) == '+' || str.charAt(index) == '-') {
                return 0;
            }

            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                continue;
            }

            if (result < Integer.MAX_VALUE / 10) {
                result = result * 10 + str.charAt(index) - '0';
            } else {
                return sign * Integer.MAX_VALUE;
            }

        }

        return result;
    }

}
