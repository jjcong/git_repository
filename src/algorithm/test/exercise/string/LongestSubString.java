package algorithm.test.exercise.string;

import java.util.HashMap;
import java.util.Map;

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
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int length = s.length();
        int i = 0, j = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (; j < length; ++j){
            if (hashMap.containsKey(s.charAt(j))){
                i = Math.max(hashMap.get(s.charAt(j)) + 1, i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            hashMap.put(s.charAt(j), j);
        }
        return maxLength;
    }

}