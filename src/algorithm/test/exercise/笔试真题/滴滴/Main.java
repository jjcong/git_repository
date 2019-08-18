package algorithm.test.exercise.笔试真题.滴滴;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        String src = strs[0];
        List<String>[] buffer = new ArrayList[26];

        for (int i = 1; i < strs.length; i++) {
            int cnt = compare(src, strs[i]);
            if (buffer[cnt] == null) {
                buffer[cnt] = new ArrayList<>();
            }
            buffer[cnt].add(strs[i]);
        }

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != null) {
                System.out.print(src + " ");
                for (int j = 0; j< buffer[i].size(); j++) {
                    Collections.sort(buffer[i]);
                    System.out.print(buffer[i].get(j) + " ");
                }
                break;
            }
        }
    }

    private static int compare(String str, String target) {

        int d[][]; // 矩阵

        int n = str.length();

        int m = target.length();

        int i;

        int j;

        char ch1;

        char ch2;

        int temp;

        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        d = new int[n + 1][m + 1];

        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++) {
            ch1 = str.charAt(i - 1);

            for (j = 1; j <= m; j++) {
                ch2 = target.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } else {
                    temp = 1;
                }
                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + temp);
            }

        }

        return d[n][m];

    }

}
