package algorithm.test.exercise.笔试真题.华为;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        System.out.println(multiply(s1, s2));
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] num = new int[len1 + len2];
        int n = num.length;

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                //不考虑进位
                num[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }

        //确保每个数字大小在0~9之间
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            num[i] += carry;
            carry = num[i] / 10;
            num[i] = num[i] % 10;
        }
        String result = "";
        boolean firstNonzero = false;

        //将数组转换为字符串，如果第一位是0，去掉
        for (int i = 0; i < n; i++) {
            //找出第一个非0的数字
            if (!firstNonzero && num[i] == 0)
                continue;
            else {
                result += num[i];
                firstNonzero = true;
            }
        }

        if (result.equals("")) {
            return "0";
        }

        return result;

    }
}

