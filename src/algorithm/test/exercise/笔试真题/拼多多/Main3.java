package algorithm.test.exercise.笔试真题.拼多多;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求循环小数的起始index和循环节的长度
 * 
 * @author  j_cong
 * @date    2018/08/31
 * @version V1.0
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> res = getLength(m, n);

        System.out.println(res.get(0) + " " +  res.get(1));

    }

    public static List<Integer> getLength(int n, int m) {

        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        n = n % m;
        if (n == 0) {
            res.add(0);
            res.add(0);
            return res;
        }

        for (;;) {
            list.add(n);
            n *= 10;
            n = n % m;
            if (n == 0) {
                res.add(list.size());
                res.add(0);
                return res;
            }

            if (list.indexOf(n) >= 0) {
                res.add(list.indexOf(n));
                res.add(list.size() - list.indexOf(n));

                return res;
            }

        }
    }
}
