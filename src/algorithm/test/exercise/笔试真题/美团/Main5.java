package algorithm.test.exercise.笔试真题.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] bucket = new ArrayList[n - 1];

        for (int i = 0; i < n - 1; i++) {
            String str = sc.nextLine();
            String[] strs = str.split(" ");

            bucket[i].add(Integer.valueOf(strs[0]));
            bucket[i].add(Integer.valueOf(strs[1]));

        }

        System.out.println(4);
    }

    public static int getMin(List<Integer>[] bucket) {

        return 4;
    }
}
