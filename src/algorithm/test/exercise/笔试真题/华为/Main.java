package algorithm.test.exercise.笔试真题.华为;

import java.util.Scanner;
/**
 * 二十六进制加减法
 *
 * @author  j_cong
 * @date    2018/09/06
 * @version V1.0
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        Long res = getNum(str1) + getNum(str2);

        System.out.println(decimalToTwentysix(res));

    }


    private static StringBuffer decimalToTwentysix(Long n) {
        StringBuffer result = new StringBuffer();

        while (n > 0) {
            Long remainder = n % 26;
            result.append((char) (remainder + 'a'));
            n = n / 26;
        }

        return result.reverse();//字符串反转
    }


    public static Long getNum(String s) {

        Long sum = 0L;
        for (int i = 0; i < s.length(); i++) {
            sum += (long) ((s.charAt(i) - 'a') * Math.pow(26, s.length() - 1 - i));
        }
        return sum;

    }
}

