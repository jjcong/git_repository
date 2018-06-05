package algorithm.test.exercise.string;
/**
 * 字符串数组中最长的公共子串
 *
 * @author  j_cong
 * @date    2018/05/15
 * @version V1.0
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] str = {"flower", "fl", "flight"};
        System.out.println(longestCommonPrefix2(str));
    }
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        int minLen = res.length();
        for (int k = 1; k < strs.length; k++) {
            int len = strs[k].length();
            minLen = len < minLen ? len : minLen;
        }
        int i ;
        for (i = 0;i < minLen; i++) {
            char tmp = res.charAt(i);
            for (int j = 1; j < strs.length; j++) {

                if (strs[j].charAt(i) != tmp) {
                    return res.substring(0, i);
                }
            }
        }

        return res.substring(0, i);
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
             while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }

}
