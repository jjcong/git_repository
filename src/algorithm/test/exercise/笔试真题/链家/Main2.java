package algorithm.test.exercise.笔试真题.链家;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        Long len = div(N, M);
        System.out.println((len * (len + 1) / 2) % (Math.pow(10, 9) + 7));

    }


    public static long div(int num, int target) {
        long res = 0;
        for (int i = 1; i <= target; i++) {
            if(target % i == 0) {
                res++;
            }
        }
        return res;
    }
}
