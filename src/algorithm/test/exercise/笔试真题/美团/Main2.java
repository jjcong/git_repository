package algorithm.test.exercise.笔试真题.美团;

import java.util.Scanner;

/**
 * 1~n的位数和
 *
 * @author j_cong
 * @version V1.0
 * @date 2018/04/20
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        if (length == 0) {
            System.out.println("");
        }
        for (int i = 0; i < length; i++) {
            long num = scanner.nextInt();
            long curSum = 0;
            int bit = 0;
            while (num >= Math.pow(10, bit)) {
                if (num < Math.pow(10, bit + 1)) {
                    curSum += (bit + 1) * (num - (long) Math.pow(10, bit) + 1);
                } else {
                    curSum += (bit + 1) * ((long) Math.pow(10, bit + 1) - (long) Math.pow(10, bit));
                }
                bit++;
            }
            System.out.println(curSum);
        }
    }

}
