package algorithm.test.exercise.笔试真题.迅雷;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;


        for (int i = 1; i < num; i++) {
            for (int j = i; j < num; j++) {
                if (i + j >= num) break;
                for (int k = j ; k < num; k++) {
                    if  (i + j + k > num) break;
                    if (i * i + j *j == k * k) {
                        if (check(i, j) && check(j, k)) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }



    public static boolean check(int m, int n)
    {
        return check2(m > n ? m : n, m <= n ? m : n);
    }

    public static boolean check2(int max, int min)
    {
        int mo = max % min;
        if (mo == 0) {
            return min == 1 ? true : false;
        }
        else {
            return check2(min, mo);
        }
    }


}
