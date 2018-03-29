package algorithm.test.exercise.string;
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

        String num1 = "10";
        String num2 = "2";

        System.out.println(multiply(num1, num2));

    }

    public static String multiply(String num1, String num2) {

        Long a = strToNum(num1);
        Long b = strToNum(num2);

        if (a >= Double.MAX_VALUE || b >= Double.MAX_VALUE) {
            return String.valueOf(a);
        }

        if (a <= Long.MIN_VALUE || b <= Long.MIN_VALUE) {
            return String.valueOf(a);
        }



        Long result = a * b;

        if (result >= Long.MAX_VALUE) {
            return  String.valueOf(result);
        }

        if (result <= Long.MIN_VALUE) {
            return String.valueOf(result);
        }

        return String.valueOf(result);
    }

    public static Long strToNum(String str) {

        if (str == null || str.length() == 0) {
            return 0L;
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

        Long number = 0L;

        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            number = number * 10 + (str.charAt(index) - '0');

            if (number >= Long.MAX_VALUE) {
                break;
            }
        }

        if (number * sign <= Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }

        if (number * sign >= Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }

        return number * sign;

    }
}
