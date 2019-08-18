package algorithm.test.exercise.笔试真题.中国电信;
/**
 * 两个数组的最大重复长度
 *
 * @author  j_cong
 * @date    2018/09/10
 * @version V1.0
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            int len1 = s1.length();
            int len2 = s2.length();
            int maxLen = 0;
            int i = 0;
            if (len1 >= len2) {
                int start = len1 - len2;
                i = start;
            }
            for (; i < len1; i++) {
                int temp = len1 - i;
                String str1 = s1.substring(i, s1.length());
                String str2 = s2.substring(0, temp);
                if (str1.equals(str2)) {
                    if (temp > maxLen) {
                        maxLen = temp;
                        break;
                    }
                }
            }
            if (len2 >= len1) {
                int start = len2 - len1;
                i = start;
            }
            for (; i < len2; i++) {
                int temp = len2 - i;
                String tempS2 = s2.substring(i, s2.length());
                String tempS1 = s1.substring(0, temp);
                if (tempS1.equals(tempS2)) {
                    if (temp > maxLen) {
                        maxLen = temp;
                        break;
                    }
                }
            }
            System.out.println(maxLen);
        }
    }
}
