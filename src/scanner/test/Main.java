package scanner.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = Integer.valueOf(scanner.nextLine());
        long[] tests = new long[num];
        for (int i = 0; i < num; i++) {
            tests[i] = Long.valueOf(scanner.nextLine());
        }
        satisfy(tests, num);
    }

    private static void satisfy(long[] tests, int num) {

        for (int i = 0; i < num; i++) {
            calculate(tests[i]);
        }
    }

    private static void calculate(long n) {

        if (n % 2 != 0) {
            System.out.println("No");
        } else {
            long x = n / 2;
            while (x % 2 == 0) {
                x = x / 2;
            }
            System.out.println(x + " " + n / x);
        }
    }

}
