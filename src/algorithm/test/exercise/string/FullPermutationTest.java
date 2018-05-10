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

        String str = "AABC";
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

                if (j != start && source[j] == source[start]) {
                    continue;
                }

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


    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }

        Permutation(str.toCharArray(), 0, res);
        Collections.sort(res);

        return res;
    }

    public ArrayList<String> Permutation(char[] cs, int start, List<String> list) {
        ArrayList<String> res = new ArrayList();
        if (start == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int j = start; j < cs.length; j++) {
                swap(cs, start, j);
                Permutation(cs, start + 1, list);
                swap(cs, start, j);
            }
        }
        return res;
    }



}
