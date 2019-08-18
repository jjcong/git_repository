package algorithm.test.exercise.笔试真题.运满满;
/**
 * 小熊吃糖，leetCode原题
 * 
 * @author  j_cong
 * @date    2018/09/20
 * @version V1.0
 */
import java.util.*;

public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            int mmonkeyNum = scanner.nextInt();
            int appleNum = scanner.nextInt();
            int[] energy = new int[appleNum];

            for (int i = 0; i < appleNum; i++) {
                energy[i] = scanner.nextInt();
            }

            Arrays.sort(energy);

            int[][] monkeyArr = new int[mmonkeyNum][2];
            int[][] monkeyArr1 = new int[mmonkeyNum][2];
            for (int i = 0; i < mmonkeyNum; i++) {
                for (int j = 0; j < 2; j++) {
                    monkeyArr[i][j] = scanner.nextInt();
                }
                monkeyArr1[i][0] = monkeyArr[i][0];
                monkeyArr1[i][1] = i;
            }

            Arrays.sort(monkeyArr1, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {

                    return o2[0] - o1[0];
                }
            });

            solution(energy, monkeyArr, monkeyArr1);
        }
    }


    private static void solution(int[] energy, int[][] monkey, int[][] monkeyArr1) {

        for (int i = 0; i < monkeyArr1.length; i++) {
            int index = monkeyArr1[i][1];
            int tmp = monkey[index][1];

            for (int j = energy.length - 1; j >= 0; j--) {
                if (tmp - energy[j] >= 0) {
                    tmp -= energy[j];
                    energy[j] = 0;
                }
            }
            monkey[index][1] = tmp;
        }

        for (int i = 0; i < monkeyArr1.length; i++) {
            System.out.println(monkey[i][1]);
        }
    }
}
