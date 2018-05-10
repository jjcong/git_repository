package algorithm.test.exercise;

import java.util.ArrayList;

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
        double result = Power(2, -7);
        System.out.println(result);
    }

    public static double Power(double base, int exponent) {

        int exp = Math.abs(exponent);

        if (0 == exp) {
            return 1;
        }
        if (1 == exp) {
            return base;
        }

        double res = Power(base, exp >> 1);

        res *= res;

        if((exp & 1) == 1) {
            res *= base;
        }

        return exponent > 0 ? res : 1 / res;
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        res = Permutation(str.toCharArray(),  0, str.length() - 1);
        return res;
    }

    public ArrayList<String> Permutation(char[] chars, int start, int end) {
        ArrayList<String> res = new ArrayList<>();
        if (start == end) {
            res.add(new String(chars));
        } else {
            for (int j = start; j <= end; j++) {
                swap(chars, j, start);
                Permutation(chars, start + 1, end);
                swap(chars, j, start);
            }
        }
        return res;
    }

    public void swap(char[] chars, int m, int n) {
        char tmp = chars[m];
        chars[m] = chars[n];
        chars[n] = tmp;
    }
}
