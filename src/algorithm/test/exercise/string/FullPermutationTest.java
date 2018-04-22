package algorithm.test.exercise.string;

import java.util.*;

/**
 * 字符串的全排列
 *
 * @author  j_cong
 * @date    2018/03/30
 * @version V1.0
 */
public class FullPermutationTest {

    public static void main(String[] args) {

        String str = "ABC";
        System.out.println(str.length());


        fullPermutation(str.toCharArray(), 0, str.length() - 1);
    }


    private static void fullPermutation(char[] source, int start, int end) {

        if (source == null || source.length == 0) {
            return;
        }

        if (start == end) {
//            System.out.println(Arrays.toString(source));
            for (int i = 0; i <= end; i++) {
                System.out.print(source[i] + " ");
            }
            System.out.println();
        } else {
            for (int j = start; j <= end; j++) {

                swap(source, j, start);

                fullPermutation(source, start + 1, end);

                swap(source, j, start);

            }
        }


    }

    private static void swap(char[] source, int start, int end) {
        char tmp = source[start];
        source[start] = source[end];
        source[end] = tmp;
    }


}
