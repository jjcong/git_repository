package algorithm.test.exercise.剑指offer;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 5, 10, 20, 50};
        int aim = sc.nextInt();

        System.out.println(changeMoney(arr, 0, aim));
    }

    public static int changeMoney(int[] arr, int index, int aim) {
        int res = 0;
        if (index == 5) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += changeMoney(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }
}
