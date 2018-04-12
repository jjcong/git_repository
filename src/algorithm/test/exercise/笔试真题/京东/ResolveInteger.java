package algorithm.test.exercise.笔试真题.京东;

import java.util.Scanner;

/**
 * 小Q的数学老师给了小Q一个整数N,问小Q能否将W分解为两个整数X和Y相乘，并且满足X为奇数，Y为偶数，
 * 即能否找到奇数X和偶数Y满足X * Y = N
 * 思路：
 *      先判断N是不是奇数，是的话直接返回No，然后Y从2开始，每次乘2，判断X是不是奇数
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/04/11
 */
public class ResolveInteger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        long[] arr = new long[t];

        for (int i = 0; i < t; i++) {
            arr[i] = sc.nextLong();
        }

        for (long tmp : arr) {
            if (tmp % 2 != 0) {
                System.out.println("No");
                break;
            }
            long x;
            long y;

            for (int i = 1; i < tmp / 2; i++) {
                y = i * 2;
                if (tmp % y == 0) {
                    x = tmp / y;
                    if (x % 2 != 0) {
                        System.out.println(x + " " + y);
                        break;
                    }
                }
            }
        }
    }

}
