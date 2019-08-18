package algorithm.test.exercise.笔试真题.京东;

import java.util.Scanner;

public class CountBadProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][3];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (matrix[i][0] < matrix[j][0]) {
                        if (matrix[i][1] < matrix[j][1]) {
                            if (matrix[i][2] < matrix[j][2]) {
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(count);

        }
    }
}
