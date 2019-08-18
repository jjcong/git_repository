package algorithm.test.exercise.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定字符串，求能构成的最长回文字符串，
 * 思想：只有双数才能构成回文，统计字母出现的次数，如果最后有字母落单，总长度+1
 *
 * @author  j_cong
 * @date    2018/09/13
 * @version V1.0
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaabbafac"));
    }

    public static int longestPalindrome(String str) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!set.add(c)) {
                set.remove(c);
                count++;
            }
        }

        return set.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
