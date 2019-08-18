package algorithm.test.exercise.笔试真题.吉比特;

import java.util.Scanner;

/**
 * 按照a-z1-9排序
 *
 * @author  j_cong
 * @date    2018/07/28
 * @version V1.0
 */
public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();

        char[] word = src.toCharArray();
        for (int i = 0; i < word.length - 1; i++) {
            for (int j = 0; j < word.length - 1 - i; j++) {
                if ((word[j] <= '9' && word[j + 1] >= 'a')
                        ||(word[j] > word[j + 1] && word[j] <= '9')
                        ||((word[j] > word[j + 1] && word[j + 1] >= 'a'))) {
                    char tmp = word[j];
                    word[j] = word[j + 1];
                    word[j + 1] = tmp;

                }
            }
        }
        System.out.println(new String(word));
    }
}
