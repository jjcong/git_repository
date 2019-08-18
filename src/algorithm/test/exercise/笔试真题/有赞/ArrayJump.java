package algorithm.test.exercise.笔试真题.有赞;

import java.util.Scanner;

public class ArrayJump {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(",");
        
        int[] a = new int[strings.length];
        a[0] = Integer.parseInt(strings[0].substring(1, strings[0].length()));
        for (int i = 1; i < strings.length - 1; i++) {
            a[i] = Integer.parseInt(strings[i]);
        }
        a[strings.length - 1] = Integer.parseInt(strings[strings.length - 1].substring(0, strings[strings.length - 1].length() - 1));
        int[] flag = new int[a.length];
        int cur = 0;
        flag[cur]++;
        while (true) {
            int jump = a[cur];
            cur += jump;
            flag[cur]++;
            if (flag[cur] > 1) {
                System.out.println("false");
                return;
            }
            if (cur >= a.length || cur < 0) {
                System.out.println("true");
                return;
            }
        }

    }

}
