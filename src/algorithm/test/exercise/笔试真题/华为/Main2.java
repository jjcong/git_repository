package algorithm.test.exercise.笔试真题.华为;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println(jump(a));

    }

    public static int jump(int[] A) {
        // write your code here
        if (A.length <= 1) {
            return 0;
        }
        int i = 0, j = 0;
        int count = 0;
        while (i < A.length) {
            if (i + A[i] >= A.length - 1) {
                count++;
                return count;
            }
            int temp = Integer.MIN_VALUE;
            for (int k = i + 1; k <= i + A[i]; k++) {
                if (temp < k + A[k]) {
                    temp = k + A[k];
                    j = k;
                }
            }
            i = j;
            count++;
        }
        return 0;
    }
}

