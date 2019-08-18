package algorithm.test.exercise.笔试真题.网易;

import java.util.Scanner;

/**
 * 给定两个水杯，容量分别为A和B，求如何倒出C
 * 思想：不断用小桶装水倒入大桶，大桶满了立即清空，每次判断下二个桶中水的容量是否等于指定容量
 * @author  j_cong
 * @date    2018/08/14
 * @version V1.0
 */
public class PourWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        boolean res = C < Math.max(A, B) && (C % (gcd(A, B)) == 0);
        System.out.println(res);
    }



    public static int gcd(int m, int n) {

        return  n == 0 ? m : gcd(n, m % n);
    }
}
