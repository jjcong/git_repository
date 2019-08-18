package algorithm.test.exercise.string;
/**
 * 给定字符串，求最长回文子串
 * 思路：以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度
 *
 * @author  j_cong
 * @date    2018/09/13
 * @version V1.0
 */
public class LongestPalindromeSubstring {

    private static int maxLen = 0;
    private static String sub = "";
    public String longestPalindromeSubstring(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            findLongestPalindrome(str, i, i);
            findLongestPalindrome(str, i, i + 1);
        }
        return sub;

    }

    public static void findLongestPalindrome(String s, int low, int high) {
        while (low >= 0 && high < s.length() - 1) {
            if (s.charAt(low) == s.charAt(high)) {
                if (maxLen < high - low + 1) {
                    maxLen = high - low + 1;
                    sub = s.substring(low, high + 1);
                }
                low--;
                high++;
            } else {
                break;
            }
        }
    }

}
