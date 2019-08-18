package algorithm.test.exercise.笔试真题.招商银行信用卡;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(rotatedDigits(n));
    }

    public static int rotatedDigits(int num) {
        int result = 0;

        for (int i = 1; i <= num; i++) {
            int j = i;
            boolean contains347 = false;
            boolean contains2569 = false;
            while (j != 0) {
                int mod = j % 10;
                if (mod == 2 || mod == 5 || mod == 6 || mod == 9) {
                    contains2569 = true;
                }

                if (mod == 3 || mod == 4 || mod == 7) {
                    contains347 = true;
                }

                j = j / 10;
            }

            if (!contains347 && contains2569) {
                result++;
            }
        }

        return result;
    }
}
