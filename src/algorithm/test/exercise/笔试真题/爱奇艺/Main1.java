package algorithm.test.exercise.笔试真题.爱奇艺;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split("");
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        int formerSum = arr[0] + arr[1] + arr[2];
        int latterSum = arr[3] + arr[4] + arr[5];
        if (formerSum == latterSum) {
            System.out.println(0);
            return;
        }
        int diff = Math.abs(formerSum - latterSum);
        if (diff > 0 && diff <= 9) {
            System.out.println(1);
            return;
        } else if (diff > 9 && diff <= 18) {
            System.out.println(2);
            return;
        } else {
            System.out.println(3);
            return;
        }
    }
}
