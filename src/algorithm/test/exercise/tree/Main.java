package algorithm.test.exercise.tree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 0;
        int b = 0;
        Scanner in = new Scanner(System.in);
        String aString = in.nextLine();
        String[] cs = aString.split(" ");

        int count = getPair(Integer.valueOf(cs[0]), Integer.valueOf(cs[1]));
        System.out.println(count);
    }

    private static int getPair(int a, int b) {
        // TODO Auto-generated method stub
        int count = 0;
        for (int i = 1; i <= a; i++) {
            int temp = i;
            int form = 0;
            while (temp <= a) {
                int c = temp - (b + form);
                if (c > 0) {
                    count += c;
                }
                //count  += ;
                form = temp;
                temp = temp + i;
            }
            if (temp > a) {
                int c = a - (b + form) + 1;
                if (c > 0) {
                    count += c;
                }
            }
        }
        return count;
    }


}
