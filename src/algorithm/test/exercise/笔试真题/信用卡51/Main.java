package algorithm.test.exercise.笔试真题.信用卡51;

import java.util.Arrays;
import java.util.Scanner;

/**
 * RDB排序
 * 
 * @author  j_cong
 * @date    2018/05/07
 * @version V1.0
 */
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();

        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }
    }
    public String sortColors(char[] src){
        StringBuilder sb = new StringBuilder();
        Arrays.sort(src);
        for (int i = src.length - 1; i >= 0; i--) {
            sb.append(src[i]);
//            System.out.print(src[i]);
        }
        return sb.toString();
    }

}
