package algorithm.test.exercise.笔试真题.拼多多;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int hp = sc.nextInt();
        int n = sc.nextInt();
        int b = sc.nextInt();
        int count = 0;
        if (n * 2 >= b) {
            int s = hp / n;
            int c = hp % n;
            if (c == 0) {
                count = s;
                System.out.println(count);
            } else {
                count = s + 1;
                System.out.println(count);
            }
        } else {
            int s1 = (hp / b) * 2;
            int leave = hp % b;
            if (leave == 0) {
                count = s1;
                System.out.println(count);
            } else if (leave <= n) {
                count = s1 + 1;
                System.out.println(count);
            } else {
                count = s1 + 2;
                System.out.println(count);
            }
        }
    }
}