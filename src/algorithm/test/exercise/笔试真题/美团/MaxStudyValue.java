package algorithm.test.exercise.笔试真题.美团;


import java.util.Scanner;

/**
 * 输入描述
 * https://fengxc.me/2018%E7%BD%91%E6%98%93%E7%AC%94%E8%AF%95%E9%A2%98%E5%8F%8A%E8%A7%A3%E7%AD%94-Java.html
 * 第一行n，k, (1 <= n, k <= 105)，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n个数，a1,a2,…,an(1<=ai<=104)，表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n个数，t1,t2,…,tn，表示每分钟小易是否清醒，1表示清醒。
 *
 * 输出描述
 * 小易这堂课听到的知识点的最大兴趣值。
 * 
 * @author  j_cong
 * @date    2018/08/12
 * @version V1.0
 */
public class MaxStudyValue {

    /**
     * 方法一，每次遍历后面的k个数
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        int[] sleep = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        for (int j = 0; j < n; j++) {
            sleep[j] = sc.nextInt();
        }

        System.out.println(maxStudy(scores, sleep, k));
        System.out.println(maxStudy1(scores, sleep, k));

    }

    public static int maxStudy(int[] scores, int[] sleep, int k) {

        int sum = 0;
        int max = -1;
        int n = scores.length;

        for (int s = 0; s < n; s++) {
            if (sleep[s] == 1) {
                sum += scores[s];
            }
        }

        for (int i = 0; i < n; i++) {
            if (sleep[i] == 0) {
                int cur = sum;
                for (int j = i; j < Math.min(i + k, n); j++) {
                    if (sleep[j] == 0) {
                        cur += scores[j];
                    }
                }
                max = Math.max(max, cur);
            }

        }

       return max;
    }

    /**
     * 我们首先定义3个数组，长度都为n。
     * leftScore: 表示从左到右醒着的分值的累加和。
     * rightScore: 表示从右到左醒着的分值的累加和。
     * total: 表示从左到右分数的累加和。
     * 然后当我们遍历到为未醒着的位置i时，那么这时的总体分数为3部分之和：
     * leftScore[i-1] + rightScore[i+k] + (total[i+k-1] - total[i-1])。
     *
     * @param scores
     * @param sleep
     * @param k
     * @return
     */
    public static int maxStudy1(int[] scores, int[] sleep, int k) {

        int sum = 0;
        int max = -1;
        int n = scores.length;
        int[] leftScore = new int[n];
        int[] rightScore = new int[n];
        int[] totalScore = new int[n];

        for (int s = 0; s < n; s++) {
            if (sleep[s] == 1) {
                sum += scores[s];
            }
            leftScore[s] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sleep[i] == 1) {
                sum += scores[i];
            }
            rightScore[i] = sum;
        }

        sum = 0;
        for (int s = 0; s < n; s++) {
            sum += scores[s];
            totalScore[s] = sum;
        }



        for (int i = 0; i < n; i++) {
            if (sleep[i] == 0) {
                int tmp = 0;
                tmp += (i - 1) < 0 ? 0 : leftScore[i - 1];
                tmp += (i + k) >= n ? 0 : rightScore[i + k];
                tmp += totalScore[Math.min(i + k - 1, n - 1)] - (i - 1 < 0 ? 0 : totalScore[i - 1]);
                max = Math.max(max, tmp);
            }

        }

        return max;
    }
}
