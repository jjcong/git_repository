package algorithm.test.exercise.笔试真题.链家;
import java.util.Scanner;
import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {

            int num = in.nextInt();

            int[] hs = new int[num];

            for (int i = 0; i < num; i++) {
                hs[i] = in.nextInt();
            }
            Arrays.sort(hs);
            int sum=0;
            for (int i=1 ;i<hs.length;i++) {
                sum+=hs[i];
            }
            System.out.println(sum);
        }

    }
}
