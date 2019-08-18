package algorithm.test.exercise.string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 字符串中无重复的最长子串长度
 * 
 * @author  j_cong
 * @date    2018/04/14
 * @version V1.0
 */
public class LongestSubString {

    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(lengthOfLongestSubstring(str));
        System.out.println(lengthOfLongestSubstring1(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int length = s.length();
        //前一个不含重复字符的长度
        int preLen = 0;
        //存储字符——>该字符最后出现的索引
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int j = 0; j < length; ++j){
            char c = s.charAt(j);
            if (hashMap.containsKey(c)){
                preLen = Math.max(hashMap.get(c) + 1, preLen);
            }
            maxLength = Math.max(maxLength, j - preLen + 1);
            hashMap.put(c, j);
        }
        return maxLength;
    }


    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndex = new int[26];
        Arrays.fill(preIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int preI = preIndex[c];
            if (-1 == preI || i - preI > curLen) {
                curLen++;
            } else {
                maxLen = Math.max(maxLen, curLen);
                curLen = i - preI;
            }
            preIndex[c] = i;
        }

        return Math.max(maxLen, curLen);
    }

}