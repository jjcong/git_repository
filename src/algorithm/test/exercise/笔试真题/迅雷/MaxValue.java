package algorithm.test.exercise.笔试真题.迅雷;

import java.util.Scanner;

/**
 * 输入A B（A > 0, B < 0）,抽取17张排成一排，使任意七个的数的和<0,
 * 求数组的最大值
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/09/13
 */
public class MaxValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = 0 - b;
        if (a + b * 7 >= 0) {
            System.out.println(b * 17);
            return;
        }

        //一个17块，相邻的7块要小于0
        int[] sum = new int[8];
        for (int i = 0; i <= 7; i++) {
            sum[i] = a * (7 - i) + b * i;
        }
        for (int i = 0; i <= 7; i++) {
            if (sum[i] < 0) {
                c = i;
                break;
            }
        }
        //窗口中，最多有多少个正数（A）
        int index = 7 - c;
        int result = index * a * 2 + b * c * 2 + 3 * a;
        System.out.println(result);
    }

}
