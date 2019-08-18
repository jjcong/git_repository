package algorithm.test.exercise.笔试真题.美团;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;

/**
 * 第一行为三个数，分别为a的个数n,z的个数m,第k个字符串。
 *
 * @author  j_cong
 * @date    2018/08/12
 * @version V1.0
 */
public class FindKthCompostion {
    private static TreeSet<String> res = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aNum = scanner.nextInt();
        int zNum = scanner.nextInt();
        int k = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < aNum; i++) {
            sb.append("a");
        }
        for (int i = 0; i < zNum; i++) {
            sb.append("z");
        }

        TreeSet<String> result = permutation(sb.toString());

        if(result.size() < k) {
            System.out.println(-1);
        }

        int cur = 0;
        for (String src : result) {
            if (cur == k - 1) {
                System.out.println(src);
            }
            cur++;
        }

    }

    public static TreeSet<String> permutation(String str) {
        if (str == null || str.length() == 0) {
            return  res;
        }
        permutation(str, 0, str.length());

        return  res;
    }

    public static void permutation(String str, int start, int end) {
        char[] chars = str.toCharArray();
        String word = null;
        if (start == end) {
            res.add(String.valueOf(chars));
        } else {

            for (int i = start; i < end; i++) {
                if (isSwap(chars,start, i)) {
                    swap(chars, start, i);
                    permutation(String.valueOf(chars), start + 1, end);
                    swap(chars, start, i);
                }

            }
        }

    }

    public static void swap(char[] arr, int m, int n) {
        char tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static boolean isSwap(char[] arr, int start, int i) {
        for (int j = start; j < i ; j++) {
            if (arr[j] == arr[i]) {
                return false;
            }
        }
        return true;
    }
}
