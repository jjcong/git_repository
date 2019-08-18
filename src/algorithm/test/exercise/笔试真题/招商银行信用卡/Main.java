package algorithm.test.exercise.笔试真题.招商银行信用卡;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        if (s1.length == 0 || s2.length == 0) {
            System.out.println(0);
            return;
        }
        int[] appetite = new int[s1.length];
        int[] size = new int[s2.length];
        for (int i = 0; i < appetite.length; i++) {
            appetite[i] = Integer.parseInt(s1[i]);
        }
        for (int j = 0; j < size.length; j++) {
            size[j] = Integer.parseInt(s2[j]);
        }

        System.out.println(findContentChildren(appetite, size));
    }



    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }
}
