package scanner.test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Scanner一行输入多个数值
 *
 * @author  j_cong
 * @date    2018/03/28
 * @version V1.0
 */
public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

/*        int n = 0;
        if (in.hasNext()) {
            n = in.nextInt();
            in.nextLine();
        }*/

        Set<String> set = new HashSet<>();

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            String line = in.nextLine();
            String[] arr = line.trim().split(" ");


            for (int j = 0; j < arr.length; j++) {
                sum += Integer.valueOf(arr[j]);
            }
        }

        System.out.println("sum = " + sum);
    }
}
