package algorithm.test.exercise.笔试真题.携程;

import java.util.Scanner;

public class NumOf1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        System.out.println(numOf1(num));
    }

    public static int numOf1(long num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= num - 1;
        }
        return count;
    }
}
