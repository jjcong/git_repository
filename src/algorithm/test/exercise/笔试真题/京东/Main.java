package algorithm.test.exercise.笔试真题.京东;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();

        for (int i = 0; i < group; i++) {
            if (i % 2 == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
    
}
