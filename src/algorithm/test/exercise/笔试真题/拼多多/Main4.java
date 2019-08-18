package algorithm.test.exercise.笔试真题.拼多多;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
/**
 * 从给定大写字母中抽取一个组成字符串，求组成字典序最小的字符串
 * 
 * @author  j_cong
 * @date    2018/08/31
 * @version V1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = in.nextLine().toCharArray();
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            set.add(String.valueOf(chars[i]));
        }
        char[][] chars2 = new char[m][n];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                chars2[j][i] = chars[i][j];
            }
        }
        for (int i = 0; i < chars2.length; i++) {
            Arrays.sort(chars2[i]);
        }
        for (int i = 0; i < chars2.length; i++) {
            for (int j = 0; j < chars2[0].length; j++) {
                chars[j][i] = chars2[i][j];
            }
        }
        int[] a = new int[m];
        int index = chars[0].length - 1;
        while (index >= 0) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars[0].length; j++) {
                sb.append(chars[a[i++]][j]);
            }
            if (!set.contains(sb.toString())) {
                System.out.println(sb.toString());
                return;
            }
            if (a[index] + 1 < chars.length) {
                a[index]++;
            } else {
                index--;
                if (index >= 0) {
                    a[index]++;
                }
            }
        }
        System.out.println("-");
    }

}
