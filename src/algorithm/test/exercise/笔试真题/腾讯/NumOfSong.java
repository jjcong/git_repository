package algorithm.test.exercise.笔试真题.腾讯;

import thread.test.forkjoin.ForkJoinMergeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * X 首长度为A的歌，Y首长度为B的歌，每种歌只能使用一次，给出总长度K，求组成的方法数
 * 输入：
 * 5
 * 2 3 3 3
 * 输出：
 * 9
 * @author  j_cong
 * @date    2018/07/28
 * @version V1.0
 */
public class NumOfSong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int X = scanner.nextInt();
        int A = scanner.nextInt();
        int Y = scanner.nextInt();
        int B = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < X; i++) {
            list.add(A);
        }
        for (int j = 0; j < Y; j++) {
            list.add(B);
        }

        int[][] dp = new int[K + 1][X + Y + 1];
        dp[0][0] = 1;
        for (int j = 1; j < K + 1 ; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < X + Y + 1; i++) {
            dp[i][1] = list.get(1) == i ? 1 : 0;
        }

        for (int i = 1; i < K + 1; i++) {
            for (int j = 2; j < X + Y + 1; j++) {
                if ( i >= list.get(j -1 )) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - list.get(j - 1)][j - 1]) % 1000000007;
                } else {
                    dp[i][j] = dp[i][j - 1]  % 1000000007;
                }
            }
        }

        System.out.println(dp[K][X + Y]);

    }
}
