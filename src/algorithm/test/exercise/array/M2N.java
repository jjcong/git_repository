package algorithm.test.exercise.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入两个整数，计算需要改变对应的二进制位的个数，使得 m = n
 *
 * @author  j_cong
 * @date    2018/04/02
 * @version V1.0
 */
public class M2N {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        int result = count(m, n);
        System.out.println(result);
    }

    /**
     * 分为两步
     * （1）异或获得不相同的位数
     * （2）统计1的个数
     *
     * @param m
     * @param n
     * @return
     */
    private  static int count(int m, int n) {

        int tmp = m ^ n;

        return numOf1(tmp);

    }

    private static int numOf1(int m) {
        int count = 0;
        while (m != 0) {
            count++;
            m &= m -1;
        }
        return count;
    }
}
