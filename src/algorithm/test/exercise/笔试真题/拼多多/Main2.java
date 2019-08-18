package algorithm.test.exercise.笔试真题.拼多多;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = in.nextLine().toCharArray();
        }
        for (int j = 0; j < chars[0].length; j++) {
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i][j] == 'o') {
                    count++;
                    chars[i][j] = '.';
                } else if (chars[i][j] == 'x') {
                    if (count > 0) {
                        for (int k = i - 1; k >= i - count; k--) {
                            chars[k][j] = 'o';
                        }
                        count = 0;
                    }
                }
            }
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.println(String.valueOf(chars[i]));
        }
    }
}
